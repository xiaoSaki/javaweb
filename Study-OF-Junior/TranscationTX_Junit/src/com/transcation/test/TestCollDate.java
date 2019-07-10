package com.transcation.test;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accountIservice.Iserviceaccount;
import com.accountService.impl.AccountServieImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class TestCollDate {

    public void test(){
    	/*String path = "applicationContext.xml";
    	ApplicationContext context = new ClassPathXmlApplicationContext(path);
    	Iserviceaccount test= (Iserviceaccount) context.getBean("accountServicImpl");*/
        test.transfer("jack", "rose",1000);
}
}