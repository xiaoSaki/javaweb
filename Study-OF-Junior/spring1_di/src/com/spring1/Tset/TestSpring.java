package com.spring1.Tset;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring1.impl.serivceImpl;
import com.spring1.impl.userImpl;
import com.spring1Test.Iuser;
public class TestSpring {

	@Test
	public void test1(){
		
      Iuser user = new userImpl();
     user.print();
	}
	@Test
	public void test2(){
		//加载xml
		String path = "com/spring1Test/application.xml";
		//得到容器
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		userImpl userImpl = (userImpl) context.getBean("userIMPl");
		userImpl.print();
	}
	
	@Test
	public void test3(){
		//加载xml
		String path = "com/spring1Test/application.xml";
		//得到容器
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		serivceImpl serviceImpl =  (serivceImpl) context.getBean("serivceImpl");
		serviceImpl.print();
	}
	
	
	
	
}
