package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.FoodTypeDao;
import com.neuedu.lvcity.dao.NoticetypeDao;
import com.neuedu.lvcity.dao.impl.FoodTypeDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticetypeDaoImpl;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.service.FoodTypeService;
import com.neuedu.lvcity.service.NoticetypeService;

public class NoticetypeServiceImpl implements NoticetypeService{

	/**
	 * 类实例
	 */
	private static final  NoticetypeService instance = new NoticetypeServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static NoticetypeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private NoticetypeServiceImpl() {
	}

	@Override
	public List<Noticetype> findNoticetype() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Noticetype> noticetypes = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建indexDao的实现类对象
					NoticetypeDao noticetypeDao = new NoticetypeDaoImpl(conn);
					//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
					noticetypes =noticetypeDao.findNoticetype();
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有noticetypes错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return noticetypes;
	}

	@Override
	public String gettypebyid(int ntid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		String result =  "";
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建indexDao的实现类对象
			NoticetypeDao noticetypeDao = new NoticetypeDaoImpl(conn);
			//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
			result  =noticetypeDao.gettypebyid(ntid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("根据ftid查询美食分类名称错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}
}
