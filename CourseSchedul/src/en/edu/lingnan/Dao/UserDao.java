package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.PreparedStatement;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xpath.internal.operations.And;
import en.edu.lingnan.Dto.UserDto;
import en.edu.lingnan.util.DataAccess;

public class UserDao  {
	//查询信息所有用户信息
	public Vector<UserDto> findalluserInfo()
	{
		Vector<UserDto> v = new Vector<UserDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from UserInformation");
			 while (rs.next())
			 {
				 UserDto a = new  UserDto();
				 a.setUserId(rs.getString(1));
				 a.setUserName(rs.getString(2));
				 a.setUserSex(rs.getString(3));
				 a.setPassword(rs.getString(4));
				 a.setUserAuth(rs.getString(5));
				 a.setUflag(rs.getInt(6));
				 v.add(a);
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

	
	//根据id号查询用户信息
		public Vector<UserDto> finduserInfoByid(String aid)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from UserInformation where UserID = '"+aid+"' and Uflag = 1");
				 while (rs.next())
				 {
					 UserDto a = new  UserDto();
					 a.setUserId(rs.getString(1));
					 a.setUserName(rs.getString(2));
					 a.setUserSex(rs.getString(3));
					 a.setPassword(rs.getString(4));
					 a.setUserAuth(rs.getString(5));
					 a.setUflag(rs.getInt(6));
					 v.add(a);
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
		
		
		//根据账号密码查询用户id号
		public Vector<UserDto> finduserinfor(String user,String password)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from UserInformation where UserId='"+user+"' and UserPsw='"+password+"' and Uflag = 1");
				 while (rs.next())
				 {
					 UserDto a = new  UserDto();
					 a.setUserId(rs.getString(1));
					// a.setPassword(rs.getString(4));
					 v.add(a);
					
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
		
//查找id号是否存在
		    public boolean finduserId_in(String aid)
			   	{
					Vector<UserDto> v = new Vector<UserDto> ();
					Connection conn = null;
				    Statement stmt = null;
				    PreparedStatement prep = null;
					ResultSet rs = null;
					boolean flag = false;
					try {
						 conn=DataAccess.getConnection();
						 stmt = conn.createStatement();
						 rs = stmt.executeQuery("select * from UserInformation where UserID = '"+aid+"' and Ufalg = 1");
						 while (rs.next())
						 {
							 flag = true;
						 }

					}catch (SQLException e) {
						System.out.println("运行SQL语句出现错误");
						e.printStackTrace();
					}
					finally{
						DataAccess.closeconn(conn, stmt, prep, rs);		
				}
					return flag;
				}
    //用户添加·
	//信息添加
		public boolean addUserInfo(UserDto adto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String userid = adto.getUserId();
			String password = adto.getPassword();
			String usersex = adto.getUserSex();
			String superuser = adto.getUserAuth();
			String username = adto.getUserName();
			boolean flag = false;
			try {
				 conn=DataAccess.getConnection();
					stmt = conn.createStatement();
				    rs=stmt.executeQuery("select * from UserInformation where UserID ='"+userid+"'");
				    if(rs.next())
				    {
				    	String sql1 = "update UserInformation set Uflag =1 where UserID='"+userid+"'";
						 stmt.executeUpdate(sql1);
				    }
				    else {
				    	String sql = "insert into UserInformation(UserId,UserName,UserSex,UserPsw,UserAuth)"
								+ "values('"+userid+"','"+username+"','"+usersex+"','"+password+"','"+superuser+"')";
						stmt.executeUpdate(sql);
					}
					flag = true;
					System.out.println("插入成功。。。");
			}catch (SQLException e) {
				System.out.println("运行SQL语句出现错误");
				e.printStackTrace();
			}
			finally{
				DataAccess.closeconn(conn, stmt, prep, rs);
		}
			return flag;
		}
		
		
		//用户信息修改
		public  boolean UpdateUserInfo(UserDto adto)
		{
			boolean flag2=false;
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String userid = adto.getUserId();
			String password = adto.getPassword();
			String usersex = adto.getUserSex();
			String superuser = adto.getUserAuth();
			String username = adto.getUserName();
			int Uflag = adto.getUflag();
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 String sql = "update UserInformation set UserId='"+userid+"',UserName='"+username+"',UserSex='"+usersex+"',UserPsw='"+password+"',UserAuth='"+superuser+"',Uflag='"+Uflag+"' where UserID = '"+userid+"'";
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
		

	// 修改账号，密码
		//用户信息修改
		public  boolean UpdateUserandpwd(String userid,String pwd)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			boolean flag2=false;
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			UserDto udto = new UserDto();
			//String aid= udto.getAid();
		    userid = udto.getUserId();
			pwd = udto.getPassword();
			v = finduserinfor(userid,pwd);
			UserDto name = v.elementAt(1);
			UserDto sex = v.elementAt(2);
		//	Vector<UserDto> aid =v;
			String superuser = "2";
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 String sql = "update UserInformation set UserID='"+userid+"',UserPsw='"+pwd+"',UserAuth='"+superuser+"',UserName='"+name+"',UserSex='"+sex+"' where UserID = '"+userid+"' and Ufalg = 1";
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
			      
		
		
		
//用户登录界面
public String LoginUserInfo(String userid,String password)
{
	Connection conn = null;
    Statement stmt = null;
    PreparedStatement prep = null;
	ResultSet rs = null;
	String str = null;
    try{               
    		conn=DataAccess.getConnection();
			stmt = conn.createStatement();        
			String sql="select * from UserInformation where UserID='"+userid+"' and Uflag = 1" ;       
            rs=stmt.executeQuery(sql);
            if(rs.next())
            {
        	 if((rs.getString("UserPsw").trim()).equals(password))         
    	 {        
            str = rs.getString("UserAuth");     
    	 }
            }
        	 else {
        		 str="No";
             	System.out.println("输入密码或账号有误");
     		} 
        	 
        
    } 

    catch (SQLException e)
    {
        System.out.println("运行SQL语句出现错误");
        e.printStackTrace();
     		}
     finally{
     			DataAccess.closeconn(conn, stmt, prep, rs);		
     	}

		return str;
}

//删除用户
public boolean deleteUsersByid(String aid) 
{
	Connection conn = null;
    PreparedStatement prep = null;
    Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	boolean flag = true;
	try {
		 conn=DataAccess.getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery("select * from UserInformation where UserID='"+aid+"' and  Uflag = 1");
		 if(rs.next())
		 {
			 rs1 = stmt.executeQuery("select * from StudentInformation where StudentID='" + aid + "' and  SIflag = 1");
			 if(rs1.next())
			 {
				 String sql1 = "update StudentInformation set SIflag= 0 where StudentID='" + aid + "'";
				 stmt.executeUpdate(sql1);
				 
			 }
			 rs2 = stmt.executeQuery("select * from TeacherInformation where TeacherID='" + aid + "' and  TIflag = 1");
			 if(rs2.next())
			 {
				 String sql2 = "update TeacherInformation set TIflag= 0 where TeacherID='" + aid + "'";
				 stmt.executeUpdate(sql2);
				 
			 }
			 String sql = "update UserInformation set Uflag=0 where UserID='"+aid+"'";
			 stmt.executeUpdate(sql);
			 flag=true;
			 
		 }
		 else {
			flag=false;
		}
	}catch (SQLException e) {
		System.out.println("运行SQL语句出现错误");
		e.printStackTrace();
	}
	finally{
		try {
			if(rs2 != null)
			{
				rs2.close();
				rs2 = null;
			}
			if(rs1 != null)
			{
				rs1.close();
				rs1 = null;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		DataAccess.closeconn(conn, stmt, prep, rs);
}
	return flag;
}

}
