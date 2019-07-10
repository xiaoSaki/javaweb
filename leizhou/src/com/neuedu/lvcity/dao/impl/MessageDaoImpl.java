package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;






import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.MessageDao;
import com.neuedu.lvcity.model.Message;
import com.neuedu.lvcity.model.Notice;

public class MessageDaoImpl implements MessageDao {

	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public MessageDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	
	/**
	 * 添加留言，存进数据库
	 * @param messages 留言信息
	 * @return 成功返回true，失败返回false
	 */
	@Override
	public boolean AddListMessage(Message messages){
		boolean flag = false;
		//判断参数是否为空，如果不空就进行数据库的插入
		if(messages != null){
			PreparedStatement prep = null; //声明与编译的声明对象变量，用于进行数据库操作的载体
			int result = -1;
			int mid = messages.getMid();
			String tel = messages.getTel();
			String sex = messages.getSex();
			String name = messages.getName();
			String message = messages.getMessage();
			
			try{ 
				//调用连接对象的prepareStatement方法得到预编译对象，赋值给预编译对象变量
				prep = conn.prepareStatement
						("insert into message(mid,tel,sex,name,message) values(?,?,?,?,?)");
				
				//调用预编译对象的setxxx方法，给？赋值
				prep.setInt(1, mid);
				prep.setString(2, tel);
				prep.setString(3, sex);
				prep.setString(4, name);
				prep.setString(5, message);				
				result = prep.executeUpdate(); //调用预编译对象的executeUpdate方法，执行插入操作返回插入结果，赋值变量
				if(result > 0){ //判断插入结果变量，如果大于0，数据库插入成功，返回true，否则插入失败，返回false
					return flag=true;
				}else{
					return flag = false;
				}
			}catch (SQLException e) {
				System.out.println("在添加留言的时候出错，错误信息是："+e.getMessage());
				
				}finally{
					DBUtils.closeStatement(null,prep);
				}
		}
		else
			return flag = false;
		return flag;
		
		
		
	}

	/**
	 * 查询最大的mid编号
	 * @return 最大的mid
	 */
	@Override
	public int findMaxMid(){
		int max = -1; //声明变量，用于保存id的最大值
		ResultSet rs = null;
		PreparedStatement prep = null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select max(mid) from message");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
//			System.out.println("1.测试max(id)");
			if(rs.next()){
				max = rs.getInt("max(mid)");
			}else{
				max = 0;
			}
		}catch(Exception e){
			System.out.println("1在查询最mid的时候出错"+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return max;
	}

	@Override
	public List<Message> findallMessage() {
		//声明变量，用于保存查询结果
				List<Message> messagelist = new ArrayList<Message>();
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select * from message");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					
					
					
					rs = pstam.executeQuery();
				
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
					while(rs.next()){
						Message message = new Message();
						message.setMid(rs.getInt("mid"));
						message.setName(rs.getString("name"));
						message.setSex(rs.getString("sex"));
						message.setMessage(rs.getString("message"));
						message.setTel(rs.getString("tel"));
						
						messagelist.add(message);
					}
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在查询满足模糊条件的foods的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return messagelist;
		}

	@Override
	public List<Message> findMessageByusername(String name) {
		//声明变量，用于保存查询结果
		List<Message> messagelist = new ArrayList<Message>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from message where name = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			
			pstam.setString(1, name);
			
			rs = pstam.executeQuery();
		
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				Message message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setName(rs.getString("name"));
				message.setSex(rs.getString("sex"));
				message.setMessage(rs.getString("message"));
				message.setTel(rs.getString("tel"));
				messagelist.add(message);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询满足模糊条件的foods的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return messagelist;
	}
	
	@Override
	public boolean deleteMessage(int mid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("delete from message where mid = ?");
			pstam.setInt(1, mid);
			int i = pstam.executeUpdate();
			if(i>0){
				flag=true;
			}			
		}catch (SQLException e) {
			System.out.println("在删除Message的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public List<Message> findMessage(String name) {
		List<Message> list = new ArrayList<Message>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from message where name like ?");
			pstam.setString(1, "%"+name+"%");
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Message messages = new Message();
				messages.setMid(rs.getInt("mid"));
				messages.setName(rs.getString("name"));
				messages.setSex(rs.getString("sex"));
				messages.setTel(rs.getString("tel"));
				messages.setMessage(rs.getString("message"));
				list.add(messages);	
			}
		}catch (SQLException e) {
			System.out.println("在根据name查询message的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public Message findMessageById(int mid) {
		Message messages = new Message();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from message where mid = ?");
			pstam.setInt(1, mid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){						
				messages.setMid(rs.getInt("mid"));
				messages.setName(rs.getString("name"));
				messages.setSex(rs.getString("sex"));
				messages.setTel(rs.getString("tel"));
				messages.setMessage(rs.getString("message"));
			}
		}catch (SQLException e) {
			System.out.println("在查询message的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return messages;
	}

	@Override
	public boolean updateMessage(Message messages) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update message set name=?, sex=?, tel=?, message=? where mid=? ");
			pstam.setString(1, messages.getName());
			pstam.setString(2, messages.getSex());
			pstam.setString(3, messages.getTel());
			pstam.setString(4, messages.getMessage());
			pstam.setInt(5, messages.getMid());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("在更新message的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	
	
}
