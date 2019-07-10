package com.Scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C_di_Test {
	@Test
	public void test(){
	    String path = "com/Scope/application.xml";
	     //µÃµ½ÈÝÆ÷
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserConstrunctDiTest cuser = context.getBean("user",UserConstrunctDiTest.class);
        cuser.print();
	}
}
