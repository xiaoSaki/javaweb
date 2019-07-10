package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lingnan.examsys.business.domain.AnnouncementVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;


public class UserDaoImpl implements UserDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;

	public UserDaoImpl(Connection conn) {
		this.conn=conn;
	}
	public UserVO login(int user_id, String user_pwd) {
		//用户模型
		UserVO vo = null;
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT user_name,supervalue,blocked_flag,blocked_time FROM user WHERE user_id = ? AND user_pwd= ?");
			prestmt.setInt(1,user_id);
			prestmt.setString(2,user_pwd);
			
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				vo = new UserVO();
				vo.setUser_id(user_id);
				vo.setUser_name(rs.getString("user_name"));
				//不获取用户密码
				//vo.setUser_pwd(user_pwd);
				vo.setBlocked_flag(rs.getInt("blocked_flag"));
				vo.setBlocked_time(rs.getTimestamp("blocked_time"));
				vo.setSupervalue(rs.getInt("supervalue"));
			}
			else {
				System.out.println(Ca+"查询结果集为空");
			}
		}catch(SQLException e) {
			throw new DaoException("用户登录查询异常", e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return vo;
	}
	
	@Override
	public int getSupervalue(int user_id) {
		//用户权限值，默认为0（查询不到该用户）
		int supervalue = 0;
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT supervalue FROM user WHERE user_id = ?");
			prestmt.setInt(1,user_id);
			
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				supervalue = rs.getInt("supervalue");
			}
			else {
				System.out.println(Ca+"查询结果集为空");
			}
		}catch(SQLException e) {
			throw new DaoException(Ca+"用户登录查询异常", e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return supervalue;
	}

	@Override
	public UserVO getUserByUser_id(int user_id) {
		//用户模型
		UserVO vo = null;
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT user_pwd,user_name,supervalue,blocked_flag,blocked_time FROM user WHERE user_id = ?");
			prestmt.setInt(1,user_id);
			
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				vo = new UserVO();
				vo.setUser_id(user_id);
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_pwd(rs.getString("user_pwd"));
				vo.setBlocked_flag(rs.getInt("blocked_flag"));
				vo.setBlocked_time(rs.getTimestamp("blocked_time"));
				vo.setSupervalue(rs.getInt("supervalue"));
			}
			else {
				System.out.println(Ca+"查询结果集为空");
			}
		}catch(SQLException e) {
			throw new DaoException("获取用户信息异常", e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return vo;
	}
	/**
	 * 黄润志2018.08.10
	 * 根据账号和密码查找用户
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			int userId = user.getUser_id();
			String userPassword = user.getUser_pwd();
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from user where user_id=? and user_pwd=?");
			//给？赋值
			prep.setInt(1,userId);
			prep.setString(2, userPassword);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				UserVO user1 = new UserVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				user1.setUser_id(rs.getInt("user_id"));
				user1.setUser_pwd(rs.getString("user_pwd"));
				user1.setUser_name(rs.getString("user_name"));
				user1.setSupervalue(rs.getInt("supervalue"));
				user1.setBlocked_flag(rs.getInt("blocked_flag"));;
				user1.setBlocked_time(rs.getDate("blocked_time"));
				list.add(user1); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询user信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	public List<UserVO> findUserByClassId(int class_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from user where user_id in (select user_id from stu_class where class_id=?)");
			//给？赋值
			prep.setInt(1,class_id);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				UserVO user1 = new UserVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				user1.setUser_id(rs.getInt("user_id"));
				user1.setUser_pwd(rs.getString("user_pwd"));
				user1.setUser_name(rs.getString("user_name"));
				user1.setSupervalue(rs.getInt("supervalue"));
				user1.setBlocked_flag(rs.getInt("blocked_flag"));;
				user1.setBlocked_time(rs.getDate("blocked_time"));
				list.add(user1); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询班级user信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 查看该学生是否存在
	 */
	public boolean findUserByid(int user_id){
		PreparedStatement prep = null;
		ResultSet rs = null;
		boolean flag = false;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from user where user_id=?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			if(rs.next()){
				flag=true;	
			}
		}catch(Exception e){
			System.out.println("删除学生时出错1： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	/**
	 * 搜索框搜索学生
	 */
	public List<UserVO> findUserByClassIdAndFindname(String find_name,int class_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from user where user_name=? and user_id in (select user_id from stu_class where class_id=?) ");
			//给？赋值
			prep.setString(1, '%'+find_name+'%');
			prep.setInt(2,class_id);
			
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				UserVO user1 = new UserVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				user1.setUser_id(rs.getInt("user_id"));
				user1.setUser_pwd(rs.getString("user_pwd"));
				user1.setUser_name(rs.getString("user_name"));
				user1.setSupervalue(rs.getInt("supervalue"));
				user1.setBlocked_flag(rs.getInt("blocked_flag"));;
				user1.setBlocked_time(rs.getDate("blocked_time"));
				list.add(user1); //将对象放入集合中
				System.out.println("find_name :"+user1);
			}
			
		}catch(Exception e){
			System.out.println("查询班级user信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	public boolean updateUserByPwd(String user_pwd){
		PreparedStatement prep = null;
		boolean flag = false;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("update user set user_pwd=?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setString(1, user_pwd);
			 prep.executeUpdate();
				flag=true;	
		
		}catch(Exception e){
			System.out.println("更新密码时出错1： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	public List<AnnouncementVO> findAnnouncementByUser_name(String user_name){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from announcement where user_name=? ");
			//给？赋值
			prep.setString(1, user_name);			
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				AnnouncementVO Announcement = new AnnouncementVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				Announcement.setAnnouncement_id(rs.getInt("announcement_id"));
				Announcement.setText(rs.getString("Text"));
				Announcement.setUser_name(rs.getString("user_name"));
				Announcement.setAnnouncement_time(rs.getDate("announcement_time"));
				list.add(Announcement); //将对象放入集合中
				System.out.println("find_name :"+Announcement);
			}
			
		}catch(Exception e){
			System.out.println("查公告信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 添加公告信息
	 */
	public boolean insertAnnouncement(String text,String user_name){
		PreparedStatement prep = null;
		boolean flag = false;
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time2 = sdf.format(time);
		try{
			System.out.println("添加公告:"+text+"  "+user_name+"  "+time);
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("insert into  announcement values(?,?,?,?)");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, 0);
			prep.setString(2, text);
			prep.setString(3, user_name);
			prep.setString(4, time2);
			prep.executeUpdate();
			flag=true;
		}catch(Exception e){
			System.out.println("添加学生时出错1： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	public boolean deleteAnnouncement(int announcement_id){
		PreparedStatement prep = null;
		boolean flag = false;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("delete from announcement where announcement_id=? ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, announcement_id);
			prep.executeUpdate();
			flag=true;
		}catch(Exception e){
			System.out.println("添加学生时出错1： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		UserDao dao = new UserDaoImpl(conn);		
		//获取用户权限值测试
		System.out.println("用户的权限值:"+dao.getSupervalue(100000));
	}

	@Override
	public int lockUserById(int user_id, Timestamp blocked_time) {
		PreparedStatement prep = null;
		int update = 0;
		try {
			prep = conn.prepareStatement("UPDATE `user` SET `blocked_time`=? WHERE user_id = ?");
			prep.setTimestamp(1, blocked_time);
			prep.setInt(2, user_id);
			update = prep.executeUpdate();
			if(update==0) {
				throw new Exception("更新条目为空");
			}
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeStatement2(prep);
		}
		return update;
	}

	@Override
	public int getSupervalueByIdAndPass(int user_id, String password) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		int supervalue = 0;
		try {
			prep = conn.prepareStatement("SELECT supervalue FROM user WHERE user_id = ? AND user_pwd = ?");
			prep.setInt(1, user_id);
			prep.setString(2, password);
			rs = prep.executeQuery();
			if(rs.next())
				supervalue = rs.getInt("supervalue");
			else
				throw new Exception("查询结果为空");
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeStatement(rs, prep);
		}
		return supervalue;
	}

	@Override
	public Timestamp getBlockedtimeById(int user_id) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		Timestamp time = null;
		try {
			prep = conn.prepareStatement("SELECT blocked_time FROM user WHERE user_id = ?");
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			if(rs.next())
				time = rs.getTimestamp("blocked_time");
			else
				throw new Exception("查询结果为空");
		}catch (Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeStatement(rs, prep);
		}
		return time;
	}
}
