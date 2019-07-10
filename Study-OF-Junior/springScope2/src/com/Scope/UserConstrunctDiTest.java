package com.Scope;

public class UserConstrunctDiTest {
	private User user;
	public UserConstrunctDiTest(User user) {
		super();
		this.user = user;
	}

	public void print()
	{
		user.print();
	}
      
}
