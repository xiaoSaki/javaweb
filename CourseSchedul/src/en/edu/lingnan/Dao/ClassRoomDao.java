package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.util.DataAccess;


public class ClassRoomDao {
	//查询信教室信息
	public Vector<ClassRoomDto> findClassRoomInfo()
	{
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from ClassroomInformation where CRIflag = 1");
			 while (rs.next())
			 {
				 ClassRoomDto a = new  ClassRoomDto();
				 a.setRoomid(rs.getString(1));
				 a.setRoomname(rs.getString(2));
				 a.setRoomtype(rs.getString(3));
				 a.setMaxnum(rs.getInt(4));
				 v.add(a);
			 }
			 for(ClassRoomDto sd:v)
				{
					System.out.println(sd.getRoomid()+"    "+sd.getRoomname()+"           "+sd.getRoomtype()+"            "+sd.getMaxnum()+"");
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
	//根据教室编号查找
	public Vector<ClassRoomDto>findClassRoomByid(String cid)
	{
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from ClassroomInformation where ClassroomID='"+cid+"' and CRIflag = 1");
			 while (rs.next())
			 {
				 ClassRoomDto a = new  ClassRoomDto();
				 a.setRoomid(rs.getString(1));
				 a.setRoomname(rs.getString(2));
				 a.setRoomtype(rs.getString(3));
				 a.setMaxnum(rs.getInt(4));
				 v.add(a);
			 }
			 for(ClassRoomDto sd:v)
				{
					System.out.println(sd.getRoomid()+"    "+sd.getRoomname()+"           "+sd.getRoomtype()+"            "+sd.getMaxnum()+"");
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

	  //根据教室编号删除
		public boolean deleteClassRoomByid(String cid)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			boolean flag = false;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from ClassroomInformation where ClassroomID='"+cid+"' and CRIflag = 1");
				 if(rs.next())
				 {
					 String sql = "update ClassroomInformation set CRIflag = 0 where ClassroomID='"+cid+"'";
					 stmt.executeUpdate(sql);
					 rs1 = stmt.executeQuery("select * from ClassroomUse where ClassroomID='"+cid+"' and CUflag = 1");
					 if(rs1.next())
					 {
					 String sql1 = "update ClassroomUse set CUflag = 0 where ClassroomID='"+cid+"'";
					 stmt.executeUpdate(sql1);
					 }
					 
					 rs2 = stmt.executeQuery("select * from TeacherCourse where ClassroomID='"+cid+"' and TCflag = 1");
					 if(rs2.next())
					 {
					 String sql2 = "update TeacherCourse set TCflag = 0 where ClassroomID='"+cid+"'";
					 stmt.executeUpdate(sql2);
					 }
					 
					 rs3 = stmt.executeQuery("select * from ClassSchedule where ClassroomID='"+cid+"' and CSflag = 1");
					 if(rs3.next())
					 {
					 String sql3 = "update ClassSchedule set CSflag = 0 where ClassroomID ='"+cid+"'";
					 stmt.executeUpdate(sql3);
					 }
					 
					 System.out.println("删除图书成功！");
					 flag = true;
				 }
				 else {
					 flag = false;
				}
			}catch (SQLException e) {
				System.out.println("运行SQL语句出现错误");
				e.printStackTrace();
			}
			finally{
				try{
					if(rs3 != null)
					{
						rs3.close();
						rs3 = null;
					}
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
		
	//添加教室信息
	 public boolean addClassRoomInfo(ClassRoomDto cto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			boolean flag = false;
			String roomid = cto.getRoomid();
			String roomName = cto.getRoomname();
			int maxnum = cto.getMaxnum();
			String roomtype = cto.getRoomtype();
			try {
				 conn=DataAccess.getConnection();
					stmt = conn.createStatement();
					//查找是否存在roomid的数据
					 rs = stmt.executeQuery("select * from ClassroomInformation where ClassroomID='"+roomid+"'");
					if(rs.next())
					 {
						String sql = "update book set Bflag= 1 where ClassroomID='"+roomid+"'";
						stmt.executeUpdate(sql);
						System.out.println("插入图书成功!");
						flag = true;
					 } 
					//没有就将新数据插入
					else {
						
					String sql = "insert into ClassroomInformation(ClassroomID,ClassroomName,NumberMax,ClassroomType)"
							+ "values('"+roomid+"','"+roomName+"',"+maxnum+",'"+roomtype+"')";
				    stmt.executeUpdate(sql);
				    System.out.println("插入图书成功!");
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
	//教室信息更改
			public boolean UpdateClassRoomInfo(ClassRoomDto cto)
			{
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				boolean flag = false;
				String cid = cto.getRoomid();
				String cname = cto.getRoomname();
				int maxnum = cto.getMaxnum();
				String ctype = cto.getRoomtype();
				try {
					    conn=DataAccess.getConnection();
					    stmt = conn.createStatement();                
					    String sql = "update ClassroomInformation set ClassroomID='"+cid+"',ClassroomName='"+cname+"',NumberMax="+maxnum+",ClassroomType='"+ctype+"' where ClassroomID='"+cid+"' and CRIflag = 1";
					    stmt.executeUpdate(sql);
					    System.out.println("修改成功!");
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

}
