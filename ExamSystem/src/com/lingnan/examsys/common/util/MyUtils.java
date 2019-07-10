package com.lingnan.examsys.common.util;

/**
 * 
* <p>Title: MyUtils</p>
* <p>Description: </p>
* @author   Hellow
* @date		2018年10月28日
* @version 	1.0
 */
public class MyUtils {
	
	/**
	 * 
	* <p>Title: checkAnswer</p>
	* <p>Description: 工具类函数-核对答案</p>
	* @param answer_submit 提交答案
	* @param answer_real   正确答案
	* @return 1-正确；0-错误
	 */
	public static int checkAnswer(String answer_submit,String answer_real) {
		int checkout = 0;
		String[] str_real = answer_real.split("\\|");
		String[] str_submit = answer_submit.split("\\|");
		if(str_real.length!=str_submit.length) return 0;
		for(int i=0;i<str_real.length;i++) {
			for(int y = 0;y<str_submit.length;y++) {
				if(str_real[i].equals(str_submit[y].trim())) {
					checkout++;
					break;
				}
			}
		}
		return checkout==str_real.length?1:0;
	}
}
