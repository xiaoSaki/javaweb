package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ScenicTypeDao;
import com.neuedu.lvcity.model.ScenicType;

public class ScenicTypeDaoImpl implements ScenicTypeDao{
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
	public ScenicTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<ScenicType> findScenictype() {
		//声明变量，用于保存查询结果
		List<ScenicType> scenicTypes = new ArrayList<ScenicType>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from scenictype");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				ScenicType scenicType = new ScenicType();
				scenicType.setStid(rs.getInt("stid"));
				scenicType.setSt(rs.getString("st"));
				scenicTypes.add(scenicType);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			e.printStackTrace();
			System.out.println("在查询scenicType的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return scenicTypes;
	}

	@Override
	public String gettypebyid(int stid) {
		//声明变量，用于保存查询结果
				String result ="";
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select st from scenictype where stid = ?");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					pstam.setInt(1,stid);
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的值		
					while(rs.next()){
						result = rs.getString("st");
					}
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					e.printStackTrace();
					System.out.println("在查询scenicType的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return result;
			}

}
