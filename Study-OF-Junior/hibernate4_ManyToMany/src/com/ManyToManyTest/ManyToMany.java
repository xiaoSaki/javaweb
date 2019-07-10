package com.ManyToManyTest;

import org.hibernate.Session;
import org.junit.Test;

import com.Model.Course;
import com.Model.Student;
import com.hibernate.Utils.HibernateUtilTest;

public class ManyToMany {
	@Test
	public void ManyToMany(){
		Session session = HibernateUtilTest.getopenSession();
		Course c = new Course();
		Student s = new Student();
		c.setName("数据结构");
		session.save(c);
		s.setName("小明");
		session.save(s);
		/*
		 * 由于两方都在维护cid，sid，所以有两个add的时候，会出现违反主键约束
		 */
		
		//s.getCourses().add(c);
		c.getStudents().add(s);
	    session.beginTransaction().commit();
	    session.close(); 
	}
	
	@Test
	public void ManyToMany2(){
		
	}
	
}
