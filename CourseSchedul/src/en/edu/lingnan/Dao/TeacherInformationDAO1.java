package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.teacherInformationDTO;
import en.edu.lingnan.util.DataAccess;


public class TeacherInformationDAO1 {
	//查全部
		public Vector<teacherInformationDTO> findAllTeachInfo() {
			Vector<teacherInformationDTO> v=new Vector<teacherInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from TeacherInformation where TIflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						teacherInformationDTO t=new teacherInformationDTO();
						t.setTeacherID(rs.getString("TeacherID"));
						t.setTeacherName(rs.getString("TeacherName"));
						t.setTeacherSex(rs.getString("TeacherSex"));
						t.setTeacherTel(rs.getString("TeacherTel"));
						t.setTIflag(rs.getInt("TIflag"));
						t.setTeacherAge(rs.getInt("TeacherAge"));
						v.add(t);
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
	public Vector<teacherInformationDTO> findATeaInfoByID(String _TeacherID) {
		Vector<teacherInformationDTO> v=new Vector<teacherInformationDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;		
		try {
				conn=DataAccess.getConnection();
				stat=conn.createStatement();//创建SQL语句对象并执行
				String sql="select * from TeacherInformation where TIflag=1 and TeacherID='"+_TeacherID+"'";
				rs=stat.executeQuery(sql);
				while(rs.next()){ //处理结果集
					teacherInformationDTO t=new teacherInformationDTO();
					t.setTeacherID(rs.getString("TeacherID"));
					t.setTeacherName(rs.getString("TeacherName"));
					t.setTeacherSex(rs.getString("TeacherSex"));
					t.setTeacherTel(rs.getString("TeacherTel"));
					t.setTIflag(rs.getInt("TIflag"));
					t.setTeacherAge(rs.getInt("TeacherAge"));
					v.add(t);
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
		public boolean FindATeachInfoByID(String _TeacherID){
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
//改
		public boolean updateTeachInfo(teacherInformationDTO tdto) {
			boolean flag1=false;	
			String tid=tdto.getTeacherID();
			String tname=tdto.getTeacherName();
			String tsex=tdto.getTeacherSex();
			String ttel=tdto.getTeacherTel();
			int tage=tdto.getTeacherAge();
			int tflag=1;
			String sql="update TeacherInformation set TeacherName='"+tname+"',TeacherSex='"+tsex+"',TeacherTel='"+ttel+"',TeacherAge='"+tage+"',TIflag='"+tflag+"' where TeacherID='"+tid+"'";
			Connection conn=null;
			Statement stat=null;	
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					stat.executeUpdate(sql);
					flag1=true;
					
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
			return flag1;
		}


		
		
}