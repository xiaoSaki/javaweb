/*package en.edu.lingnan.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dto.ClassRoomDto;
public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto>();
		ClassRoomDao sd=new ClassRoomDao();
		v=sd.ClassRoomInfo();
        for(ClassRoomDto st :v){		  
	       System.out.print(st.getRoomid());
           System.out.print(st.getRoomname());
           System.out.print(st.getMaxnum());
           System.out.print(st.getRflag());
        }
	}
}*/

package en.edu.lingnan.test;
import java.sql.*;

import en.edu.lingnan.Dao.ClassRoomDao;

public class JDBCTest {
	public static void main(String [] args)
	  {
	   String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CourseScheduling";
	   String userName="sa";
	   String userPwd="123";
	 try
	 {
	     Class.forName(driverName);
	    System.out.println("加载驱动成功！");
	 }catch(Exception e){
	     e.printStackTrace();
	     System.out.println("加载驱动失败！");
	 }
	 try{
	     Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	         System.out.println("连接数据库成功！");
	 }catch(Exception e)
	 {
	     e.printStackTrace();
	     System.out.print("SQL Server连接失败！");
	 }        
	ClassRoomDao dao=new ClassRoomDao();
	dao.findClassRoomInfo();
	  
	  }
}