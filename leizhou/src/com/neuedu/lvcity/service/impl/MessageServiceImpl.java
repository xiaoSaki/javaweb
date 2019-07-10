package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.NoticetypeDao;
import com.neuedu.lvcity.dao.impl.MessageDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticetypeDaoImpl;
import com.neuedu.lvcity.model.Message;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.service.MessageService;


public class MessageServiceImpl implements MessageService{

	/**
	 * 添加留言信息
	 * @param messages
	 * @return
	 */
	@Override
	public boolean AddListMessage(Message messages){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		boolean result = false; //声明变量，用于保存数据插入结果
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			DBUtils.beginTransaction(conn); //调用数据库工具类的beginTransaction的方法，开启事务
			messages.setMid(MessageMgrDao.findMaxMid()+1);
			//调用dao中的adduser方法，进行数据库插入操作，结果赋值给变量
			result = MessageMgrDao.AddListMessage(messages);
			DBUtils.commit(conn); //调用数据库工具类的commit的方法，提交事务
		}catch(Exception e){
			DBUtils.rollback(conn); //调用数据库工具类的rollback的方法，事务回滚
			throw new ServiceException("MessageServiceImpl添加留言错误",e);
		}finally{
			DBUtils.closeConnection(conn); //调用数据库工具类的closeConnection的方法，关闭连接
		}
	return result;
	}

	@Override
	public List<Message> findallMessage() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Message> messages = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建indexDao的实现类对象
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
			messages =MessageMgrDao.findallMessage();
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有MessageMgrDao错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return messages;
	}

	@Override
	public List<Message> findMessageByusername(String name) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Message> messages = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建indexDao的实现类对象
					MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
					//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
					messages =MessageMgrDao.findMessageByusername(name);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有MessageMgrDao错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return messages;
	}
	
	@Override
	public boolean deleteMessage(int mid) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			flag =MessageMgrDao.deleteMessage(mid);		
		} catch (Exception e) {
			throw new ServiceException("删除Message错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Message> findMessage(String name) {
		Connection conn = null;
		List<Message> list = null;
		try{
			conn = DBUtils.getConnection();
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			list =MessageMgrDao.findMessage(name);		
		} catch (Exception e) {
			throw new ServiceException("根据name查询Message错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public Message findMessageById(int mid) {
		Connection conn = null;
		Message messages = null;
		try{
			conn = DBUtils.getConnection();
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			messages =MessageMgrDao.findMessageById(mid);		
		} catch (Exception e) {
			throw new ServiceException("根据mid查询Message错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return messages;
	}

	@Override
	public boolean updateMessage(Message messages) {
		Connection conn = null;
		boolean flag = false;
		try{
			conn = DBUtils.getConnection();
			MessageDaoImpl MessageMgrDao = new MessageDaoImpl(conn);
			flag =MessageMgrDao.updateMessage(messages);	
		} catch (Exception e) {
			throw new ServiceException("更新Message错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

}
