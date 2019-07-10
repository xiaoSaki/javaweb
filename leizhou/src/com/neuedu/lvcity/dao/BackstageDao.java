package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.model.Users;

public interface BackstageDao {

	//用户管理
	public List<Users> findUser();//查找用户
	public boolean deleteUser(int id);//删除用户
	public boolean addUser(Users user);//添加用户
	public Users findUserById(int id);
	public boolean updateUser(Users user);//更新用户
	public List<Users> findUser(String name);//模糊查询
	
	//美食管理
	public List<Food> findFood();
	public boolean deleteFood(int fid);
	public boolean addFood(Food food);
	public List<Food> findFood(int ftid,String fname);
	public List<Food> findFood(String fname);
	public List<Food> findUpdateFood(int fid);
	public boolean updateFood(Food food);
	
	//景点管理
	public List<Scenic> findScenic();
	public boolean deleteScenic(int sid);
	public boolean addScenic(Scenic scenic);
	public List<Scenic> findScenic(int stid,String sname);
	public List<Scenic> findScenic(String sname);
	public List<Scenic> findUpdateScenic(int sid);
	public boolean updateScenic(Scenic scenic);
	
}
