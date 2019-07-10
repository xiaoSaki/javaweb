package com.lingnan.examsys.business.service;

import java.util.Vector;

import com.lingnan.examsys.business.domain.Question_bankVO;

public interface Question_bankService {
	//分页查看题库所有题目 2018/10/14 mai
		public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize,int user_id); 
		//模糊查询试题(根据试题内容) 2018/10/28 mai
		public Vector<Question_bankVO> findQuestion_bankByContent(String Que_content); 
		//根据试题类型查询试题 2018/10/28 mai
		public Vector<Question_bankVO> findQuestion_bankByType(String Que_type);
		//根据试题内容和试题类型查询试题 2018/10/28 mai
		public Vector<Question_bankVO> findQuestion_bankByContentAndType(String Que_content,String Que_type);
		//教师端添加试题 2018/10/24 mai
		public boolean insertQuestion(Question_bankVO qbVO);
		/**
		 * 统计教师试题
		 * @param user_id
		 * @return
		 */
		public int maxQuestion(int user_id);
		//教师端添加试题 2018/10/24 mai
		public boolean delQue_Exam(int que_id);  //根据que_id删除Que_Exam add 2018/11/17
		public boolean delRecord(int que_id);  //根据que_id删除Record add 2018/11/17
		public boolean delQueByque_id(int que_id);  //删除试题 add 2018/11/17
}
