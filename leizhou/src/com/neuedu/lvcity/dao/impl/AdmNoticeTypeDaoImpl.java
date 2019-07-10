package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmNoticeTypeDao;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.model.Noticetype;

public class AdmNoticeTypeDaoImpl implements AdmNoticeTypeDao{
	
	private Connection conn;//数据库连接
	public AdmNoticeTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Noticetype> findNoticetype() {
		List<Noticetype> list = new ArrayList<Noticetype>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from noticetype");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Noticetype noticetype = new Noticetype();
				noticetype.setNtid(rs.getInt("ntid"));
				noticetype.setNt(rs.getString("nt"));
				list.add(noticetype);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户noticetype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteNoticetype(int ntid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		PreparedStatement pstam1 = null;
		PreparedStatement pstam2 = null;
		try {
			pstam = conn.prepareStatement("select * from notice where ntid = ?");
			pstam.setInt(1, ntid);
			ResultSet count =pstam.executeQuery();
			if(count.next()){
				pstam2 = conn.prepareStatement("delete from notice where ntid = ?");
				pstam2.setInt(1, ntid);
				pstam2.executeUpdate();
			}
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam1 = conn.prepareStatement("delete from noticetype where ntid = ?");
			pstam1.setInt(1, ntid);
			int i =pstam1.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除用户noticetype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
			DBUtils.closeStatement(null, pstam1);
			DBUtils.closeStatement(null, pstam2);
		}
		return flag;
	}

	@Override
	public boolean addNoticetype(Noticetype noticetype) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into noticetype (ntid,nt) values(?,?) ");
			pstam.setInt(1, noticetype.getNtid());
			pstam.setString(2, noticetype.getNt());
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
	public List<Noticetype> findNoticetypeByName(String nt) {
		List<Noticetype> list = new ArrayList<Noticetype>();
		Noticetype noticetype = new Noticetype();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from noticetype where nt like ?");
			pstam.setString(1, nt);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				noticetype.setNtid(rs.getInt("ntid"));
				noticetype.setNt(rs.getString("nt"));
				list.add(noticetype);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户noticetype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean updateNoticetype(Noticetype noticetype) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update noticetype set nt=? where ntid=? ");
			pstam.setString(1, noticetype.getNt());
			pstam.setInt(2, noticetype.getNtid());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新通知noticetype的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Noticetype findNoticetypeByid(int ntid) {
		Noticetype noticetype = new Noticetype();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from noticetype where ntid = ?");
			pstam.setInt(1, ntid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				noticetype.setNtid(rs.getInt("ntid"));
				noticetype.setNt(rs.getString("nt"));
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户noticetype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return noticetype;
	}


}
