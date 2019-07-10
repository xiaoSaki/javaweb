package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdmNoticeTypeDao;
import com.neuedu.lvcity.dao.impl.AdmNoticeTypeDaoImpl;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.service.AdmNoticeTypeService;
import com.neuedu.lvcity.service.ArticleService;

public class AdmNoticeTypeServiceImpl implements AdmNoticeTypeService{

	@Override
	public List<Noticetype> findNoticetype() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Noticetype> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			list  = admNoticetypeDao.findNoticetype();
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
	public boolean deleteNoticetype(int nid) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			flag = admNoticetypeDao.deleteNoticetype(nid);
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
	public boolean addNoticetype(Noticetype noticetype) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			flag = admNoticetypeDao.addNoticetype(noticetype);
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
	public List<Noticetype> findNoticetypeByname(String nt) {
		Connection conn = null;
		List<Noticetype> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			list = admNoticetypeDao.findNoticetypeByName(nt);
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
	public boolean updateNoticetype(Noticetype noticetype) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			flag = admNoticetypeDao.updateNoticetype(noticetype);
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
	public Noticetype findNoticetypeByid(int ntid) {
		Connection conn = null;
		Noticetype notice = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmNoticeTypeDao admNoticetypeDao = new AdmNoticeTypeDaoImpl(conn);
			notice = admNoticetypeDao.findNoticetypeByid(ntid);
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
