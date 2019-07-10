package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lingnan.examsys.business.dao.ExaminationDao;
import com.lingnan.examsys.business.domain.ExamInfoPOJO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.PageBean;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class ExaminationServiceImpl implements ExaminationService{

    //测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static ExaminationService examinationService = new ExaminationServiceImpl();
	
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static ExaminationService getInstance() {
		return examinationService;
	}
		
	/**
	 * 2018/10/29 mai 修改
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间，user_id从页面取）,返回exam_id
	 */
	@Override
	public int insertExam(int user_id, String exam_name, Date exam_begin,Date exam_end) {
//		boolean flag = false;		
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		int exam_id = 0;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			exam_id = examinationdao.insertExam(user_id, exam_name, exam_begin, exam_end);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师完善试卷信息失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return exam_id;
	}

	/**
	 * add mai
	 * 查询该教师出过的试卷
	 * servlet写在question_bankServlet里面
	 */
	@Override
	public List<ExaminationVO> findExamByid(int user_id) {
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findExamByid(user_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.查找试卷失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	/**
	 * add mai
	 * 根据试卷名模糊查询试卷
	 * servlet写在question_bankServlet里面
	 */
	@Override
	public List<ExaminationVO> findExamByName(int user_id,String exam_name) {
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findExamByName(user_id, exam_name);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.模糊查询试卷失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	
	/**
	 * add mai
	 * 根据试卷id查找试题id
	 * servlet写在question_bankServlet里面
	 */
	@Override
	public List<Que_ExamVO> findQueByexam_id(int exam_id) {
		List<Que_ExamVO> list = new ArrayList<Que_ExamVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findQueByexam_id(exam_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.根据试卷id查找试题id失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	/**
	 * add mai
	 * 根据试卷id查找到的试题id去查询试题详情
	 */
	@Override
	public List<Question_bankVO> findQueByque_id(int a[]) {
		List<Question_bankVO> list = new ArrayList<Question_bankVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findQueByque_id(a);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.根据试卷id查找到的试题id去查询试题详情失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	/**
	 * add mai
	 * 删除试卷中的试题(que_exam表)
	 */
	@Override
	public boolean delExam_Que(int exam_id, int que_id) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.delExam_Que(exam_id, que_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.删除试卷中的试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * add mai
	 * 更新修改试题
	 */
	@Override
	public boolean updateQue_bank(Question_bankVO Que_bankVO) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.updateQue_bank(Que_bankVO);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.更新修改试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * add mai
	 * 根据试题id查询一道试题
	 */
	@Override
	public List<Question_bankVO> findQueByid(int que_id) {
		List<Question_bankVO> list = new ArrayList<Question_bankVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findQueByid(que_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.根据试题id查询一道试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	/**
	 * add mai
	 * 题库添加试卷试题
	 */
	@Override
	public boolean insertQueByid(int exam_id,int que_id) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.insertQueByid(exam_id,que_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.题库添加试卷试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	/**
	 * 根据exam_id删除试卷
	 * add 2018/11/17
	 * servlet写在question_bankServlet里面
	 */
	@Override
	public boolean delExamByid(int exam_id) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.delExamByid(exam_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.删除试卷失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	
	/** 
	 * add mai
	 * add 2018/11/17
	 * 根据exam_id删除试题记录
	 */
	@Override
	public boolean delQue_ExamByid(int exam_id) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.delQue_ExamByid(exam_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.删除试卷中的试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	/**
	 * add mai
	 * add 2018/11/17
	 * 更新试卷信息
	 */
	@Override
	public boolean updateExam(ExaminationVO ExamVO) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);			
			flag = examinationdao.updateExam(ExamVO);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.更新修改试卷失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * add mai
	 * add 2018/11/17
	 * 根据exam_id查找试卷
	 */
	@Override
	public List<ExaminationVO> findExamByexam_id(int exam_id) {
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			list = examinationdao.findExamByexam_id(exam_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.查找试卷失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return list;
	}

	@Override
	public int getMaxpageByPagesize(int pageSize) {
		//数据库连接	 
		Connection conn = null;
		//计算出的最大页码
		int maxSize = 0;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			ExaminationDao dao = (ExaminationDao) DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);
			//获取最大页数
			maxSize = dao.getMaxpageByPagesize(pageSize);
		}catch (Exception e) {
			throw new ServiceException(Ca+"考试信息查询异常！",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return maxSize;
	}

	@Override
	public ArrayList<ExaminationVO> getExamByPage(int pageNo, int pageSize) {
		//数据库连接	 
		Connection conn = null;
		//考试信息集合
		ArrayList<ExaminationVO> list = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			ExaminationDao dao = (ExaminationDao) DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);
			//获取最大页数
			list = dao.getExamByPage(pageNo, pageSize);
		}catch (Exception e) {
			throw new ServiceException("考试信息查询异常！",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public ExaminationVO getExamById(int exam_id) {
		//数据库连接	 
		Connection conn = null;
		//考试信息集合
		ExaminationVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			ExaminationDao dao = (ExaminationDao) DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);
			//获取最大页数
			vo = dao.getExamById(exam_id);
		}catch (Exception e) {
			throw new ServiceException("考试信息查询异常！",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public ExaminationVO getExamByAnsid(int ans_id) {
		//数据库连接	 
		Connection conn = null;
		//考试信息集合
		ExaminationVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			ExaminationDao dao = (ExaminationDao) DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);
			//获取最大页数
			vo = dao.getExamByAnsid(ans_id);
		}catch (Exception e) {
			throw new ServiceException("考试信息查询异常！",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}

	@Override
	public PageBean<ExamInfoPOJO> getExamInfo(int user_id,int pageNo,int pageSize) {
		//数据库连接	 
		Connection conn = null;
		//answer答题类
		PageBean<ExamInfoPOJO> bean = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			ExaminationDao dao = (ExaminationDao) DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);
			//获取最大页数
			int recordNum = dao.getExaminfoByUserid(user_id).size();
			bean = new PageBean<ExamInfoPOJO>(pageNo, pageSize, recordNum);
			bean.setList(dao.getExaminfoWithPage(user_id, pageNo, pageSize));
		}catch (Exception e) {
			throw new ServiceException(Ca,e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return bean;
	}

}
