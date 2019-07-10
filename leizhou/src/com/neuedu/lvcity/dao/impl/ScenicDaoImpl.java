package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ScenicDao;
import com.neuedu.lvcity.model.Scenic;

public class ScenicDaoImpl implements ScenicDao{
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
	public ScenicDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int getCountByStid(int stid) {
		//声明变量，用于保存查询结果
				int result = 0;
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select count(*) from scenic where stid = ? and lx= ? ");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					pstam.setInt(1, stid);
					pstam.setString(2, "景点");
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
					while(rs.next()){
						result = rs.getInt("count(*)");
					}			
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					e.printStackTrace();
					System.out.println("在查询某分类全部风景的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return result;
	}

	@Override
	public List<Scenic> scenicListByStid(int stid, int start) {
		//声明变量，用于保存查询结果
				List<Scenic> scenics = new ArrayList<Scenic>();
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select * from scenic where stid = ? and lx=? limit  ?,9");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					pstam.setInt(1, stid);
					pstam.setString(2, "景点");
					pstam.setInt(3, start);
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
					while(rs.next()){
						Scenic scenic = new Scenic();
						scenic.setAid(rs.getInt("aid"));
						scenic.setSid(rs.getInt("sid"));
						scenic.setStid(rs.getInt("stid"));
						scenic.setSname(rs.getString("sname"));
						scenic.setImage(rs.getString("image"));
						scenics.add(scenic);
					}
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					e.printStackTrace();
					System.out.println("在查询scenics的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return scenics;
	}

	@Override
	public int getCountByLike(String like, int stid) {
		//声明变量，用于保存查询结果
		int result = 0;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select count(*) from scenic where sname like ? and  stid= ? and lx=?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setString(1, like);
			pstam.setInt(2, stid);
			pstam.setString(3, "景点");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
				//System.out.println(result);
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			e.printStackTrace();
			System.out.println("在统计满足模糊查询条件风景数量的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}

	@Override
	public List<Scenic> scenicListByLike(String like, int stid, int start) {
		//声明变量，用于保存查询结果
		List<Scenic> scenics = new ArrayList<Scenic>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from scenic where sname like ? and stid =? and lx=? limit  ?,9");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setString(1, like);
			pstam.setInt(2, stid);
			pstam.setString(3, "景点");
			pstam.setInt(4, start);
			
			rs = pstam.executeQuery();
		
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				Scenic scenic = new Scenic();
				scenic.setAid(rs.getInt("aid"));
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));
				scenics.add(scenic);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			e.printStackTrace();
			System.out.println("在查询满足模糊条件的scenics的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return scenics;
	}

}
