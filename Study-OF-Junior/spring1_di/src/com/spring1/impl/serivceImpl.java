package com.spring1.impl;

import com.spring1Test.Iservice;
import com.spring1Test.Iuser;

public class serivceImpl implements Iservice {
     
	private Iuser user;
	@Override
	public void print() {
		user.print();	
	}
	public Iuser getUser() {
		return user;
	}
	public void setUser(Iuser user) {
		this.user = user;
	}
	

}
