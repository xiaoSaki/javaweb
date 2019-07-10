package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.NoticeDao;
import com.neuedu.lvcity.model.Notice;

public class NoticeDaoImpl implements NoticeDao{
	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public NoticeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public int getCountByFtid(int ntid) {
		//声明变量，用于保存查询结果
		int result = 0;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select count(*) from notice where ntid = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setInt(1, ntid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部Notice的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}
		
	@Override
	public List<Notice> noticeListByFtid(int ntid, int start) {
		//声明变量，用于保存查询结果
		List<Notice> notices = new ArrayList<Notice>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from notice where ntid = ? limit  ?,9");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setInt(1, ntid);
			pstam.setInt(2, start);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				Notice notice = new Notice();
				notice.setAid(rs.getInt("aid"));
				notice.setNid(rs.getInt("nid"));
				notice.setNname(rs.getString("nname"));
				notice.setNtid(rs.getInt("ntid"));
				notices.add(notice);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询notices的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return notices;		
	}

	@Override
	public int getCountByLike(String like, int ntid) {
		//声明变量，用于保存查询结果
		int result = 0;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select count(*) from notice where nname like ? and  ntid= ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setString(1, like);
			pstam.setInt(2, ntid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
				System.out.println(result);
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在统计满足模糊查询条件的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
}

	@Override
	public List<Notice> noticeListByLike(String like, int ntid, int start) {
		//声明变量，用于保存查询结果
		List<Notice> notices = new ArrayList<Notice>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from notice where nname like ? and ntid =?  limit  ?,9");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setString(1, like);
			pstam.setInt(2, ntid);
			pstam.setInt(3, start);
			
			rs = pstam.executeQuery();
		
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				Notice notice = new Notice();
				notice.setAid(rs.getInt("aid"));
				notice.setNid(rs.getInt("nid"));
				notice.setNname(rs.getString("nname"));
				notice.setNtid(rs.getInt("ntid"));
				notices.add(notice);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询满足模糊条件的foods的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return notices;
}

} 
