package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.LoginDao;
import com.neuedu.lvcity.dao.impl.LoginDaoImpl;
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.LoginService;

//add 2019/04/09
public class LoginServiceImpl implements LoginService {

	//类实例
	private static final LoginService instance = new LoginServiceImpl();
	//取得实例,返回实例对象
	public static LoginService getInstance() {
		return instance;
	}
	
	@Override
	public List<Users> loginByUser(String name, String passwd) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Users> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			LoginDao loginDao  = new LoginDaoImpl(conn);
			list  = loginDao.loginByUser(name, passwd);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;
	}

	@Override
	public boolean RegisterUser(String name, String passwd) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			LoginDao loginDao  = new LoginDaoImpl(conn);
			flag = loginDao.RegisterUser(name, passwd);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("注册user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

}
