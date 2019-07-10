package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.ScenicTypeDao;
import com.neuedu.lvcity.dao.impl.ScenicTypeDaoImpl;
import com.neuedu.lvcity.model.ScenicType;
import com.neuedu.lvcity.service.ScenicTypeService;

public class ScenicTypeServiceImpl implements ScenicTypeService{
	/**
	 * 类实例
	 */
	private static final  ScenicTypeService instance = new ScenicTypeServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ScenicTypeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ScenicTypeServiceImpl() {
	}

	@Override
	public List<ScenicType> findScenictype() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<ScenicType> scenicTypes = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			ScenicTypeDao scenicTypeDao = new ScenicTypeDaoImpl(conn);
			scenicTypes =scenicTypeDao.findScenictype();
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有scenicTypes错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return scenicTypes;
	}

	@Override
	public String gettypebyid(int stid) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				String result =  "";
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					ScenicTypeDao scenicTypeDao = new ScenicTypeDaoImpl(conn);
					result  =scenicTypeDao.gettypebyid(stid);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					e.printStackTrace();
					throw new ServiceException("根据stid查询风景分类名称错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return result;
	}

}
