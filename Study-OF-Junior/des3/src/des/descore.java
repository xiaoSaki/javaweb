package des;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by leif on 2016/3/26 0026.
 */
public class descore {

	public static String groundresult;

	/**
	 * 初始置換
	 * 
	 * @param M
	 *            char[64]
	 * @return char[56]
	 */
	private char[] initReplace(char[] M) {
		char[] tM = new char[64];
		for (int i = 0; i < 64; i++) {
			tM[i] = M[data.IP[i] - 1];
		}
		return tM;
	}

	/**
	 * 密钥置换 1
	 * 
	 * @param K
	 *            char[64]
	 * @return char[56]
	 */
	private char[] keyReplace1(char[] K) {
		char[] tK = new char[64];
		for (int i = 0; i < 56; i++) {
			tK[i] = K[data.PC_1[i] - 1];
		}
		return tK;
	}

	/**
	 * 生成子密钥
	 * 
	 * @param K
	 *            char[56]
	 * @param offset
	 *            左移位数 int
	 * @return char[56]
	 */
	private char[] loopKey(char[] K, int offset) {
		String k1 = new String();
		String k2 = new String();
		String k = new String(K);
		k1 = (k.substring(0, 28) + k.substring(0, 2)).substring(offset,
				offset + 28);
		k2 = (k.substring(28, 56) + k.substring(28, 30)).substring(offset,
				offset + 28);
		return (k1 + k2).toCharArray();
	}

	/**
	 * 密钥置换2
	 * 
	 * @param K
	 *            char[56]
	 * @return char[48]
	 */
	private char[] keyReplace2(char[] K) {
		char[] tK = new char[48];
		for (int i = 0; i < 48; i++) {
			tK[i] = K[data.PC_2[i] - 1];
		}
		return tK;
	}

	/**
	 * 生成16轮的轮密钥
	 * 
	 * @param K
	 *            char[64]
	 * @return
	 */
	private char[][] getKey(char[] K) {
		char[][] tK = new char[16][48];
		char[][] ttK = new char[16][48];
		char[] k1 = new char[56];
		k1 = keyReplace1(K);
		tK[0] = loopKey(k1, data.LeftMove[0]);
		for (int i = 1; i < 16; i++) {
			tK[i] = loopKey(tK[i - 1], data.LeftMove[i]);
		}
		for (int i = 0; i < 16; i++) {
			ttK[i] = keyReplace2(tK[i]);
		}
		return ttK;
	}

	/**
	 * E 表置换（拓展置换）
	 * 
	 * @param R
	 *            char[32]
	 * @return char[48]
	 */
	private char[] eReplace(char[] R) {
		char[] tR = new char[48];
		for (int i = 0; i < 48; i++) {
			tR[i] = R[data.E[i] - 1];
		}
		return tR;
	}

	/**
	 * xor异或操作
	 * 
	 * @param tR
	 *            char[48]
	 * @param K
	 *            char[48] 轮密钥
	 * @return
	 */
	private char[] xor(char[] tR, char[] K) {
		String x = new String();
		for (int i = 0; i < tR.length; i++) {
			x += tR[i] ^ K[i];
		}
		return x.toCharArray();
	}

	/**
	 * s 盒置换
	 * 
	 * @param xorR
	 *            char[48]
	 * @return char[32]
	 */
	private char[] sReplace(char[] xorR) {
		char[][] tR = new char[8][6];

		String sr = new String();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				tR[i][j] = xorR[i * 6 + j];
			}
			int p = util.two2ten(String.valueOf(tR[i][0])
					+ String.valueOf(tR[i][5]));
			int q = util.two2ten(String.valueOf(tR[i][1])
					+ String.valueOf(tR[i][2]) + String.valueOf(tR[i][3])
					+ String.valueOf(tR[i][4]));
			sr += String.format("%04d", Integer.parseInt(Integer
					.toBinaryString(data.S_Box[i][p][q])));
		}
		return sr.toCharArray();
	}

	/**
	 * p 表置换
	 * 
	 * @param sR
	 *            char[32]
	 * @return char[32]
	 */
	private char[] pReplace(char[] sR) {
		char[] pR = new char[32];
		for (int i = 0; i < 32; i++) {
			pR[i] = sR[data.P[i] - 1];
		}
		return pR;
	}

	/**
	 * 终结置换
	 * 
	 * @param R
	 *            char[64]
	 * @return char[64]
	 */
	private char[] init_1Replace(char[] R) {
		char[] tR = new char[64];
		for (int i = 0; i < 64; i++) {
			tR[i] = R[data.IP_1[i] - 1];
		}
		return tR;
	}

	/**
	 * 轮置换
	 * 
	 * @param R
	 *            char[32]
	 * @param K
	 *            char[32]
	 * @return char[32]
	 */
	public char[] core(char[] R, char[] K) {
		char[] eR = eReplace(R);
		groundresult += "Etable置换结果---" + new String(eR) + "-----"
				+ util.two2hex(new String(eR));
		System.out.println("Etable置换结果---" + new String(eR) + "-----"
				+ util.two2hex(new String(eR)));
		System.out.println("轮密钥---" + new String(K) + "-----"
				+ util.two2hex(new String(K)));
		groundresult += "轮密钥---" + new String(K) + "-----"
				+ util.two2hex(new String(K));

		char[] xorR = xor(eR, K);
		System.out.println("xor-1结果---" + new String(xorR) + "-----"
				+ util.two2hex(new String(xorR)));
		groundresult += "xor-1结果---" + new String(xorR) + "-----"
				+ util.two2hex(new String(xorR));

		char[] sR = sReplace(xorR);
		System.out.println("Sbox置换结果---" + new String(sR) + "-----"
				+ util.two2hex(new String(sR)));
		groundresult += "Sbox置换结果---" + new String(sR) + "-----"
				+ util.two2hex(new String(sR));
		char[] pR = pReplace(sR);
		System.out.println("Ptable置换结果---" + new String(pR) + "-----"
				+ util.two2hex(new String(pR)));
		groundresult += "Ptable置换结果---" + new String(pR) + "-----"
				+ util.two2hex(new String(pR));
		@SuppressWarnings("unused")
		String pp = new String(pR);
		return pR;
	}

	// 单字符加密
	public String enCode(char[] M, char[] K) {
		System.out.println("#########################");
		// groundresult +="#########################\n";
		System.out.println(" =====  === == ==  = =   开始加密");

		groundresult += "明文比特流为:\n" + "二进制流\n" + new String(M) + "\n十六进制流\n"
				+ util.two2hex(new String(M));
		groundresult += "\n密钥比特流为:\n" + "二进制流\n" + new String(K) + "\n十六进制流\n"
				+ util.two2hex(new String(K));
		System.out.println("比特流为---" + new String(M) + "-----"
				+ util.two2hex(new String(M)));
		System.out.println("密钥为---" + new String(K) + "-----\n"
				+ util.two2hex(new String(K)));
		groundresult += "\n*******************************************************\n";
		char[][] L = new char[17][32];
		char[][] R = new char[17][32];
		char[][] key = new char[16][48];
		char[] res = new char[64];
		char[] r = new char[64];
		M = initReplace(M);
		System.out.println("IP置换结果---" + new String(M) + "-----"
				+ util.two2hex(new String(M)));
		groundresult += "\nIP置换结果:\n" + new String(M) + "-----\n"
				+ util.two2hex(new String(M));
		key = getKey(K);
		for (int i = 0; i < 32; i++) {
			L[0][i] = M[i];
			R[0][i] = M[i + 32];
		}

		for (int i = 1; i < 17; i++) {
			System.out.println("===================第 " + i
					+ " 轮==================");
			groundresult += "\n===================第 " + i
					+ " 轮==================\n";
			char[] xorR = xor(L[i - 1], core(R[i - 1], key[i - 1]));
			System.out.println("xor-2结果" + new String(xorR) + "-----\n"
					+ util.two2hex(new String(xorR)));
			groundresult += "xor-2结果\n" + "二进制流\n" + new String(xorR)
					+ "\n十六进制流\n" + util.two2hex(new String(xorR));
			for (int j = 0; j < 32; j++) {
				L[i][j] = R[i - 1][j];
				R[i][j] = xorR[j];
			}
		}

		for (int i = 0; i < 32; i++) {
			res[i] = R[16][i];
			res[i + 32] = L[16][i];
		}
		r = init_1Replace(res);
		String rr = new String(r);
		groundresult += "\n终结置换结果:\n" + "二进制流\n" + new String(rr) + "\n十六进制流\n"
				+ util.two2hex(new String(rr));
		System.out.println("\n终结置换结果---\n" + new String(rr) + "-----\n"
				+ util.two2hex(new String(rr)));
		return rr;
	}

	// 单字符解密
	public String deCode(char[] M, char[] K) {
		System.out.println("#########################");

		// groundresult += "#########################\n";
		System.out.println(" =====  === == ==  = =   开始解密==============\n");
		System.out.println("密文比特流为---" + new String(M) + "-----"
				+ util.two2hex(new String(M)));
		System.out.println("密钥为---" + new String(K) + "-----"
				+ util.two2hex(new String(K)));

	    groundresult +=" =====  === == ==  = =   开始解密==============\n";
		groundresult += "\n密文比特流为:\n" + "二进制流\n" + new String(M) + "\n十六进制流\n"
				+ util.two2hex(new String(M));
		groundresult += "\n密钥为:" + "二进制流\n" + new String(K) + "\n十六进制流\n"
				+ util.two2hex(new String(K));
		char[][] L = new char[17][32];
		char[][] R = new char[17][32];
		char[][] key = new char[16][48];
		char[] res = new char[64];
		char[] r = new char[64];
		M = initReplace(M);
		// System.out.println("IP置换结果---"+new String(M)+"-----"+util.two2hex(new
		// String(M)));
		key = getKey(K);
		for (int i = 0; i < 32; i++) {
			L[0][i] = M[i];
			R[0][i] = M[i + 32];
		}
		for (int i = 1; i < 17; i++) {
			System.out.println("===================第 " + i
					+ " 轮==================");
			groundresult += "\n===================第 " + i
					+ " 轮==================\n";
			char[] xorR = xor(L[i - 1], core(R[i - 1], key[16 - i]));
			System.out.println("xor-2结果" + new String(xorR) + "-----"
					+ util.two2hex(new String(xorR)));
			groundresult += "\nxor-2结果\n" + "二进制流\n" + new String(xorR)
					+ "十六进制流\n" + util.two2hex(new String(xorR));
			for (int j = 0; j < 32; j++) {
				L[i][j] = R[i - 1][j];
				R[i][j] = xorR[j];
			}
		}
		for (int i = 0; i < 32; i++) {
			res[i] = R[16][i];
			res[i + 32] = L[16][i];
		}
		r = init_1Replace(res);
		String rr = new String(r);
		System.out.print("\n解密后的明文为:\n" + rr);
		groundresult += "\n解密后的明文为:\n" + rr;
		return rr;

	}
    /*
     * 多字符加密
     */
	public String en(String[] mm, char[] kk) {
		String mi = "";
		char[] charrr = new char[64];
		for (int i = 0; i < mm.length; i++) {
			charrr = mm[i].toCharArray();

		}
		mi += enCode(charrr, kk);
		return mi;
	}

	/*
     * 多字符解密
     */
	public String de(String[] mm, char[] kk) {
		String mi = "";
		char[] charrr = new char[64];
		for (int i = 0; i < mm.length; i++) {
			charrr = mm[i].toCharArray();
		}
		mi += deCode(charrr, kk);
		System.out.print("\n--原文为：" + mi);
		return mi;
	}

	/*
	 * 读取txt文件
	 */
	public String readTxt(String filePath) {
		String str = "";
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(file), "GB2312");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				// 遍历明文
				// System.out.println("3.1 从本地明文为: ");
				while ((lineTxt = br.readLine()) != null) {
					str += lineTxt;
					// array.add(lineTxt);
					System.out.println(lineTxt);
				}
				System.out.println("\r\n");
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}

		// groundresult += " =====  === == ==  = =   开始加密   ===============\n";

		return str;
	}

	/**
	 * 写入TXT，追加写入
	 * 
	 * @param filePath
	 * @param content
	 */
	public void fileChaseFW(String filePath, String content) {
		try {
			// 构造函数中的第二个参数true表示以追加形式写文件

			FileWriter fw = new FileWriter(filePath);
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			System.out.println("文件写入失败！" + e);
		}
	}
}
