package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdmArticletypeDao;
import com.neuedu.lvcity.dao.impl.AdmArticletypeDaoImpl;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.service.AdmArticletypeService;
import com.neuedu.lvcity.service.ArticleService;

public class AdmArticletypeServiceImpl implements AdmArticletypeService{

	@Override
	public List<Articletype> findArticletype() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Articletype> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmArticletypeDao admArticletypeDao = new AdmArticletypeDaoImpl(conn);
			list  = admArticletypeDao.findArticletype();
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有articletype错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;				
	}

	@Override
	public boolean deleteArticletype(int atid) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmArticletypeDao admArticletypeDao = new AdmArticletypeDaoImpl(conn);
			flag = admArticletypeDao.deleteArticletype(atid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("删除所有articletype错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addArticletype(Articletype articletype) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmArticletypeDao admArticletypeDao = new AdmArticletypeDaoImpl(conn);
			flag = admArticletypeDao.addArticletype(articletype);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加articletype错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}


	@Override
	public boolean updateArticletype(Articletype articletype) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmArticletypeDao admArticletypeDao = new AdmArticletypeDaoImpl(conn);
			flag = admArticletypeDao.updateArticletype(articletype);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新所有articletype错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public Articletype findArticletypeByid(int atid) {
		Connection conn = null;
		Articletype articletype = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmArticletypeDao admArticletypeDao = new AdmArticletypeDaoImpl(conn);
			articletype = admArticletypeDao.findArticletypeByid(atid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询articletype错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return articletype;
	}

}
