package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;



public class SpringAopTest {
   @Test
   public void test(){
	 //加载xml
	 String path = "com/test/bean.xml";
	//得到容器
	 ApplicationContext context = new ClassPathXmlApplicationContext(path);
	//获得代理类
	UserService userService = (UserService) context.getBean("UserServiceId");
	userService.print();

   }
}
