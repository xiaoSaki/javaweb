package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.ClassRoomUseDto;
import en.edu.lingnan.util.DataAccess;

public class ClassRoomUseDao {
	//查询信教室使用状态信息
		public Vector<ClassRoomUseDto> findClassRoomUseInfo()
		{
			Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from ClassroomUse where CUflag = 1");
				 while (rs.next())
				 {
					 ClassRoomUseDto a = new  ClassRoomUseDto();
					 a.setRoomUserid(rs.getString(1));
					 a.setRoomid(rs.getString(2));
					 a.setWeekday(rs.getString(3));
					 a.setClasstime(rs.getString(4));
					 a.setUserstate(rs.getString(5));
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
		//根据教室编号查找
		public Vector<ClassRoomUseDto>findClassRoomUseByid(String cid)
		{
			Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto> ();
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from ClassroomUse where ClassroomUserID='"+cid+"' and CUflag = 1");
				 while (rs.next())
				 {
					 ClassRoomUseDto a = new  ClassRoomUseDto();
					 a.setRoomUserid(rs.getString(1));
					 a.setRoomid(rs.getString(2));
					 a.setWeekday(rs.getString(3));
					 a.setClasstime(rs.getString(4));
					 a.setUserstate(rs.getString(5));
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
		
	//根据教室编号删除
		public boolean deleteClassRoomUseByid(String cid)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			boolean flag = false;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from ClassroomUse where ClassroomUserID='"+cid+"' and CUflag = 1");
				 if(rs.next())
				 {
					 String sql = "update ClassroomUse set CUflag = 0 where ClassroomUserID='"+cid+"'";
					 stmt.executeUpdate(sql);
					 System.out.println("删除教室使用信息成功！");
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
				
		   
			//添加教室使用状态信息
			public boolean addClassRoomUseInfo(ClassRoomUseDto cto)
				{
					Connection conn = null;
				    PreparedStatement prep = null;
				    Statement stmt = null;
					ResultSet rs = null;
					ResultSet rs1 = null;
					boolean flag = false;
					String roomuserid = cto.getRoomUserid();
					String roomid = cto.getRoomid();
					String WeekDay = cto.getWeekday();
					String classtime = cto.getClasstime();
					String userstatus = cto.getUserstate();
					try {
						 conn=DataAccess.getConnection();
							stmt = conn.createStatement();
							//查找是否存在roomid的数据
							 rs = stmt.executeQuery("select * from ClassroomUse where ClassroomUserID='"+roomuserid+"'");
							if(rs.next())
							 {
								String sql = "update ClassroomUse set CUflag= 1 where ClassroomUserID='"+roomuserid+"'";
								stmt.executeUpdate(sql);
								System.out.println("插入图书成功!");
								flag = true;
							 } 
							//没有就将新数据插入
							else {
								rs1 = stmt.executeQuery("select * from Classroom where ClassroomID='"+roomid+"'");
								if(rs1.next())
								{
								
							String sql = "insert into ClassroomUse(ClassroomUserID,ClassroomID,WeekDay,ClassTime,Status)"
									+ "values('"+roomuserid+"','"+roomid+"','"+WeekDay+"','"+classtime+"','"+userstatus+"')";
						    stmt.executeUpdate(sql);
						    System.out.println("插入图书成功!");
						    flag = true;
								}
								else
								{
									flag = false;
								}
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
			//教室使用状态信息更改
				public boolean UpdateClassRoomUseInfo(ClassRoomUseDto cto)
				{
					Connection conn = null;
				    PreparedStatement prep = null;
				    Statement stmt = null;
					ResultSet rs = null;
					boolean flag = false;
					String roomuserid = cto.getRoomUserid();
					String roomid = cto.getRoomid();
					String weekDay = cto.getWeekday();
					String classtime = cto.getClasstime();
					String userstatus = cto.getUserstate();
					try {
						    conn=DataAccess.getConnection();
						    stmt = conn.createStatement();                
						    String sql = "update ClassroomUse set ClassroomUserID='"+roomuserid+"',ClassroomID='"+roomid+"',WeekDay='"+weekDay+"',ClassTime='"+classtime+"',Status='"+userstatus+"' where ClassroomUserID='"+roomuserid+"' and CUflag = 1";
						    stmt.executeUpdate(sql);
						    System.out.println("教室使用信息修改成功!");
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
