package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.Vector;

import com.lingnan.examsys.business.dao.Que_ExamDao;
import com.lingnan.examsys.business.dao.Question_bankDao;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class Question_bankServiceImpl implements Question_bankService{

	//分页查看题库所有题目 2018/10/14 mai
	@Override
	public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize,int user_id) {
		System.out.println("分页查询sevi1");
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		Connection conn = null; 
		try{
			System.out.println("分页查询sevi2");
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			System.out.println("分页查询sevi");
			v = question_bankdao.findAllQuestion_bank(pageNum, pageSize,user_id);
			System.out.println("分页查询dao2");
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.分页查看题库失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return v;
	}

	//模糊查询试题(根据试题内容) 2018/10/28 mai
	@Override
	public Vector<Question_bankVO> findQuestion_bankByContent(String Que_content) {
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			v = question_bankdao.findQuestion_bankByContent(Que_content);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.模糊查询题库失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return v;
	}
	
	//根据试题类型查询试题 2018/10/28 mai
	@Override
	public Vector<Question_bankVO> findQuestion_bankByType(String Que_type) {
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			v = question_bankdao.findQuestion_bankByType(Que_type);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.根据试题类型查询试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return v;
	}
	
	//根据试题内容和试题类型查询试题 2018/10/28 mai
	@Override
	public Vector<Question_bankVO> findQuestion_bankByContentAndType(
			String Que_content, String Que_type) {
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			v = question_bankdao.findQuestion_bankByContentAndType(Que_content, Que_type);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.根据试题内容和试题类型查询试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return v;
	}
	
	//教师端添加试题 2018/10/24 mai
	@Override
	public boolean insertQuestion(Question_bankVO qbVO) {
		
		boolean flag = false;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			flag = question_bankdao.insertQuestion(qbVO);
			
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师端添加试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}
	/**
	 * 统计教师试题
	 */
	public int maxQuestion(int user_id){
		int num;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			num = question_bankdao.maxQuestion(user_id);
			
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.统计教师端试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return num;
	}
	public boolean delQueByque_id(int que_id) {
		boolean flag = false;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			flag = question_bankdao.delQueByque_id(que_id);		
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师端删除试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}

	/**
	 * add mai
	 * add 2018/11/17
	 * 根据que_id删除Que_Exam
	 */
	@Override
	public boolean delQue_Exam(int que_id) {
		boolean flag = false;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			flag = question_bankdao.delQue_Exam(que_id);		
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师端根据que_id删除Que_Exam失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}

	/**
	 * add mai
	 * add 2018/11/17
	 * 根据que_id删除Record
	 */
	@Override
	public boolean delRecord(int que_id) {
		boolean flag = false;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			flag = question_bankdao.delRecord(que_id);	
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师端根据que_id删除Record失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}

}
