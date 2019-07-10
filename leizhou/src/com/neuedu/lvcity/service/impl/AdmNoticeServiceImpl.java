package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdmNoticeDao;
import com.neuedu.lvcity.dao.impl.AdmNoticeDaoImpl;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.service.AdmNoticeService;
import com.neuedu.lvcity.service.ArticleService;

public class AdmNoticeServiceImpl implements AdmNoticeService{

	@Override
	public List<Notice> findNotice() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Notice> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			list  = admNoticeDao.findNotice();
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;				
	}

	@Override
	public boolean deleteNotice(int nid) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			flag = admNoticeDao.deleteNotice(nid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("删除所有notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addNotice(Notice notice) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			flag = admNoticeDao.addNotice(notice);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加所有notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Notice> findNoticeByname(String name) {
		Connection conn = null;
		List<Notice> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			list = admNoticeDao.findNoticeByName(name);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			flag = admNoticeDao.updateNotice(notice);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新所有notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public Notice findNoticeByid(int nid) {
		Connection conn = null;
		Notice notice = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeDao admNoticeDao = new AdmNoticeDaoImpl(conn);
			notice = admNoticeDao.findNoticeByid(nid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return notice;
	}

}
