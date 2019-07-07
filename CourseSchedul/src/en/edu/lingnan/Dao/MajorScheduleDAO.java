package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import en.edu.lingnan.Dto.MajorScheduleDTO;
import en.edu.lingnan.util.DataAccess;



public class MajorScheduleDAO {
	//查全部
		/*public Vector<MajorScheduleDTO> findAllMajorSchedule() {
			Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from MajorSchedule where MSflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						MajorScheduleDTO m=new MajorScheduleDTO();						
						m.setCourseID(rs.getString("CourseID"));
						m.setCourseName(rs.getString("CourseName"));
						m.setMajorID(rs.getString("MajorID"));
						m.setCourseTime(rs.getString("CourseTime"));
						m.setYearTime(rs.getString("YearTime"));
						m.setMSflag(rs.getInt("MSflag"));
						m.setTermTime(rs.getString("TermTime"));
						v.add(m);
					}	
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null){
							rs.close();
							rs=null;
						}
						if(stat!=null){
						   stat.close();
						   stat=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}				
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}	
				}
			return v;		
		}
//按ID查
		public Vector<MajorScheduleDTO> findMajorScheduleByID(String _CourseID) {
			Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from MajorSchedule where MSflag=1 and CourseID='"+_CourseID+"'";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						MajorScheduleDTO m=new MajorScheduleDTO();						
						m.setCourseID(rs.getString("CourseID"));
						m.setCourseName(rs.getString("CourseName"));
						m.setMajorID(rs.getString("MajorID"));
						m.setCourseTime(rs.getString("CourseTime"));
						m.setYearTime(rs.getString("YearTime"));
						m.setMSflag(rs.getInt("MSflag"));
						m.setTermTime(rs.getString("TermTime"));
						v.add(m);
					}	
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null){
							rs.close();
							rs=null;
						}
						if(stat!=null){
						   stat.close();
						   stat=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}				
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}	
				}
			return v;		
		}
//按ID查，返回布尔值
		public boolean FindMajorScheduleByID(String _CourseID){
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;	
			Statement stat=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
					String sql="select * from MajorSchedule where MSflag=1 and CourseID='"+_CourseID+"'";
					rs=stat.executeQuery(sql);
					
					conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					
//					prep=conn.prepareStatement//预编译(preparedStatement)接口
//							("select * from StudentInformation where SIflag=1 and StudentID='"+_StudentID+"'");
//					rs=prep.executeQuery();//查找之后的结果赋给一个结果集rs，然后不需要把结果集里的东西取出来，只需判断结果集里是否有记录即可
			        if(rs.first())//如果rs这个结果集里有东西，那么第一行一定有东西
			        	flag=true;
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null){
							rs.close();
							rs=null;
						}
						if(prep!=null){
						   prep.close();
						   prep=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}				
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}	
				}
			return flag;
		}
		
		
		
//增
		public boolean InsertMajorSchedule(MajorScheduleDTO mdto) {
			boolean flag=false;	
			String CourseID=mdto.getCourseID();
			String CourseName=mdto.getCourseName();
			String MajorID=mdto.getMajorID();
			String CourseTime=mdto.getCourseTime();
			String YearTime=mdto.getYearTime();
			int MSflag=1;
			String TermTime=mdto.getTermTime();
			String sql="insert into MajorSchedule values "
					+ "('"+CourseID+"','"+MajorID+"','"+CourseName+"','"+CourseTime+"','"+YearTime+"','"+TermTime+"','"+MSflag+"')";
			Connection conn=null;
			Statement stat=null;	
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					stat.executeUpdate(sql);
					flag=true;
					
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(stat!=null){
						   stat.close();
						   stat=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}				
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}	
				}
			return flag;
		}
//删除
		public boolean deleteMajorScheduleById(String courseid){
			boolean flag=false;
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;	
			ResultSet rs1=null;
			ResultSet rs2=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					rs = stat.executeQuery("select * from MajorSchedule where CourseID='"+courseid+"' and  MSflag = 1");
					 if(rs.next())
					 {
						 rs1 = stat.executeQuery("select * from ClassSchedule where CourseID='" +courseid + "' and  CSflag = 1");
						 if(rs1.next())
						 {
							 String sql1 = "update ClassSchedule set CSflag= 0 where CourseID='" + courseid + "'";
							 stat.executeUpdate(sql1);
							 
						 }
						 rs2 = stat.executeQuery("select * from TeacherCourse where CourseID='" +courseid + "' and  TCflag = 1");
						 if(rs2.next())
						 {
							 String sql2 = "update TeacherCourseset TCflag= 0 where CourseID='" + courseid + "'";
							 stat.executeUpdate(sql2); 
						 }
					   stat.executeUpdate("update MajorSchedule set MSflag=0 where CourseID='"+courseid+"'");	
					  flag=true;
					 }
					 else {
						 flag=false;
					}
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(rs2!=null){
							rs2.close();
							rs2=null;
						}
						if(rs1!=null){
							rs1.close();
							rs1=null;
						}
						if(rs!=null){
							rs.close();
							rs=null;
						}
						if(stat!=null){
						   stat.close();
						   stat=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}			
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}				
				}
			return flag;		
		}
//改
		public boolean updateMajorSchedule( MajorScheduleDTO mdto) {
			boolean flag=false;
            String CourseID=mdto.getCourseID();
            String MajorID=mdto.getMajorID();
            String Coursename=mdto.getCourseName();
            String CourseTime=mdto.getCourseTime();
            String YearTime=mdto.getYearTime();
            String TermTime=mdto.getTermTime();
            int MSflag=1;
			String sql="update MajorSchedule set MajorID='"+MajorID+"',Coursename='"+Coursename+"',CourseTime='"+CourseTime+"',YearTime='"+YearTime+"',TermTime='"+TermTime+"',MSflag='"+MSflag+"' where CourseID='"+CourseID+"'";
			Connection conn=null;
			Statement stat=null;	
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					stat.executeUpdate(sql);
					flag=true;
					
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally{
					try {
						if(stat!=null){
						   stat.close();
						   stat=null;
						}
						if(conn!=null){
						   conn.close();
						   conn=null;
						}				
					} catch (SQLException e) {
						System.out.println("关闭连接、语句及结果集时出现错误");
						e.printStackTrace();
					}	
				}
			return flag;
		}
//
//		public static void main(String[] args) 
//		{
//			MajorScheduleDAO mdao=new MajorScheduleDAO();
//			 MajorScheduleDTO mdto = new MajorScheduleDTO();
//			Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
//			//1、测试返回Vector<MajorScheduleDTO>的findAllMajorSchedule()
//			v=mdao.findAllMajorSchedule();
//			 java.util.Iterator<MajorScheduleDTO> it = v.iterator();
//			 MajorScheduleDTO m = null;
//			    while(it.hasNext()){
//				m = (MajorScheduleDTO)it.next();
//			  System.out.println( m.getCourseID()+m.getCourseName()+m.getCourseTime()+m.getMajorID()+" "+m.getMSflag()+m.getTermTime()+m.getYearTime());
//			    }
			    
//			    //2、测试返回Vector<MajorScheduleDTO>的findAClassSchedualByID("c01")
//				v=mdao.findMajorScheduleByID("m01");
//				 Iterator<MajorScheduleDTO> it = v.iterator();
//				 MajorScheduleDTO m = null;
//				    while(it.hasNext()){
//					m = (MajorScheduleDTO)it.next();
//				  System.out.println(m.getCourseID()+m.getCourseName()+m.getCourseTime()+m.getMajorID()+" "+m.getMSflag()+m.getTermTime()+m.getYearTime());
//				    }
			
//			//3、测试增加
//			String CourseID="cc10";
//			String MajorID="m03";
//			String CourseName="UML建模";
//			String CourseTime="48学时";
//			String YearTime="大三";
//			String TermTime="上学期";
//			int MSflag=1;
//			mdto.setCourseID(CourseID);
//			mdto.setMajorID(MajorID);
//			mdto.setCourseName(CourseName);
//			mdto.setCourseTime(CourseTime);
//			mdto.setYearTime(YearTime);
//			mdto.setTermTime(TermTime);
//			mdto.setMSflag(MSflag);
//			boolean flag=mdao.InsertMajorSchedule(mdto);
//			System.out.println(flag);

            //4、测试删除
//			boolean flag=mdao.deleteMajorScheduleById("cc01");
//			System.out.println(flag);
			
			//5、测试更改
//			String CourseID="cc10";
//			String MajorID="m05";
//			String CourseName="数据发掘";
//			String CourseTime="48学时";
//			String YearTime="大三";
//			String TermTime="下学期";
//			int MSflag=1;
//			mdto.setCourseID(CourseID);
//			mdto.setMajorID(MajorID);
//			mdto.setCourseName(CourseName);
//			mdto.setCourseTime(CourseTime);
//			mdto.setYearTime(YearTime);
//			mdto.setTermTime(TermTime);
//			mdto.setMSflag(MSflag);
//			boolean flag=mdao.updateMajorSchedule(mdto);
//			System.out.println(flag);
//			
//			    
//		}		

}*/
	//查全部
			public Vector<MajorScheduleDTO> findAllMajorSchedule() {
				Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
				Connection conn=null;
				Statement stat=null;
				ResultSet rs=null;		
				try {
						conn=DataAccess.getConnection();
						stat=conn.createStatement();//创建SQL语句对象并执行
						String sql="select * from MajorSchedule where MSflag=1";
						rs=stat.executeQuery(sql);
						while(rs.next()){ //处理结果集
							MajorScheduleDTO m=new MajorScheduleDTO();						
							m.setCourseID(rs.getString("CourseID"));
							m.setCourseName(rs.getString("CourseName"));
							m.setMajorID(rs.getString("MajorID"));
							m.setCourseTime(rs.getString("CourseTime"));
							m.setYearTime(rs.getString("YearTime"));
							m.setMSflag(rs.getInt("MSflag"));
							m.setTermTime(rs.getString("TermTime"));
							m.setEveryWeekCourseTime(rs.getInt("EveryWeekCourseTime"));
							m.setClassroomType(rs.getString("ClassroomType"));
							v.add(m);
						}	
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(rs!=null){
								rs.close();
								rs=null;
							}
							if(stat!=null){
							   stat.close();
							   stat=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}				
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}	
					}
				return v;		
			}
	//按ID查
			public Vector<MajorScheduleDTO> findMajorScheduleByID(String _CourseID) {
				Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
				Connection conn=null;
				Statement stat=null;
				ResultSet rs=null;		
				try {
						conn=DataAccess.getConnection();
						stat=conn.createStatement();//创建SQL语句对象并执行
						String sql="select * from MajorSchedule where MSflag=1 and CourseID='"+_CourseID+"'";
						rs=stat.executeQuery(sql);
						while(rs.next()){ //处理结果集
							MajorScheduleDTO m=new MajorScheduleDTO();						
							m.setCourseID(rs.getString("CourseID"));
							m.setCourseName(rs.getString("CourseName"));
							m.setMajorID(rs.getString("MajorID"));
							m.setCourseTime(rs.getString("CourseTime"));
							m.setYearTime(rs.getString("YearTime"));
							m.setMSflag(rs.getInt("MSflag"));
							m.setEveryWeekCourseTime(rs.getInt("EveryWeekCourseTime"));
							m.setTermTime(rs.getString("TermTime"));
							m.setClassroomType(rs.getString("ClassroomType"));
							v.add(m);
						}	
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(rs!=null){
								rs.close();
								rs=null;
							}
							if(stat!=null){
							   stat.close();
							   stat=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}				
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}	
					}
				return v;		
			}
	//按ID查，返回布尔值
			public boolean FindMajorScheduleByID(String _CourseID){
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;	
				Statement stat=null;
				try {
						conn=DataAccess.getConnection();
						stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
						String sql="select * from MajorSchedule where MSflag=1 and CourseID='"+_CourseID+"'";
						rs=stat.executeQuery(sql);
						
						conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						
//						prep=conn.prepareStatement//预编译(preparedStatement)接口
//								("select * from StudentInformation where SIflag=1 and StudentID='"+_StudentID+"'");
//						rs=prep.executeQuery();//查找之后的结果赋给一个结果集rs，然后不需要把结果集里的东西取出来，只需判断结果集里是否有记录即可
				        if(rs.first())//如果rs这个结果集里有东西，那么第一行一定有东西
				        	flag=true;
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(rs!=null){
								rs.close();
								rs=null;
							}
							if(prep!=null){
							   prep.close();
							   prep=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}				
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}	
					}
				return flag;
			}
			
			
			
	//增
			public boolean InsertMajorSchedule(MajorScheduleDTO mdto) {
				boolean flag=false;	
				String CourseID=mdto.getCourseID();
				String CourseName=mdto.getCourseName();
				String MajorID=mdto.getMajorID();
				String CourseTime=mdto.getCourseTime();
				String YearTime=mdto.getYearTime();
				String ClassroomType=mdto.getClassroomType();
				int MSflag=1;
				int EveryWeekCourseTime = mdto.getEveryWeekCourseTime();
				String TermTime=mdto.getTermTime();
				Statement stmt = null;
				ResultSet rs = null;
				ResultSet rs1 = null;
				Connection conn=null;	
				conn=DataAccess.getConnection();
				try{
				conn=DataAccess.getConnection();
				stmt = conn.createStatement();
				//查找是否存在roomid的数据
				 rs = stmt.executeQuery("select * from MajorSchedule where CourseID='"+CourseID+"' and MSflag=1");
				if(rs.next())
				 {
					flag=false;
					 JOptionPane.showMessageDialog(null, "你添加的课程表已经存在！", "提示", JOptionPane.ERROR_MESSAGE);
					
				 }
				//没有就将新数据插入MSflag
				else {
					rs1 = stmt.executeQuery("select * from MajorInformation where MajorID='"+MajorID+"' and MIflag=1");
					if(rs1.next())
					{
			            String sql="insert into MajorSchedule values(CourseID,MajorID,CourseName,CourseTime,YearTime,TermTime,MSflag,ClassroomType,EveryWeekCourseTime) "
						+ "('"+CourseID+"','"+MajorID+"','"+CourseName+"','"+CourseTime+"','"+YearTime+"','"+TermTime+"',"+MSflag+",'"+ClassroomType+"',"+EveryWeekCourseTime+")";
						stmt.executeUpdate(sql);
						flag=true;
					}
						else
						{
							flag = false;
						}
					
					}
						
				}
				catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(rs1!=null){
								rs1.close();
								rs1=null;
							}
							if(rs!=null){
								rs.close();
								rs=null;
							}
							if(stmt!=null){
							   stmt.close();
							   stmt=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}				
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}	
					}
				return flag;
			}
	//删除
			public boolean deleteMajorScheduleById(String courseid){
				boolean flag=false;
				Connection conn=null;
				Statement stat=null;
				ResultSet rs=null;	
				ResultSet rs1=null;
				ResultSet rs2=null;
				try {
						conn=DataAccess.getConnection();
						stat=conn.createStatement();//创建SQL语句对象并执行
						rs = stat.executeQuery("select * from MajorSchedule where CourseID='"+courseid+"' and  MSflag = 1");
						 if(rs.next())
						 {
							 rs1 = stat.executeQuery("select * from ClassSchedule where CourseID='" +courseid + "' and  CSflag = 1");
							 if(rs1.next())
							 {
								 String sql1 = "update ClassSchedule set CSflag= 0 where CourseID='" + courseid + "'";
								 stat.executeUpdate(sql1);
								 
							 }
							 rs2 = stat.executeQuery("select * from TeacherCourse where CourseID='" +courseid + "' and  TCflag = 1");
							 if(rs2.next())
							 {
								 String sql2 = "update TeacherCourseset TCflag= 0 where CourseID='" + courseid + "'";
								 stat.executeUpdate(sql2); 
							 }
						   stat.executeUpdate("update MajorSchedule set MSflag=0 where CourseID='"+courseid+"'");	
						  flag=true;
						 }
						 else {
							 flag=false;
						}
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(rs2!=null){
								rs2.close();
								rs2=null;
							}
							if(rs1!=null){
								rs1.close();
								rs1=null;
							}
							if(rs!=null){
								rs.close();
								rs=null;
							}
							if(stat!=null){
							   stat.close();
							   stat=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}			
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}				
					}
				return flag;		
			}
	//改
			public boolean updateMajorSchedule( MajorScheduleDTO mdto) {
				boolean flag=false;
	            String CourseID=mdto.getCourseID();
	            String MajorID=mdto.getMajorID();
	            String Coursename=mdto.getCourseName();
	            String CourseTime=mdto.getCourseTime();
	            String YearTime=mdto.getYearTime();
	            String TermTime=mdto.getTermTime();
	            String ClassroomType=mdto.getClassroomType();
	            int MSflag=1;
	            int EveryWeekCourseTime = mdto.getEveryWeekCourseTime();
				String sql="update MajorSchedule set MajorID='"+MajorID+"',Coursename='"+Coursename+"',CourseTime='"+CourseTime+"',YearTime='"+YearTime+"',TermTime='"+TermTime+"',MSflag="+MSflag+",EveryWeekCourseTime="+EveryWeekCourseTime+",ClassroomType='"+ClassroomType+"' where CourseID='"+CourseID+"'";
				Connection conn=null;
				Statement stat=null;	
				try {
						conn=DataAccess.getConnection();
						stat=conn.createStatement();//创建SQL语句对象并执行
						stat.executeUpdate(sql);
						flag=true;
						
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally{
						try {
							if(stat!=null){
							   stat.close();
							   stat=null;
							}
							if(conn!=null){
							   conn.close();
							   conn=null;
							}				
						} catch (SQLException e) {
							System.out.println("关闭连接、语句及结果集时出现错误");
							e.printStackTrace();
						}	
					}
				return flag;
			}
}

//			public static void main(String[] args) 
//			{
//				MajorScheduleDAO mdao=new MajorScheduleDAO();
//				 MajorScheduleDTO mdto = new MajorScheduleDTO();
//				Vector<MajorScheduleDTO> v=new Vector<MajorScheduleDTO>();
//				//1、测试返回Vector<MajorScheduleDTO>的findAllMajorSchedule()
//				v=mdao.findAllMajorSchedule();
//				 java.util.Iterator<MajorScheduleDTO> it = v.iterator();
//				 MajorScheduleDTO m = null;
//				    while(it.hasNext()){
//					m = (MajorScheduleDTO)it.next();
//				  System.out.println( m.getCourseID()+m.getCourseName()+m.getCourseTime()+m.getMajorID()+" "+m.getMSflag()+m.getTermTime()+m.getYearTime());
//				    }
				    
//				    //2、测试返回Vector<MajorScheduleDTO>的findAClassSchedualByID("c01")
//					v=mdao.findMajorScheduleByID("m01");
//					 Iterator<MajorScheduleDTO> it = v.iterator();
//					 MajorScheduleDTO m = null;
//					    while(it.hasNext()){
//						m = (MajorScheduleDTO)it.next();
//					  System.out.println(m.getCourseID()+m.getCourseName()+m.getCourseTime()+m.getMajorID()+" "+m.getMSflag()+m.getTermTime()+m.getYearTime());
//					    }
				
//				//3、测试增加
//				String CourseID="cc10";
//				String MajorID="m03";
//				String CourseName="UML建模";
//				String CourseTime="48学时";
//				String YearTime="大三";
//				String TermTime="上学期";
//				int MSflag=1;
//				mdto.setCourseID(CourseID);
//				mdto.setMajorID(MajorID);
//				mdto.setCourseName(CourseName);
//				mdto.setCourseTime(CourseTime);
//				mdto.setYearTime(YearTime);
//				mdto.setTermTime(TermTime);
//				mdto.setMSflag(MSflag);
//				boolean flag=mdao.InsertMajorSchedule(mdto);
//				System.out.println(flag);

	            //4、测试删除
//				boolean flag=mdao.deleteMajorScheduleById("cc01");
//				System.out.println(flag);
				
				//5、测试更改
//				String CourseID="cc10";
//				String MajorID="m05";
//				String CourseName="数据发掘";
//				String CourseTime="48学时";
//				String YearTime="大三";
//				String TermTime="下学期";
//				int MSflag=1;
//				mdto.setCourseID(CourseID);
//				mdto.setMajorID(MajorID);
//				mdto.setCourseName(CourseName);
//				mdto.setCourseTime(CourseTime);
//				mdto.setYearTime(YearTime);
//				mdto.setTermTime(TermTime);
//				mdto.setMSflag(MSflag);
//				boolean flag=mdao.updateMajorSchedule(mdto);
//				System.out.println(flag);
				
				   	

	

