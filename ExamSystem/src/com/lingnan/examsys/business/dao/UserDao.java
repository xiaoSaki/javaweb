package com.lingnan.examsys.business.dao;

import java.sql.Timestamp;
import java.util.List;

import com.lingnan.examsys.business.domain.AnnouncementVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface UserDao extends BaseDao {
	/**
	 * 黄润志2018.08.10
	 * 根据用户账号和密码查找用户
	 * @param user
	 * @return
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user);
	/**
	 * 查找班级学生
	 * @param class_id
	 * @return
	 */
	public List<UserVO> findUserByClassId(int class_id);
	/**
	 * 查看该学生是否存在
	 * @param user_id
	 * @return
	 */
	public boolean findUserByid(int user_id);
	/**
	 * 搜索框搜索学生
	 * @param find_name
	 * @param class_id
	 * @return
	 */
	public List<UserVO> findUserByClassIdAndFindname(String find_name,int class_id);
	/**
	 * 更改密码
	 * @param user_pwd
	 * @return
	 */
	public boolean updateUserByPwd(String user_pwd);
	/**
	 * 公告查看
	 * @param user_name
	 * @return
	 */
	public List<AnnouncementVO> findAnnouncementByUser_name(String user_name);
	/**
	 * 添加公告信息
	 * @param text
	 * @param user_name
	 * @return
	 */
	public boolean insertAnnouncement(String text,String user_name);
	/**
	 * 删除公告
	 * @param announcement_id
	 * @return
	 */
	public boolean deleteAnnouncement(int announcement_id);
	/**
	 * 查询用户权限值
	 * @param user_id 用户名
	 * @return 权限值
	 */
	public int getSupervalue(int user_id);
	/**
	 * 用户登录
	 * @param user_id 用户编号
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(int user_id,String user_pwd);
	/**
	 * 根据用户编号获取用户信息
	 * @param user_id 用户编号
	 * @return 用户信息
	 */
	public UserVO getUserByUser_id(int user_id);
	/**
	 * 
	* <p>Title: luckUserById</p>
	* <p>Description: 根据用户id封锁用户</p>
	* @param user_id
	* @param blocked_time
	* @return
	 */
	public int lockUserById(int user_id,Timestamp blocked_time);
	
	/**
	 * 
	* <p>Title: getSupervalueByIdAndPass</p>
	* <p>Description: 根据用户id以及密码返回用户权限值</p>
	* @param user_id
	* @param password
	* @return
	 */
	public int getSupervalueByIdAndPass(int user_id, String password);
	/**
	 * 
	* <p>Title: getBlockedtimeById</p>
	* <p>Description: 根据用户id获取用户的解锁时间</p>
	* @param user_id
	* @return
	 */
	public Timestamp getBlockedtimeById(int user_id);
}
