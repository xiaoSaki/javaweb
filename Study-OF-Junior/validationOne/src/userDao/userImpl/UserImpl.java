package userDao.userImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import userDao.Iuser;
import utils.DBUTILS;

public class UserImpl implements Iuser {

	@Override
	public void add(User user) {
	
		Connection con = DBUTILS.getConnection();
		String sql = "INSERT INTO USER (username,PASSWORD,birthday,hobby,married)VALUE(?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setObject(3,user.getBirthday());
			pst.setString(4, user.getHobby());
			pst.setBoolean(5, user.isMarried());	
			int i = pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    public static void main(String[] args) {
		UserImpl userImpl = new UserImpl();
		User user =new User();
		user.setPassword("123");
		user.setUsername("Ð¡À¼");
		userImpl.add(user);
	}
}
