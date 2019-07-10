package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.ScenicDao;
import com.neuedu.lvcity.dao.impl.ScenicDaoImpl;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.ScenicService;

public class ScenicServiceImpl implements ScenicService{
	/**
	 * 类实例
	 */
	private static final  ScenicService instance = new ScenicServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ScenicService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ScenicServiceImpl() {
	}

	@Override
	public int getCountByStid(int stid) {
		 //声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		int result = 0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			ScenicDao scenicDao = new ScenicDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			result = scenicDao.getCountByStid(stid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			e.printStackTrace();
			throw new ServiceException("查询所有scenic错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}

	@Override
	public List<Scenic> scenicListByStid(int stid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		List<Scenic> scenics = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			ScenicDao scenicDao = new ScenicDaoImpl(conn);
			
			scenics = scenicDao.scenicListByStid(stid, start);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			e.printStackTrace();
			throw new ServiceException("查询所有scenic错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return scenics;
	}

	@Override
	public int getCountByLike(String like, int stid) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				int result = 0;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建ScenicDao的实现类对象
					ScenicDao scenicDao = new ScenicDaoImpl(conn);
	
					result = scenicDao.getCountByLike(like, stid);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					e.printStackTrace();
					throw new ServiceException("查询所有scenic错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return result;
	}

	@Override
	public List<Scenic> scenicListByLike(String like, int stid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Scenic> scenics = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建FoodDao的实现类对象
					ScenicDao scenicDao = new ScenicDaoImpl(conn);
					
					scenics = scenicDao.scenicListByLike(like, stid, start);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					e.printStackTrace();
					throw new ServiceException("查询所有scenic错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return scenics;
	}

}
