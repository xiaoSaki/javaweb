package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmBanarDao;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Banar;

public class AdmBanarDaoImpl implements AdmBanarDao{
	
	private Connection conn;//数据库连接
	public AdmBanarDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Banar> findBanar() {
		List<Banar> list = new ArrayList<Banar>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from banar");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Banar banar = new Banar();
				banar.setBanarid(rs.getInt("banarid"));
				banar.setImage(rs.getString("image"));
				banar.setState(rs.getInt("state"));
				list.add(banar);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户banar的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteBanar(int banarid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("delete from banar where banarid = ?");
			pstam.setInt(1, banarid);
			int i =pstam.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除banar的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addBanar(Banar banar) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into banar (banarid,image,state) values(?,?,?) ");
			pstam.setInt(1, banar.getBanarid());
			pstam.setInt(3, banar.getState());
			pstam.setString(2, banar.getImage());
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
	public boolean updateBanar(Banar banar) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update banar set banarid=?,image=?,state=? where banarid=? ");
			pstam.setInt(1, banar.getBanarid());
			pstam.setInt(3, banar.getState());
			pstam.setString(2, banar.getImage());
			pstam.setInt(4, banar.getBanarid());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新通知banar的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Banar findBanarByid(int banarid) {
		Banar banar = new Banar();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from banar where banarid = ?");
			pstam.setInt(1, banarid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				banar.setBanarid(rs.getInt("banarid"));
				banar.setImage(rs.getString("image"));
				banar.setState(rs.getInt("state"));
				
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户banar的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return banar;
	}


}
