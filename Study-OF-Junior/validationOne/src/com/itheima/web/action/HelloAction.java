package com.itheima.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.User;
import userDao.userImpl.UserImpl;

/**
 * Struts2的入门案例
 * @author zhy
 *
 */
public class HelloAction extends ActionSupport implements ModelDriven<User>{//动作类
	
	/**
	 * 在动作类中的指定的动作方法
	 * 动作方法的书写要求：
	 * 		1、都是public的
	 * 		2、返回值必须是一个String
	 * 		3、必须没有参数
	 * @return
	 */
	
	private User user = new User();
	public String sayHello(){
	    UserImpl us = new UserImpl();
	    us.add(user);
	    return "success";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	  /*public void validate() {
	    if(StringUtils.isEmpty(user.getUsername())){
	    	addFieldError("username", "请输入用户名");
	   	
	    }
	   
	  }
	*/
	
	 // @SkipValidation
	  public String findAll(){
		  return"success";
	  }
     	
}
