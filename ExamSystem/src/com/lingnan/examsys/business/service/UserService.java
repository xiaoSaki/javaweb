package com.lingnan.examsys.business.service;

import java.sql.Timestamp;
import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;

public interface UserService {
	/**
	 * 根据用户名与密码获取用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(int username,String password);
	/**
	 * 黄润志2018.08.10
	 * 根据用户账号和密码查找用户
	 * @param user
	 * @return
	 */
		public List<UserVO> findUserByIdAndPassword(UserVO user);
		/**
		 * 查看该学号是否存在
		 * @param user_id
		 * @return
		 */
		public boolean findUserByUserid(int user_id);
		/**
		 * 修改密码
		 * @param user_pwd
		 * @return
		 */
		public boolean UpdatePwd(String user_pwd);
		public int lockUserById(int user_id,Timestamp blocked_time);
		public int getSupervalueByIdAndPass(int user_id,String password);
		public Timestamp getBlockedtimeById(int user_id);

}
