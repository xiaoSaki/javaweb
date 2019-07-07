package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import en.edu.lingnan.Dto.teacherInformationDTO;
import en.edu.lingnan.util.DataAccess;


public class teacherInformationDAO {
	// 查找教师信息表所有元组
	public Vector<teacherInformationDTO> findTeacherInformation() {
		Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from TeacherInformation";
			rs = stat.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				teacherInformationDTO s = new teacherInformationDTO();
				s.setTeacherID(rs.getString("TeacherID"));
				s.setTeacherName(rs.getString("TeacherName"));
				s.setTeacherSex(rs.getString("TeacherSex"));
				s.setTeacherTel(rs.getString("TeacherTel"));
				s.setTeacherAge(rs.getInt("TeacherAge"));
				s.setTIflag(rs.getInt("TIflag"));
				v.add(s);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集是出现错误");
				e.printStackTrace();
			}
		}
		return v;
	}
	public Vector<teacherInformationDTO> findTeacherInformationByID(String _teacherid) {
		Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from TeacherInformation where teacherid = '"+_teacherid+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				teacherInformationDTO s = new teacherInformationDTO();
				s.setTeacherID(rs.getString("TeacherID"));
				s.setTeacherName(rs.getString("TeacherName"));
				s.setTeacherSex(rs.getString("TeacherSex"));
				s.setTeacherTel(rs.getString("TeacherTel"));
				s.setTeacherAge(rs.getInt("TeacherAge"));
				s.setTIflag(rs.getInt("TIflag"));
				v.add(s);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集是出现错误");
				e.printStackTrace();
			}
		}
		return v;
	}

	// 增加教师信息表元组
	public boolean addTeacherInformation(teacherInformationDTO sdto) {
		boolean flag = false;
		String TeacherID = sdto.getTeacherID();
		String TeacherName = sdto.getTeacherName();
		String TeacherSex = sdto.getTeacherSex();
		String TeacherTel = sdto.getTeacherTel();
		int TeacherAge = sdto.getTeacherAge();
		int TIflag = sdto.getTIflag();
		String sql = "insert into TeacherInformation values" + "('" + TeacherID
				+ "','" + TeacherName + "','" + TeacherSex + "','" + TeacherTel
				+ "','" + TeacherAge + "','" + TIflag + "')";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// 创建SQL语句对象并执行
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集是出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 删除教师信息表元组
	public boolean deleteTeacherInformationByID(String TeacherID) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			//TeacherInformation为TeacherCourse的外键
			rs = stmt.executeQuery("select * from TeacherInformation where TeacherID='"+TeacherID+"' and  TIflag = 1");
			 if(rs.next())
			 {
				 rs1 = stmt.executeQuery("select * from TeacherCourse where TeacherID='" + TeacherID + "' and  TCflag = 1");
				 if(rs1.next())
				 {
					 String sql1 = "update TeacherCourse set TCflag= 0 where TeacherID='" + TeacherID + "'";
					 stmt.executeUpdate(sql1);
					 
				 }
			String sql2 = "update  TeacherInformation set  TIflag =0 where TeacherID = '" + TeacherID + "'";
			stmt.executeUpdate(sql2);
			flag = true;
		} 
			 else {
				 flag = false;
			}
		}catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
					rs1 = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集是出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	 //更新教师信息表元组
	 public boolean updateTeacherInformation(teacherInformationDTO sdto) {
	 boolean flag = false;
	 String TeacherID = sdto.getTeacherID();
	 String TeacherName = sdto.getTeacherName();
	 String TeacherSex = sdto.getTeacherSex();
	 String TeacherTel = sdto.getTeacherTel();
	 int TeacherAge = sdto.getTeacherAge();
	 int TIflag = sdto.getTIflag();
	 String sql =
	 "update TeacherInformation set TeacherName='"+TeacherName+"',TeacherSex='"+TeacherSex+"',TeacherTel='"+TeacherTel+"',TeacherAge='"+TeacherAge+"',TIflag='"+TIflag+"' where TeacherID='"+TeacherID+"'";
	 Connection conn = null;
	 Statement stat = null;
	 try {
	 conn = DataAccess.getConnection();
	 stat = conn.createStatement();//创建SQL语句对象并执行
	 stat.executeUpdate(sql);
	 flag = true;
	 } catch (SQLException e) {
	 System.out.println("运行SQL语句时出现错误");
	 e.printStackTrace();
	 } finally{
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
	 System.out.println("关闭连接、语句及结果集是出现错误");
	 e.printStackTrace();
	 }
	 }
	 return flag;
	 }

}
