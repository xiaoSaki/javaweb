package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.lingnan.examsys.business.dao.Stu_ClassDao;
import com.lingnan.examsys.business.dao.UserDao;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class UserServiceImpl implements UserService {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static UserServiceImpl userService = new UserServiceImpl();
	
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static UserService getInstance() {
		return userService;
	}
	public UserVO login(int username, String password) {
		 //数据库连接	 
		Connection conn = null;
		//用户模型
		UserVO vo = null;
		try {
			//获取数据库连接对象
			conn = DBUtils.getConnection();
			//通过工厂方法获取指定dao
			UserDao dao = (UserDao) DaoFactory.getDao(conn,EnumType.USER_DAO);
			//获取用户权限值
			vo = dao.login(username, password);
		}catch (Exception e) {
			throw new ServiceException(Ca+"用户登录异常！",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
		return vo;
	}
	/**
	 * 黄润志2018.08.10
	 * 根据账号和密码查找用户
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<UserVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);			
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = userMgrDao.findUserByIdAndPassword(user);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("1Service:查找动态信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	public boolean findUserByUserid(int user_id){
		boolean list = false;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			UserDao scd = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			list = scd.findUserByid(user_id);
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException("2.查找学生失败", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	public boolean UpdatePwd(String user_pwd){
		boolean list = false;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			UserDao scd = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			list = scd.updateUserByPwd(user_pwd);
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException("2.更新密码失败", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	public static void main(String[] args) {
		UserService service = UserServiceImpl.getInstance();
		
		//用户权值值查询方法测试
		UserVO vo = service.login(100000, "123456");
		System.out.println(Ca);
		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pwd());
		System.out.println(vo.getBlocked_flag());
		System.out.println(vo.getBlocked_time());
		System.out.println(vo.getSupervalue());
	}

	@Override
	public int lockUserById(int user_id, Timestamp blocked_time) {
		Connection conn = null;
		int update = 0;
		try {
			conn = DBUtils.getConnection();
			UserDao dao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO); 
			update = dao.lockUserById(user_id, blocked_time);
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeConnection(conn);
		}
		return update;
	}

	@Override
	public int getSupervalueByIdAndPass(int user_id, String password) {
		Connection conn = null;
		int supervalue = 0;
		try {
			conn = DBUtils.getConnection();
			UserDao dao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO); 
			supervalue = dao.getSupervalueByIdAndPass(user_id, password);
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeConnection(conn);
		}
		return supervalue;
	}

	@Override
	public Timestamp getBlockedtimeById(int user_id) {
		Connection conn = null;
		Timestamp time = null;
		try {
			conn = DBUtils.getConnection();
			UserDao dao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO); 
			time = dao.getBlockedtimeById(user_id);
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeConnection(conn);
		}
		return time;
	}

}
