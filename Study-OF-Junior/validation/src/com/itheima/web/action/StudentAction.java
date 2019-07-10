package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.Student;
import userDao.userImpl.StudentImpl;
/*
 * StudentAction继承ActionSupport类，实现ModelDriven
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student st = new Student();
	/*
	 * 类的yyHello()方法，实现添加学生的功能
	 * 
	 */
	public String yyHello(){
		StudentImpl sp = new StudentImpl();
	    sp.add(st);
	    return "success";
	}
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 * 重新getModel的方法，返回学生对象
	 */
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return st;
	}

}
