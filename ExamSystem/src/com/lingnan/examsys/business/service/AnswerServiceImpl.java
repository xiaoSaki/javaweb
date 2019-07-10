package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.lingnan.examsys.business.dao.AnswerDao;
import com.lingnan.examsys.business.dao.MissionDao;
import com.lingnan.examsys.business.domain.AnswerRecordPOJO;
import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.business.domain.PageBean;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class AnswerServiceImpl implements AnswerService {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	private AnswerServiceImpl() {}
	
	private  static class AnswerServiceImplInstance {
		private static final AnswerService instance = new AnswerServiceImpl();
	}
	
	public static AnswerService getInstance() {
		return AnswerServiceImplInstance.instance;
	}

	@Override
	public AnswerVO chapterTest(int user_id, int chapter) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		AnswerVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			vo = dao.chapterTest(user_id, chapter);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public int getErrorsumById(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int error_sum = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			error_sum = dao.getErrorsumById(ans_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return error_sum;
	}

	@Override
	public int setErrorsumById(int ans_id,int set) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int rs = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			rs = dao.setErrorsumById(ans_id, set);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return rs;
	}

	@Override
	public int setEndtimeById(int ans_id, Timestamp endtime) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int rs = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			rs = dao.setEndtimeById(ans_id, endtime);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return rs;
	}

	@Override
	public int updateTimeOnRecordByAns_Id(int ans_id, int user_id, int seq_num, Timestamp time) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int update = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			update = dao.updateTimeOnRecordByAns_Id(ans_id, user_id, seq_num, time);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return update;
	}

	@Override
	public int getAndPlusErrorsumById(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int error_sum = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			error_sum = dao.getAndPlusErrorsumById(ans_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return error_sum;
	}

	@Override
	public int getNextQuetion(int ans_id, int user_id, int seq_num) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int que_id = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			que_id = dao.getNextQuetion(ans_id, user_id, seq_num);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return que_id;
	}

	@Override
	public int updateErrorflagOnRecordByAns_Id(int ans_id, int user_id, int seq_num,int value) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int update = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			update = dao.updateError_flagOnRecordByAns_Id(ans_id, user_id, seq_num, value);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return update;
	}

	@Override
	public int ifExistAnswering(int user_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int ans_id = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			ans_id = dao.ifExistAnswering(user_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return ans_id;
	}

	@Override
	public AnswerVO getAnswerById(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		AnswerVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			vo = dao.getAnswerById(ans_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public int getTypeOfAnswerById(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int user_id = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			user_id = dao.getTypeOfAnswerById(ans_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return user_id;
	}

	@Override
	public AnswerVO examTest(int user_id, int exam_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		AnswerVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			vo = dao.examTest(user_id, exam_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public int updateMission(int ans_id, int user_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		int update = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			MissionDao dao = (MissionDao) DaoFactory.getDao(conn,EnumType.MISSION_DAO);
			//获取最大页数
			update = dao.updateMission(ans_id, user_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return update;
	}
	@Override
	public boolean insertMission(int exam_id, int user_id) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		boolean flag = false;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			MissionDao dao = (MissionDao) DaoFactory.getDao(conn,EnumType.MISSION_DAO);
			//获取最大页数
			flag = dao.insertMission(exam_id, user_id);
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public PageBean<AnswerRecordPOJO> getExamRecordByPageNo(int user_id, int pageNo, int pageSize) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		PageBean<AnswerRecordPOJO> bean = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			int recordNum = dao.getExamRecordByUserid(user_id).size();
			bean = new PageBean<AnswerRecordPOJO>(pageNo, pageSize, recordNum);
			bean.setList(dao.getExamRecordWithPage(user_id, pageNo, pageSize));
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return bean;
	}

	@Override
	public PageBean<AnswerRecordPOJO> getChapterRecordByPageNo(int user_id, int pageNo, int pageSize) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		PageBean<AnswerRecordPOJO> bean = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			AnswerDao dao = (AnswerDao) DaoFactory.getDao(conn,EnumType.ANSWER_DAO);
			//获取最大页数
			int recordNum = dao.getChapterRecordByUserid(user_id).size();
			bean = new PageBean<AnswerRecordPOJO>(pageNo, pageSize, recordNum);
			bean.setList(dao.getChapterRecordWithPage(user_id, pageNo, pageSize));
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return bean;
	}

}
