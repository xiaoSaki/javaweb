package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmNoticeDao;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.Notice;

public class AdmNoticeDaoImpl implements AdmNoticeDao{
	
	private Connection conn;//数据库连接
	public AdmNoticeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Notice> findNotice() {
		List<Notice> list = new ArrayList<Notice>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from notice");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Notice notice = new Notice();
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				list.add(notice);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户notice的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteNotice(int nid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("delete from notice where nid = ?");
			pstam.setInt(1, nid);
			int i =pstam.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除用户notice的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addNotice(Notice notice) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into notice (nid,ntid,aid,nname) values(?,?,?,?) ");
			pstam.setInt(1, notice.getNid());
			pstam.setInt(2, notice.getNtid());
			pstam.setInt(3, notice.getAid());
			pstam.setString(4, notice.getNname());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
//			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}


	@Override
	public List<Notice> findNoticeByName(String name) {
		List<Notice> list = new ArrayList<Notice>();
		Notice notice = new Notice();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from notice where nname like ?");
			pstam.setString(1, name);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				list.add(notice);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户notice的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update notice set ntid=?,aid=?,nname=? where nid=? ");
			pstam.setInt(4, notice.getNid());
			pstam.setInt(1, notice.getNtid());
			pstam.setInt(2, notice.getAid());
			pstam.setString(3, notice.getNname());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新通知notice的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Notice findNoticeByid(int nid) {
		Notice notice = new Notice();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from notice where nid = ?");
			pstam.setInt(1, nid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户notice的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return notice;
	}


}
