package des;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	public static String groundresult;

	/*
	 * 窗体
	 */
	public MyFrame() {
		// TODO Auto-generated constructor stub
		luanch();
	}

	public static void main(String[] args) {
		new MyFrame().luanch();
	}

	JTextField mingwenfield = new JTextField(460);
	JTextField keyfield = new JTextField(460);
	JTextField result = new JTextField(460);
	// JTextArea area = new JTextArea(6,46);
	JLabel content_label = new JLabel("请输入明/密文文件的路径：");
	JLabel key_label = new JLabel("请输入密钥文件的路径：");
	JLabel result_label = new JLabel("                      输出结果为:");
	JLabel process_label = new JLabel("                                 过程：");
	JButton button = new JButton("加密");
	JButton button2 = new JButton("解密");
	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea);
	JLabel keduchi1 = new JLabel("明文支持任意长度字母数字组合");
	JLabel keduchi2 = new JLabel("密钥支持任意长度字母数字组合");
	JPanel panel = new JPanel(null);

	public void luanch() {

                /*
	         * 加密操作按钮监听器
	         */
		button.addActionListener(new ActionListener() {

			@SuppressWarnings("resource")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				descore descore = new descore();
				util util = new util();

				// 明文初始化处理，将每一位转为一个64bit长度的string
				groundresult += "=====  === == ==  = =   开始加密   ===============\n";
				groundresult += "\n读取的明文为:\n"
						+ descore.readTxt(mingwenfield.getText());
				groundresult += "\n读取的密文为:\n"
						+ descore.readTxt(keyfield.getText());

				String[] mingwen = util.all2string(descore.readTxt(mingwenfield
						.getText()));

				String key = descore.readTxt(keyfield.getText());

				/**
				 * 将任意格式的密钥获取hash值，格式化为char[64]
				 * 
				 * @param k
				 * @return
				 */
				char[] K = util.keypre(key);
				// 加密后获取密文
				String mimi = descore.en(mingwen, K);
				String filePath = "d://信息安全数据/miwen.txt";
				descore.fileChaseFW(filePath, mimi);

				/*
				 * //把加密文件转换成二进制文件 String demimi =
				 * descore.de(util.all222string(mimi), K);
				 */
				// 加密结果以十六进制输出
				result.setText(mimi);
				result_label.setText("                      输出结果为:");
				textArea.setText(descore.groundresult);
				descore.groundresult = "";

			}

		});

                 /*
	          * 解密操作按钮监听器
	          */
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				descore descore = new descore();
				util util = new util();
				String mimi = descore.readTxt(mingwenfield.getText());
				String key = descore.readTxt(keyfield.getText());

				char[] K = util.keypre(key);
				// 加密后获取密文
				String demimi = descore.de(util.all222string(mimi), K);

				groundresult += "=====  === == ==  = =   开始解密   ===============\n";
				groundresult += "\n读取的密文为:\n"
						+ descore.readTxt(mingwenfield.getText());
				groundresult += "\n读取的密钥为:\n"
						+ descore.readTxt(keyfield.getText());
				// 将解密后的密文写入硬盘中
				String filePath = "d://信息安全数据/mingwen2.txt";
				descore.fileChaseFW(filePath, demimi);
				String demimistring = util.byte2string(demimi);
				// System.out.println("2编码后："+demimistring);
				// 加密结果以十六进制输出

				result.setText(demimi);
				result_label.setText("                      输出结果为:");
				textArea.setText(descore.groundresult);
				descore.groundresult = "";
			}
		});
        //设置各组件的大小
		textArea.setLineWrap(true);
		content_label.setBounds(30, 20, 200, 30);
		mingwenfield.setBounds(180, 20, 500, 30);
		key_label.setBounds(30, 70, 200, 30);
		keyfield.setBounds(180, 70, 500, 30);
		result_label.setBounds(30, 120, 200, 30);
		result.setBounds(180, 120, 500, 30);
		process_label.setBounds(30, 300, 200, 30);
		button.setBounds(700, 200, 70, 30);
		button2.setBounds(700, 250, 70, 30);
		keduchi1.setBounds(180, 0, 200, 30);
		keduchi2.setBounds(180, 50, 200, 30);
		this.setTitle("DES加解密");
		scroll.setBounds(180, 160, 500, 400);

		//组件添加到面板中
		panel.add(keduchi1);
		panel.add(keduchi2);
		panel.add(content_label);
		panel.add(mingwenfield);
		panel.add(key_label);
		panel.add(keyfield);
		panel.add(result_label);
		panel.add(result);
		panel.add(process_label);
		panel.add(button2);
		panel.add(scroll);
		panel.add(button);
		this.add(panel);
		this.setBounds(300, 50, 800, 700);
		this.setVisible(true);

	}

}
