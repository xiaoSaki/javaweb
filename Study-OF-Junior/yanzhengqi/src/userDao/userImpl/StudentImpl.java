package userDao.userImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;
import userDao.Istudent;
import utils.DBUTILS;

public class StudentImpl implements Istudent{

	@Override
	public void add(Student st) {
		Connection con = DBUTILS.getConnection();
		String sql = "INSERT INTO HELLO (Sname,Sage,Sscore,Semail,Ssex,Spassword,Srepassword,Surl)VALUE(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, st.getUsername());
			pst.setInt(2, st.getAge());
			pst.setInt(3, st.getScore());
			pst.setString(4, st.getEmail());
			pst.setString(5, st.getGender());
			pst.setString(6, st.getPassword());
			pst.setString(7, st.getRepassword());
			pst.setString(7, st.getUrl());
			int i = pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
