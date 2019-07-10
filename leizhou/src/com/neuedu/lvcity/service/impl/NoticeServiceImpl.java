package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.dao.NoticeDao;
import com.neuedu.lvcity.dao.NoticetypeDao;
import com.neuedu.lvcity.dao.impl.FoodDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticeDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticetypeDaoImpl;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.service.NoticeService;
import com.neuedu.lvcity.service.NoticetypeService;

public class NoticeServiceImpl implements NoticeService {

	/**
	 * 类实例
	 */
	private static final  NoticeService instance = new NoticeServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static NoticeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private NoticeServiceImpl() {
	}

	@Override
	public int getCountByFtid(int ntid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		int result = 0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			NoticeDao noticeDao = new NoticeDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			result = noticeDao.getCountByFtid(ntid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有food错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}

	@Override
	public List<Notice> noticeListByFtid(int ntid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Notice> notices = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			NoticeDao noticeDao = new NoticeDaoImpl(conn);
			//调用dao中的foodListByFtid(ftid, start）方法，进行数据库查询操作，结果赋值给查询结果变量
			notices = noticeDao.noticeListByFtid(ntid, start);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有notices错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return notices;
}

	@Override
	public int getCountByLike(String like, int ftid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		int result = 0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			NoticeDao noticeDao = new NoticeDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			result = noticeDao.getCountByLike(like, ftid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有notice错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}		

	@Override
	public List<Notice> noticeListByLike(String like, int ntid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Notice> notices = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			NoticeDao noticeDao = new NoticeDaoImpl(conn);
			//调用dao中的foodListByFtid(ftid, start）方法，进行数据库查询操作，结果赋值给查询结果变量
			notices = noticeDao.noticeListByLike(like, ntid, start);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有notices错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return notices;
	}			
}
