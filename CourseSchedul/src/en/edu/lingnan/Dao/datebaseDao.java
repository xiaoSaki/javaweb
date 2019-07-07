package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import jdk.nashorn.internal.ir.Flags;
import en.edu.lingnan.Dto.datebaseDto;
import en.edu.lingnan.util.DataAccess;
public class datebaseDao {

	// 查找专业信息表
	public Vector<datebaseDto> FindMajorIfo() {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from MajorInformation"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				datebaseDto d = new datebaseDto();
				d.setMajorID(rs.getString("MajorID"));
				d.setMajorName(rs.getString("MajorName"));
				d.setMIflag(rs.getInt("MIflag"));
				v.add(d);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return v;
	}

	// 查找班级信息表
	public Vector<datebaseDto> FindClassIfo() {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from ClassInformation"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				datebaseDto d = new datebaseDto();
				d.setClassID(rs.getString("ClassID"));
				d.setClassName(rs.getString("ClassName"));
				d.setMajorID(rs.getString("MajorID"));
				d.setClassNumber(rs.getInt("ClassNumber"));
				d.setCIflag(rs.getInt("CIflag"));
				v.add(d);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return v;
	}

	// 从班级课程表中根据班级编号找出该班级信息
		public Vector<datebaseDto> SelectClassIfoByClassID(String ClassID) {
			Vector<datebaseDto> v = new Vector<datebaseDto>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stmt = conn.createStatement(); // 创建sql语句对象
				rs = stmt
						.executeQuery("select * from ClassInformation where ClassID = '"
								+ ClassID + "' "); // 执行sql语句，并将查询结果返回给ResultSet对象
				while (rs.next()) {
					datebaseDto d = new datebaseDto();
					d.setClassID(rs.getString("ClassID"));
					d.setClassName(rs.getString("ClassName"));
					d.setClassNumber(rs.getInt("ClassNumber"));
					d.setMajorID(rs.getString("MajorID"));
					d.setCIflag(rs.getInt("CIflag"));
					v.add(d);
				}
			} catch (SQLException e) {
				System.out.println("运行sql语句时出现错误");
				e.printStackTrace();
			} finally {
				DataAccess.CloseConnection(rs, stmt, conn);
			}
			return v;
		}

	
	
	// 更新班级信息表
	/*public boolean UpdateClassIfo(datebaseDto sdto) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String ClassID = sdto.getClassID();
		String ClassName = sdto.getClassName();
		int ClassNumber = sdto.getClassNumber();
		String MajorID = sdto.getMajorID();
		int CIflag = sdto.getCIflag();
		String sql = "update ClassInformation set ClassName = '" + ClassName
				+ "',MajorID = '" + MajorID + "',ClassNumber = '" + ClassNumber
				+ "',CIflag = '" + CIflag + "'where ClassID = '" + ClassID
				+ "' ";
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}*/

	// 更新专业信息表
	/*public boolean UpdateMajorIfo(datebaseDto sdto) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String MajorID = sdto.getMajorID();
		String MajorName = sdto.getMajorName();
		int MIflag = sdto.getMIflag();
		String sql = "update MajorInformation set MajorName = '" + MajorName
				+ "',MIflag = '" + MIflag + "'where MajorID = '" + MajorID
				+ "' ";
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}*/
	public boolean UpdateClassIfo(datebaseDto sdto) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String ClassID = sdto.getClassID();
		String ClassName = sdto.getClassName();
		int ClassNumber = sdto.getClassNumber();
		String MajorID = sdto.getMajorID();
		int CIflag = sdto.getCIflag();
		String MajorID1 = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			String sql = "select MajorID from MajorInformation";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MajorID1 = rs.getString("MajorID");
				if(MajorID.equalsIgnoreCase(MajorID1.trim())){
					System.out.print("aaaaaaa请重新更新数据啦啦啦"+MajorID1+"     "+MajorID);
					String sql1 = "update ClassInformation set ClassName = '"
							+ ClassName + "',MajorID = '" + MajorID
							+ "',ClassNumber = '" + ClassNumber + "',CIflag = '"
							+ CIflag + "'where ClassID = '" + ClassID + "' ";
					stmt.executeUpdate(sql1);
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}

	// 更新专业信息表
	public boolean UpdateMajorIfo(datebaseDto sdto) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String MajorID = sdto.getMajorID();
		String MajorName = sdto.getMajorName();
		int MIflag = sdto.getMIflag();
		String sql = "update MajorInformation set MajorName = '" + MajorName
				+ "',MIflag = '" + MIflag + "'where MajorID = '" + MajorID
				+ "' ";
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}



	// 软删除班级信息表(级联删除班级课程表)
	public boolean DeleteClassIfo(String ClassID) {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		boolean flag = false;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			rs = stmt.executeQuery("select * from ClassInformation where ClassID='"+ClassID+"' and  CIflag = 1");
			 if(rs.next())
			 {
				 rs1 = stmt.executeQuery("select * from StudentInformation where ClassID='" + ClassID+ "' and  SIflag = 1");
				 if(rs1.next())
				 {
					 String sql1 = "update StudentInformation set SIflag= 0 where StudentID='" + ClassID + "'";
					 stmt.executeUpdate(sql1);
					 
				 }
				 rs2 = stmt.executeQuery("select * from ClassSchedule where ClassID='" + ClassID+ "' and  CSflag = 1");
				 if(rs2.next())
				 {
					 String sql2 = "update ClassSchedule set CSflag= 0 where StudentID='" + ClassID + "'";
					 stmt.executeUpdate(sql2);
					 
				 }
				 rs3 = stmt.executeQuery("select * from TeacherCourse where ClassID='" + ClassID+ "' and  TCflag = 1");
				 if(rs3.next())
				 {
					 String sql3 = "update TeacherCourse set TCflag= 0 where StudentID='" + ClassID + "'";
					 stmt.executeUpdate(sql3);
					 
				 }
			String sql4 = "update ClassInformation set CIflag = 0 where ClassID = '"
					+ ClassID + "' ";
			stmt.executeUpdate(sql4);
			flag = true;
		}
		else
		{
			flag = false;

		} 
		}catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
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
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}

	// 软删除专业信息表
	public boolean DeleteMajorIfo(String MajorID) {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		boolean flag =false;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			rs = stmt.executeQuery("select * from MajorInformation where MajorID='"+MajorID+"' and  MIflag = 1");
			 if(rs.next())
			 {
				 rs1 = stmt.executeQuery("select * from ClassInformation  where MajorID='" + MajorID+ "' and  CIflag = 1");
				 if(rs1.next())
				 {
					 String sql1 = "update ClassInformation  set CIflag= 0 where MajorID='" + MajorID + "'";
					 stmt.executeUpdate(sql1);
					 
				 }
				 rs2 = stmt.executeQuery("select * from MajorSchedule where MajorID='" + MajorID+ "' and  MSflag = 1");
				 if(rs2.next())
				 {
					 String sql2 = "update MajorSchedule set MSflag= 0 where MajorID='" + MajorID + "'";
					 stmt.executeUpdate(sql2);
					 
				 }
			String sql3 = "update MajorInformation set MIflag = 0 where MajorID = '"
					+ MajorID + "' ";
			stmt.executeUpdate(sql3);
			flag =true;
			 }
			
			else {
				flag =false;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
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
			if(rs != null)
			{
				rs.close();
				rs = null;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
			DataAccess.CloseConnection(rs, stmt, conn);
		}

		return flag;
	}

	// 插入班级信息表
	public boolean InsertClassIfo(datebaseDto sdto) {
		boolean flag = false;
		String ClassID = sdto.getClassID();
		String ClassName = sdto.getClassName();
		String MajorID = sdto.getMajorID();
		int ClassNumber = sdto.getClassNumber();
		int CIflag = sdto.getCIflag();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Connection conn=null;	
		conn=DataAccess.getConnection();
		try{
		conn=DataAccess.getConnection();
		stmt = conn.createStatement();
		//查找是否存在roomid的数据
		 rs = stmt.executeQuery("select * from ClassInformation where ClassID='"+ClassID+"' and CIflag=1");
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
				String sql3 = "insert into ClassInformation values" + "('" + ClassID
						+ "','" + ClassName + "','" + MajorID + "','" + CIflag
						+ "','" + ClassNumber + "')";
				stmt.executeUpdate(sql3);
				flag=true;
			}
				else
				{
					flag = false;
				}
			
		}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			
			try {
				if(rs1 != null)
				{
					rs1.close();
					rs1 = null;
				}
				if(rs != null)
				{
					rs.close();
					rs = null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}

	// 插入专业信息表
	public boolean InsertMajorIfo(datebaseDto sdto) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String MajorID = sdto.getMajorID();
		String MajorName = sdto.getMajorName();
		int MIflag = sdto.getMIflag();
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into MajorInformation values" + "('" + MajorID
					+ "','" + MajorName + "','" + MIflag + "')";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return flag;
	}

	
	// 根据ClassID软删除班级基本信息
	public Vector<datebaseDto> DeleteClassIfoByClassID(String ClassID) {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = "update ClassInformation set CIflag = 0 where ClassID = '"
					+ ClassID + "'";
			stmt.executeUpdate(sql);
			String sql1 = "select * from ClassInformation where CIflag = 1";
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				datebaseDto r = new datebaseDto();
				r.setClassID(rs.getString("ClassID"));
				r.setClassName(rs.getString("ClassName"));
				r.setMajorID(rs.getString("MajorID"));
				r.setClassNumber(rs.getInt("ClassNumber"));
				r.setCIflag(rs.getInt("CIflag"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return v;
	}

	// 根据MajorID软删除专业基本信息
	public Vector<datebaseDto> DeleteMajorIfoByMajorID(String MajorID) {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = "update MajorInformation set MIflag = 0 where MajorID = '"
					+ MajorID + "'";
			stmt.executeUpdate(sql);
			String sql1 = "select * from MajorInformation where MIflag = 1";
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				datebaseDto r = new datebaseDto();
				r.setMajorID(rs.getString("MajorID"));
				r.setMajorName(rs.getString("MajorName"));
				r.setMIflag(rs.getInt("MIflag"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return v;
	}
	// 从专业课程表中根据专业编号找出该专业信息
	public Vector<datebaseDto> SelectMajorIfoByMajorID(String MajorID) {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt
					.executeQuery("select * from MajorInformation where MajorID = '"
							+ MajorID + "' "); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				datebaseDto d = new datebaseDto();
				d.setMajorID(rs.getString("MajorID"));
				d.setMajorName(rs.getString("MajorName"));
				d.setMIflag(rs.getInt("MIflag"));
				v.add(d);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess.CloseConnection(rs, stmt, conn);
		}
		return v;
	}
}
