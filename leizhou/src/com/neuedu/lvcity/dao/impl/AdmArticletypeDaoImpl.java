package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmArticletypeDao;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Articletype;

public class AdmArticletypeDaoImpl implements AdmArticletypeDao{
	
	private Connection conn;//数据库连接
	public AdmArticletypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Articletype> findArticletype() {
		List<Articletype> list = new ArrayList<Articletype>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from articletype");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Articletype articletype = new Articletype();
				articletype.setAtid(rs.getInt("atid"));
				articletype.setAtype(rs.getString("atype"));
				list.add(articletype);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户articletype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteArticletype(int atid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		PreparedStatement pstam2 = null;
		PreparedStatement pstam1 = null;
		try {
			pstam = conn.prepareStatement("select * from article where atid = ?");
			pstam.setInt(1, atid);
			ResultSet count =pstam.executeQuery();
			if(count.next()){
				pstam2 = conn.prepareStatement("delete from article where atid = ?");
				pstam2.setInt(1, atid);
				pstam2.executeUpdate();
			}
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam1 = conn.prepareStatement("delete from articletype where atid = ?");
			pstam1.setInt(1, atid);
			int i =pstam1.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除articletype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
			DBUtils.closeStatement(null, pstam1);
			DBUtils.closeStatement(null, pstam2);
		}
		return flag;
	}

	@Override
	public boolean addArticletype(Articletype articletype) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into articletype (atid,atype) values(?,?) ");
			pstam.setInt(1, articletype.getAtid());
			pstam.setString(2, articletype.getAtype());
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
	public boolean updateArticletype(Articletype articletype) {
		boolean flag = false;
		PreparedStatement pstam = null;
		PreparedStatement pstam1 = null;
		try {
			pstam1 = conn.prepareStatement("select * article  where atid=? ");
			pstam1.setInt(1, articletype.getAtid());
			int count = pstam1.executeUpdate();
			pstam = conn.prepareStatement("update articletype set atid=?,atype=? where atid=? ");
			pstam.setInt(1, articletype.getAtid());
			pstam.setString(2, articletype.getAtype());
			pstam.setInt(3, articletype.getAtid());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新通知articletype的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Articletype findArticletypeByid(int atid) {
		Articletype articletype = new Articletype();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from articletype where atid = ?");
			pstam.setInt(1, atid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				articletype.setAtid(rs.getInt("atid"));
				articletype.setAtype(rs.getString("atype"));	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户articletype的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return articletype;
	}


}
