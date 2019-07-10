package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUTILS {

	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://127.0.0.1:3306/hello??useUnicode=true&characterEncoding=utf-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}
	
	
	public static void main(String[] args) {
		Connection con = DBUTILS.getConnection();
		String sql = "INSERT INTO hello(username,PASSWORD) VALUE('4','1234')";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			int i = pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
/*
public class DBUTILS {	
	private static String driver="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:3306/library";
	private static String user = "root";
	private static String  password = "123";
	public static Connection getConnection(){
	Connection conn = null;
	try {
		  Class.forName(driver);
	      conn= DriverManager.getConnection
	    		  (url, user, password);	
	} catch (ClassNotFoundException e) {
		System.out.println("MySQL鍔犺浇涓嶅埌绫�");
	}catch (SQLException e) {
		System.out.println("澶辫触");
	}
	return conn;
	}
	
*/