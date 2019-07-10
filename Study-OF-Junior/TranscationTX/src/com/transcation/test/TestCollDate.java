package com.transcation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accountIservice.Iserviceaccount;
import com.accountService.impl.AccountServieImpl;

public class TestCollDate {
    @Test
    public void test(){
    	String path = "applicationContext.xml";
    	ApplicationContext context = new ClassPathXmlApplicationContext(path);
    	Iserviceaccount test= (Iserviceaccount) context.getBean("accountServicImpl");
        test.transfer("jack", "rose",1000);
}
}