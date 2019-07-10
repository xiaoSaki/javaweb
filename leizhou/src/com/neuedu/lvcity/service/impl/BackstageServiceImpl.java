package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.dao.LoginDao;
import com.neuedu.lvcity.dao.impl.BackstageDaoImpl;
import com.neuedu.lvcity.dao.impl.LoginDaoImpl;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.BackstageService;

public class BackstageServiceImpl implements BackstageService {
	
	//类实例
	private static final BackstageService instance = new BackstageServiceImpl();
	//取得实例,返回实例对象
	public static BackstageService getInstance() {
		return instance;
	}

	/**
	 * 用户管理
	 */
	@Override
	public List<Users> findUser() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Users> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findUser();
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
	public boolean deleteUser(int id) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.deleteUser(id);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("删除所有user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addUser(Users user) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.addUser(user);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加所有user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public Users findUserById(int id) {
		Connection conn = null;
		Users user = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			user = backstageDao.findUserById(id);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return user;
	}
	
	@Override
	public boolean updateUser(Users user) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.updateUser(user);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新所有user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Users> findUser(String name) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Users> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findUser(name);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("根据name查询user错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;
	}

	
	/**
	 * 美食管理
	 */
	@Override
	public List<Food> findFood() {
		Connection conn = null;
		List<Food> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findFood();
		} catch (Exception e) {
			throw new ServiceException("查询所有food错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean deleteFood(int fid) {
		boolean flag = false;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.deleteFood(fid);
		} catch (Exception e) {
			throw new ServiceException("删除food错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addFood(Food food) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.addFood(food);
		} catch (Exception e) {
			throw new ServiceException("添加food错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Food> findFood(int ftid, String fname) {
		Connection conn = null;
		List<Food> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findFood(ftid, fname);
		} catch (Exception e) {
			throw new ServiceException("模糊查询food错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	@Override
	public List<Food> findFood(String fname) {
		Connection conn = null;
		List<Food> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findFood(fname);
		} catch (Exception e) {
			throw new ServiceException("模糊查询food错误1", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	@Override
	public List<Food> findUpdateFood(int fid) {
		Connection conn = null;
		List<Food> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list  = backstageDao.findUpdateFood(fid);
		} catch (Exception e) {
			throw new ServiceException("根据fid查询food错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean updateFood(Food food) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.updateFood(food);
		} catch (Exception e) {
			throw new ServiceException("更新所有user错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 景点管理
	 */
	@Override
	public List<Scenic> findScenic() {
		Connection conn = null;
		List<Scenic> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list = backstageDao.findScenic();
		} catch (Exception e) {
			throw new ServiceException("查询所有scenic错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean deleteScenic(int sid) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.deleteScenic(sid);
		} catch (Exception e) {
			throw new ServiceException("删除scenic错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addScenic(Scenic scenic) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.addScenic(scenic);
		} catch (Exception e) {
			throw new ServiceException("添加scenic错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Scenic> findScenic(int stid, String sname) {
		Connection conn = null;
		List<Scenic> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list = backstageDao.findScenic(stid, sname);
		} catch (Exception e) {
			throw new ServiceException("查询scenic错误1", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List<Scenic> findScenic(String sname) {
		Connection conn = null;
		List<Scenic> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list = backstageDao.findScenic(sname);
		} catch (Exception e) {
			throw new ServiceException("查询scenic错误2", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List<Scenic> findUpdateScenic(int sid) {
		Connection conn = null;
		List<Scenic> list = null;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			list = backstageDao.findUpdateScenic(sid);
		} catch (Exception e) {
			throw new ServiceException("查询UpdateScenic错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean updateScenic(Scenic scenic) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			BackstageDao backstageDao = new BackstageDaoImpl(conn);
			flag = backstageDao.updateScenic(scenic);
		} catch (Exception e) {
			throw new ServiceException("更新scenic错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

}
