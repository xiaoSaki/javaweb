package com.lingnan.examsys.business.service;

import java.sql.Connection;

import com.lingnan.examsys.business.dao.Question_bankDao;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class Quetion_bankServiceImpl implements Quetion_bankService {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	private Quetion_bankServiceImpl() {}
	
	private  static class Quetion_bankServiceImplInstance {
		private static final Quetion_bankServiceImpl instance = new Quetion_bankServiceImpl();
	}
	
	public static Quetion_bankServiceImpl getInstance() {
		return Quetion_bankServiceImplInstance.instance;
	}

	@Override
	public Question_bankVO getQuetionById(int que_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		Question_bankVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			Question_bankDao dao = (Question_bankDao) DaoFactory.getDao(conn,EnumType.QUESTION_BANK_DAO);
			//获取最大页数
			vo = dao.getQuetionById(que_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public int checkAnswer(int que_id, String answer) {
		//数据库连接	 
		Connection conn = null;
		//答题结果
		int end = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			Question_bankDao dao = (Question_bankDao) DaoFactory.getDao(conn,EnumType.QUESTION_BANK_DAO);
			//获取最大页数
			end = dao.checkAnswer(que_id, answer);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return end;
	}

	@Override
	public String getAnswerbById(int que_id) {
		//数据库连接	 
		Connection conn = null;
		//答题结果
		String answer_real = "";
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			Question_bankDao dao = (Question_bankDao) DaoFactory.getDao(conn,EnumType.QUESTION_BANK_DAO);
			//获取最大页数
			answer_real = dao.getAnswerbyId(que_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return answer_real;
	}

	@Override
	public int getMaxChapterNum() {
		//数据库连接	 
		Connection conn = null;
		//答题结果
		int num = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			Question_bankDao dao = (Question_bankDao) DaoFactory.getDao(conn,EnumType.QUESTION_BANK_DAO);
			//获取最大页数
			num = dao.getMaxChapterNum();
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return num;
	}

}
