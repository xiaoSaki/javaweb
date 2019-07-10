
package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdmBanarDao;
import com.neuedu.lvcity.dao.impl.AdmBanarDaoImpl;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.service.AdmBanarService;
import com.neuedu.lvcity.service.ArticleService;

public class AdmBanarServiceImpl implements AdmBanarService{

	@Override
	public List<Banar> findBanar() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Banar> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmBanarDao admBanarDao = new AdmBanarDaoImpl(conn);
			list  = admBanarDao.findBanar();
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;				
	}

	@Override
	public boolean deleteBanar(int banarid) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmBanarDao admBanarDao = new AdmBanarDaoImpl(conn);
			flag = admBanarDao.deleteBanar(banarid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("删除所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addBanar(Banar banar) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmBanarDao admBanarDao = new AdmBanarDaoImpl(conn);
			flag = admBanarDao.addBanar(banar);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}


	@Override
	public boolean updateBanar(Banar banar) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmBanarDao admBanarDao = new AdmBanarDaoImpl(conn);
			flag = admBanarDao.updateBanar(banar);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public Banar findBanarByid(int banarid) {
		Connection conn = null;
		Banar banar = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmBanarDao admBanarDao = new AdmBanarDaoImpl(conn);
			banar = admBanarDao.findBanarByid(banarid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return banar;
	}

}
