package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Users;

public interface LoginService {

	//add 2019/04/09
	public List<Users> loginByUser(String name,String passwd);
	public boolean RegisterUser(String name,String passwd);
}
