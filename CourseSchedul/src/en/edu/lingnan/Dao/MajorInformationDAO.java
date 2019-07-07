package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.MajorInformationDTO;
import en.edu.lingnan.util.DataAccess;

public class MajorInformationDAO {
	//查全部
		public Vector<MajorInformationDTO> findAllMajorInfo() {
			Vector<MajorInformationDTO> v=new Vector<MajorInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//创建SQL语句对象并执行
					String sql="select * from MajorInformation where MIflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //处理结果集
						 MajorInformationDTO m=new  MajorInformationDTO();
						 m.setMajorID(rs.getString("MajorID"));
						 m.setMajorName(rs.getString("MajorName"));
						 m.setMIflag(rs.getInt("MIflag"));
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
		public boolean FindMajorInfoByID(String _MajorID){
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;	
			Statement stat=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//创建SQL语句对象并执行
					String sql="select * from MajorInformation where MIflag=1 and MajorID='"+_MajorID+"'";
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
		
		

}
