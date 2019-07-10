package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.Student;
import userDao.userImpl.StudentImpl;
public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student st = new Student();
	public String sayHello(){
		StudentImpl sp = new StudentImpl();
	    sp.add(st);
	    return "success";
	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return st;
	}


}
