package com.lingnan.examsys.business.service;

import java.sql.Connection;

import com.lingnan.examsys.business.dao.RecordDao;
import com.lingnan.examsys.business.domain.RecordVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class RecordServiceImpl implements RecordService {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static final RecordService instance = new RecordServiceImpl();
	
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static RecordService getInstance() {
		return instance;
	}

	@Override
	public int createChapterTestRecord(int user_id, int exam_id, int chapter) {
		//数据库连接	 
		Connection conn = null;
		//返回的题目id
		int que_id;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			RecordDao dao = (RecordDao) DaoFactory.getDao(conn,EnumType.RECORD_DAO);
			//获取最大页数
			que_id = dao.createChapterTestRecord(user_id, exam_id, chapter);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return que_id;
	}

	@Override
	public RecordVO getLastQueidByExamidAndUserid(int exam_id, int user_id) {
		//数据库连接	 
		Connection conn = null;
		//返回的题目id
		RecordVO vo;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			RecordDao dao = (RecordDao) DaoFactory.getDao(conn,EnumType.RECORD_DAO);
			//获取最大页数
			vo = dao.getLastQueidByExamidAndUserid(exam_id, user_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public int[] createExamRecord(int user_id, int exam_id) {
		//数据库连接	 
		Connection conn = null;
		//返回的题目id
		int[] num = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			RecordDao dao = (RecordDao) DaoFactory.getDao(conn,EnumType.RECORD_DAO);
			num = dao.createExamRecord(user_id, exam_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return num;
	}

	@Override
	public int getNumOfAnswer(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//返回的题目id
		int num = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			RecordDao dao = (RecordDao) DaoFactory.getDao(conn,EnumType.RECORD_DAO);
			num = dao.getNumOfAnswer(ans_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return num;
	}

}
