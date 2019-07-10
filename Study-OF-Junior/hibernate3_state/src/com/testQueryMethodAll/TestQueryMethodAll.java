package com.testQueryMethodAll;

import java.util.List;

import habernateOne.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;



public class TestQueryMethodAll {
	@Test
	public void testQueryMethodAll(){
		//加载全局的src
	Configuration con = new Configuration().configure();
	//创建一个session工厂
	SessionFactory sessionFactory = con.buildSessionFactory();
	//由工厂生产连接对象session
	 Session session = sessionFactory.openSession();
	 /*方法1*/
	 //查询整个对象的所有字段
	 /*Query query = session.createQuery("from User"); //参数传值
	 List<User> list = query.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //---------------------
	 /*方法2*/
	/* Criteria criteria =session.createCriteria(User.class);
	 List<User> list = criteria.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //---------------------
	 /*方法3*/
	/* SQLQuery SQLQuery = session.createSQLQuery("select * from t_user");
	 SQLQuery.addEntity(User.class);
	 List<User> list = SQLQuery.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //----------------------------------------
	 /*开启事物两种方法*/
	/* Transaction transaction = session.beginTransaction();
	 Transaction transaction2 = session.getTransaction();
	 transaction.commit();*/
	 
	 
	}
}
