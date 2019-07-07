package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.PreparedStatement;

import javafx.scene.control.Alert;
import en.edu.lingnan.Dto.ClassDto;
import en.edu.lingnan.util.DataAccess;

public class ClassDao {
	//查询全部班级信息
	public Vector<ClassDto> findallClassInfo()
	{
		Vector<ClassDto> v = new Vector<ClassDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from class where Cflag = 1");
			 while (rs.next())
			 {
				 ClassDto c = new  ClassDto();
				 c.setClassId(rs.getString(1));
				 c.setClassName(rs.getString(2));
				 v.add(c);
			 }
			 
			
		}catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);		
	}
		return v;
	}
	
	//根据班级id号查找
	    public Vector<ClassDto> findClassByid(String cid)
	    {
		       Vector<ClassDto> v = new Vector<ClassDto> ();
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				try {
					 conn=DataAccess.getConnection();
					 stmt = conn.createStatement();
					 String sql = "select * from class where Cid='"+cid+"' and Cflag = 1";
					 rs = stmt.executeQuery(sql);
					 //System.out.println("哈哈，根据id号查找成功！！");
					 while (rs.next())
					 {

						 ClassDto c = new  ClassDto();
						 c.setClassId(rs.getString(1));
						 c.setClassName(rs.getString(2));
						 v.add(c);	 
					 }
				}catch (SQLException e) {
					System.out.println("运行SQL语句出现错误");
					e.printStackTrace();
				}
				finally{
		          DataAccess.closeconn(conn, stmt, prep, rs);
			}
				return v;
			}
		
															
	
     //班级信息删除
	public boolean deleteClassByid(String cid)
	{
		boolean flag=false;
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from class where Cid='"+cid+"' and Cflag = 1" );
			 if(rs.next())
			 {
				 String sql = "update class set Cflag= 0 where Cid='"+cid+"'";
				 stmt.executeUpdate(sql);
				 System.out.println("删除班级信息成功！");
				 
			 }
			 flag=true;	
		}catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);
	}
		return flag;
	}
	

	
	// 班级信息添加
	public void addClassInfo(ClassDto cdto)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		try {
			    conn=DataAccess.getConnection();
				stmt = conn.createStatement();
				String cid = cdto.getClassId();
				String cname = cdto.getClassName();
				
				//查找是否存在cid的数据
				 rs = stmt.executeQuery("select * from class where Cid='" + cid + "'");
				if(rs.next())
				 {
					String sql = "update book set Cflag= 1 where Cid='" + cid + "'";
					stmt.executeUpdate(sql);
					System.out.println("插入成功!");
				 } 
				//没有就将新数据插入
				else {
				String sql = "insert into class(Cid,Cname)"
						+ "values('"+cid+"','"+cname+"')";
				stmt.executeUpdate(sql);
				System.out.println("插入成功!");
				}
		}catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);
	}
	}
	
	//更改
		public  boolean UndateBooksInfo(ClassDto cdto)
		{
			boolean flag2=false;
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String cid = cdto.getClassId();
			String cname = cdto.getClassName();
			try {
				  conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 String sql = "update class set Cid='"+cid+"',Cname='"+cname+"'";
				 stmt.executeUpdate(sql);
				 flag2=true;
			}catch (SQLException e) {
				System.out.println("运行SQL语句出现错误");
				e.printStackTrace();
			}
			finally{
				DataAccess.closeconn(conn, stmt, prep, rs);
				
		}
			return flag2;
		}
		

}