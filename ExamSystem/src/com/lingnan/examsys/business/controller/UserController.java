package com.lingnan.examsys.business.controller;

import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;
import com.lingnan.examsys.common.exception.ServiceException;

public class UserController {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//获取用户Service实例,用以业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
	
	public UserVO login(int username,String password) {
		//用户模型
		UserVO vo = null;
		try {
			vo = userMgrService.login(username, password);
		}catch (Exception e) {
			throw new ServiceException("用户登录异常", e);
		}
		return vo;	
	}
}
