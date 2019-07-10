package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.model.Users;

public class BackstageDaoImpl implements BackstageDao {
	
	private Connection conn;//数据库连接
	public BackstageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 用户管理
	 */
	@Override
	public List<Users> findUser() {
		List<Users> list = new ArrayList<Users>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from users");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
				list.add(user);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户user的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("delete from users where id = ?");
			pstam.setInt(1, id);
			int i = pstam.executeUpdate();
			if(i>0){
				flag=true;
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除用户user的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addUser(Users user) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into users (name,passwd,age,sex,email,status) values(?,?,?,?,?,?) ");
			pstam.setString(1, user.getName());
			pstam.setString(2, user.getPasswd());
			pstam.setInt(3, user.getAge());
			pstam.setString(4, user.getSex());
			pstam.setString(5, user.getEmail());
			pstam.setInt(6, user.getStatus());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
//			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Users findUserById(int id) {
		Users user = new Users();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from users where id = ?");
			pstam.setInt(1, id);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){						
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户user的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return user;
	}

	@Override
	public boolean updateUser(Users user) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update users set name=?, passwd=?, age=?, sex=?, email=?, status=? where id=? ");
			pstam.setString(1, user.getName());
			pstam.setString(2, user.getPasswd());
			pstam.setInt(3, user.getAge());
			pstam.setString(4, user.getSex());
			pstam.setString(5, user.getEmail());
			pstam.setInt(6, user.getStatus());
			pstam.setInt(7, user.getId());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新用户user的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public List<Users> findUser(String name) {
		List<Users> list = new ArrayList<Users>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from users where name like ?");
			pstam.setString(1, "%"+name+"%");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
				list.add(user);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在根据name查询用户user的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	
	
	/**
	 * 美食管理
	 */
	@Override
	public List<Food> findFood() {
		List<Food> foods = new ArrayList<Food>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from food order by ftid");
			rs = pstam.executeQuery();			
			while(rs.next()){
				Food food = new Food();
				food.setFid(rs.getInt("fid"));
				food.setAid(rs.getInt("aid"));			
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				foods.add(food);
			}
		}catch (SQLException e) {
			System.out.println("在查询foods的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return foods;
	}

	@Override
	public boolean deleteFood(int fid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("delete from food where fid = ?");
			pstam.setInt(1, fid);
			int i = pstam.executeUpdate();
			if(i>0){
				flag=true;
			}			
		}catch (SQLException e) {
			System.out.println("在删除food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addFood(Food food) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into food (ftid,fname,image,aid) values(?,?,?,?) ");
			pstam.setInt(1, food.getFtid());
			pstam.setString(2, food.getFname());
			pstam.setString(3, food.getImage());
			pstam.setInt(4, food.getAid());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public List<Food> findFood(int ftid, String fname) {
		List<Food> list = new ArrayList<Food>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from food where ftid = ? and fname like ?");
			pstam.setInt(1, ftid);
			pstam.setString(2, "%"+fname+"%");
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Food food = new Food();
				food.setFid(rs.getInt("fid"));
				food.setAid(rs.getInt("aid"));			
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				list.add(food);	
			}
		}catch (SQLException e) {
			System.out.println("在根据ftid和name查询用户food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}
	
	@Override
	public List<Food> findFood(String fname) {
		List<Food> list = new ArrayList<Food>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from food where fname like ?");
			pstam.setString(1, "%"+fname+"%");
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Food food = new Food();
				food.setFid(rs.getInt("fid"));
				food.setAid(rs.getInt("aid"));			
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				list.add(food);	
			}
		}catch (SQLException e) {
			System.out.println("在根据fname查询用户food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}
	
	@Override
	public List<Food> findUpdateFood(int fid) {
		List<Food> list = new ArrayList<Food>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from food where fid = ?");
			pstam.setInt(1, fid);
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Food food = new Food();
				food.setFid(rs.getInt("fid"));
				food.setAid(rs.getInt("aid"));			
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				list.add(food);	
			}
		}catch (SQLException e) {
			System.out.println("在根据fid查询用food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public boolean updateFood(Food food) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update food set ftid=?, fname=?, image=?, aid=? where fid=? ");
			pstam.setInt(1, food.getFtid());
			pstam.setString(2, food.getFname());			
			pstam.setString(3, food.getImage());
			pstam.setInt(4, food.getAid());
			pstam.setInt(5, food.getFid());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新美食food的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	
	/**
	 * 景点管理
	 */
	@Override
	public List<Scenic> findScenic() {
		List<Scenic> list = new ArrayList<Scenic>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from scenic order by stid");
			rs = pstam.executeQuery();			
			while(rs.next()){
				Scenic scenic = new Scenic();
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));
				list.add(scenic);
			}
		}catch (SQLException e) {
			System.out.println("在查询scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public boolean deleteScenic(int sid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("delete from scenic where sid = ?");
			pstam.setInt(1, sid);
			int i = pstam.executeUpdate();
			if(i>0){
				flag=true;
			}			
		}catch (SQLException e) {
			System.out.println("在删除scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addScenic(Scenic scenic) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into scenic (stid,sname,image,aid,lx) values(?,?,?,?,?)");		
			pstam.setInt(1, scenic.getStid());
			pstam.setString(2, scenic.getSname());
			pstam.setString(3, scenic.getImage());
			pstam.setInt(4, scenic.getAid());
			pstam.setString(5, scenic.getLx());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public List<Scenic> findScenic(int stid, String sname) {
		List<Scenic> list = new ArrayList<Scenic>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from scenic where stid = ? and sname like ?");
			pstam.setInt(1, stid);
			pstam.setString(2, "%"+sname+"%");
			rs = pstam.executeQuery();			
			while(rs.next()){	
				Scenic scenic = new Scenic();
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));				
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));				
				list.add(scenic);	
			}
		}catch (SQLException e) {
			System.out.println("在根据stid和sname查询用户scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<Scenic> findScenic(String sname) {
		List<Scenic> list = new ArrayList<Scenic>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from scenic where sname like ?");
			pstam.setString(1, "%"+sname+"%");
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Scenic scenic = new Scenic();
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));				
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));				
				list.add(scenic);
			}
		}catch (SQLException e) {
			System.out.println("在根据sname查询用户scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<Scenic> findUpdateScenic(int sid) {
		List<Scenic> list = new ArrayList<Scenic>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select * from scenic where sid = ?");
			pstam.setInt(1, sid);
			rs = pstam.executeQuery();			
			while(rs.next()){				
				Scenic scenic = new Scenic();
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));				
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));				
				list.add(scenic);	
			}
		}catch (SQLException e) {
			System.out.println("在根据sid查询用scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public boolean updateScenic(Scenic scenic) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update scenic set stid=?, sname=?, image=?, aid=?, lx=? where sid=? ");			
			pstam.setInt(1, scenic.getStid());
			pstam.setString(2, scenic.getSname());			
			pstam.setString(3, scenic.getImage());
			pstam.setInt(4, scenic.getAid());
			pstam.setString(5, scenic.getLx());
			pstam.setInt(6, scenic.getSid());
			System.out.println("dao测试"+scenic.getSname());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新景点scenic的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}
	
}
