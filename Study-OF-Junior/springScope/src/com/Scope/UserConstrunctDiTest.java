package com.Scope;

public class UserConstrunctDiTest {
       private Integer age;
       private String username;
       private String sex;
       private User user;
       @Override
	public String toString() {
		return "UserConstrunctDiTest [age=" + age + ", username=" + username
				+ ", sex=" + sex + ", user=" + user + "]";
	}
	
	public UserConstrunctDiTest(Integer age, String username, String sex,
			User user) {
		super();
		this.age = age;
		this.username = username;
		this.sex = sex;
		this.user = user;
	}

	public UserConstrunctDiTest(Integer age, String sex) {
		super();
		this.age = age;
		this.sex = sex;
	}
	
	public UserConstrunctDiTest(String username, String sex) {
		super();
		this.username = username;
		this.sex = sex;
	}

	public UserConstrunctDiTest(Integer age, String username, String sex) {
		super();
		this.age = age;
		this.username = username;
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
       
}
