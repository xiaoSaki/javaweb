package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.LoginDao;
import com.neuedu.lvcity.model.Users;

public class LoginDaoImpl implements LoginDao {

	//add 2019/04/09
	private Connection conn;//数据库连接
	public LoginDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	//用户登录
	@Override
	public List<Users> loginByUser(String name,String passwd) {
		List<Users> list = new ArrayList<Users>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from users where name = ? and passwd = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量	
			pstam.setString(1, name);
			pstam.setString(2, passwd);
			rs = pstam.executeQuery();
	
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
				list.add(user);	
			}	
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户user的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean RegisterUser(String name, String passwd) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into users (name,passwd) values(?,?) ");
			pstam.setString(1, name);
			pstam.setString(2, passwd);
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}
}
