package en.edu.lingnan.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
public class DataAccess {
	private static String driver=null;
	private static String url = null;
	private static String user =  null;
	private static String  password = null;
	//private static String  conn = null;
	private static String xmlpath = "database.conf.xml";
	private static String xsdpath = "database.conf.xsd";
	private static HashMap<String,String> hm = new HashMap<String,String>(); 
	static{
		if(XmlValidator.validator(xmlpath, xsdpath)){
			hm = XmlParser.parser(xmlpath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		}
	}
	public static Connection getConnection(){
	Connection conn = null;
	
	try {
		  Class.forName(driver);
	      conn= DriverManager.getConnection
	    		  (url, user, password);	
	} catch (ClassNotFoundException e) {
		System.out.println("MySQL驱动程序找不到，看看是否加在相应的jar包");
	}catch (SQLException e) {
		System.out.println("获取数据连接是出现SQL语句错误");
	}
	return conn;
	}

	public static void closeconn(Connection conn,Statement stmt,PreparedStatement prep,ResultSet rs)
	{
		try{
			if(rs != null)
			{
				rs.close();
				rs = null;
			}
			if(stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			if(prep != null)
			{
				prep .close();
				prep  = null;
			}
			
			if(conn != null)
			{
				conn.close();
				conn = null;
			}
		}
	catch(SQLException e)
		{
		System.out.println("关闭连接时出现错误");
		e.printStackTrace();
		}	
	}
	
	public static void CloseConnection(ResultSet rs, Statement stmt,
			Connection conn) {
		try {
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
			System.out.println("关闭连接语句及结果集时出现错误");
			e.printStackTrace();
		}
	}


}