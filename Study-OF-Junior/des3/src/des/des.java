package des;

import java.util.Scanner;

/**
 * Created by leif on 2019/5/01 0026.
 */
public class des {
    public static void main(String[] args) {
        System.out.println("**********************************************************");
        System.out.println("                      DES�ӽ��ֲܷ���ʾ                      ");
        System.out.println("**********************************************************");
        System.out.println();
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.print("����������(֧�����ⳤ����ĸ�������)��");
        String mmmmmm = in.nextLine();
        System.out.print("��������Կ(֧�������ʽ����)��");
        String kkkkkk = in.nextLine();
        String[] M = util.all2string(mmmmmm);
        char[] K = util.keypre(kkkkkk);
        descore descore = new descore();
        String mimi = descore.en(M, K);
        String demimi = descore.de(util.all222string(mimi), K);
        String demimistring = util.byte2string(demimi);
        System.out.println("*************************************************");
        System.out.println("**********************���***********************");
        System.out.println("���ģ�"+mmmmmm);
        System.out.println("------------------------------------------------------------");
        System.out.println("���ܽ����");
        System.out.println("�����ƣ�"+ mimi);
        System.out.println("ʮ�����ƣ�"+util.two2hex(mimi));
        System.out.println("------------------------------------------------------------");
        System.out.println("���ܽ����");
        System.out.println("�����ƣ�"+demimi);
        System.out.println("ʮ�����ƣ�"+util.two2hex(demimi));
        System.out.println("�����"+demimistring);
    }

}