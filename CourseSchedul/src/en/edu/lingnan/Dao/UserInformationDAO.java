package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.UserDto;
import en.edu.lingnan.Dto.UserInformationDTO;
import en.edu.lingnan.util.DataAccess;



public class UserInformationDAO {
	//按ID查，返回布尔值
	public boolean FindAUserInfo(String _TeacherID){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;	
		Statement stat=null;
		try {
				conn=DataAccess.getConnection();
				stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
				String sql="select * from TeacherInformation where TIflag=1 and TeacherID='"+_TeacherID+"'";
				rs=stat.executeQuery(sql);
				
				conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
//				prep=conn.prepareStatement//预编译(preparedStatement)接口
//						("select * from StudentInformation where SIflag=1 and StudentID='"+_StudentID+"'");
//				rs=prep.executeQuery();//查找之后的结果赋给一个结果集rs，然后不需要把结果集里的东西取出来，只需判断结果集里是否有记录即可
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
	//查
	public int FindUserByIdAndPassword(String _uid,String _password){
		int superValue = 0;
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;	
		try {
				conn=DataAccess.getConnection();
				stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
				String sql="select * from UserInformation where Userid='"+_uid+"' and UserPsw='"+_password+"'";
				rs=stat.executeQuery(sql);
				
				//查找之后的结果赋给一个结果集rs，然后不需要把结果集里的东西取出来，只需判断结果集里是否有记录即可
		        if(rs.first())//如果rs这个结果集里有东西，那么第一行一定有东西
		        {
//		        	superValue =Integer.parseInt(rs.getString("UserAuth"));
		        	superValue=Integer.parseInt(rs.getString("UserAuth").trim());
		        	System.out.println("------1-----"+superValue);
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
		return superValue;
	}
//查全部
		public Vector<UserInformationDTO> findAllUserInfo() {
			Vector<UserInformationDTO> v=new Vector<UserInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from UserInformation where Uflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						UserInformationDTO u=new UserInformationDTO();
						u.setUserID(rs.getString("UserID"));
						u.setUserName(rs.getString("UserName"));
						u.setUserSex(rs.getString("UserSex"));
						u.setUserPsw(rs.getString("UserPsw"));
						u.setUIflag(rs.getInt("Uflag"));
						u.setUserAuth(rs.getInt("UserAuth"));
						v.add(u);
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
//按id好查找，检测是否存在
		public boolean FindAUserInfo1(String _TeacherID){
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;	
			Statement stat=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
					String sql="select * from TeacherInformation where TIflag=1 and TeacherID='"+_TeacherID+"'";
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
	
	//按ID查
		public Vector<UserInformationDTO> FindAUserInfoByID(String _UserID) {
			Vector<UserInformationDTO> v=new Vector<UserInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from UserInformation where Uflag=1 and UserID='"+_UserID+"'";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						UserInformationDTO u=new UserInformationDTO();
						u.setUserID(rs.getString("UserID"));
						u.setUserName(rs.getString("UserName"));
						u.setUserSex(rs.getString("UserSex"));
						u.setUserPsw(rs.getString("UserPsw"));
						u.setUserAuth(rs.getInt("UserAuth"));
						u.setUIflag(rs.getInt("Uflag"));
						v.add(u);
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
//改
		public boolean updateTeachInfo(UserInformationDTO udto) {
			boolean flag=false;
			String userid=udto.getUserID();
			String username=udto.getUserName();
			String usersex=udto.getUserSex();
			String userpsw=udto.getUserPsw();
			int userauth=udto.getUserAuth();
			int uflag=1;
			String sql="update UserInformation set UserID='"+userid+"',UserName='"+username+"',UserSex='"+usersex+"',UserPsw='"+userpsw+"',UserAuth='"+userauth+"',Uflag='"+uflag+"' where UserID='"+userid+"'";
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


		//用户添加·
		//信息添加
			public boolean addUserInfo(UserInformationDTO udto)
			{
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				String userid=udto.getUserID();
				String username=udto.getUserName();
				String usersex=udto.getUserSex();
				String userpsw=udto.getUserPsw();
				int userauth=udto.getUserAuth();
				int uflag=1;
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
									+ "values('"+userid+"','"+username+"','"+usersex+"','"+userpsw+"','"+userauth+"')";
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

}
