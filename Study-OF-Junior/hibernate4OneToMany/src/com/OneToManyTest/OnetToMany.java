package com.OneToManyTest;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.Model.Customer;
import com.Model.Order;
import com.hibernate.Utils.HibernateUtilTest;

public class OnetToMany {
	@Test
	public void onetToMany(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = new Customer();
	    c.setName("kkkk");
	    Order o1 = new Order();
	    Order o2 = new Order();
	    //  下面四条语句都是维护关系
	    o1.setName("硬盘");
	    o2.setName("笔记本");
	   /* o1.setCustomer(c);
	    o2.setCustomer(c);*/
	    c.getOrder().add(o1);
	    c.getOrder().add(o2); 
	    session.save(c);
	   /* session.save(o1);
	    session.save(o2);*/
	     
	    session.beginTransaction().commit();
	    session.close(); 
	}
	
	/*
	 *  1、当Customer的inverse设置为false时，Customer维护关系，当删除用户信息时，自动设置订单的
	 *  cid值为空。
	 *  2、当Customer的inverse设置为true时，Customer放弃维护关系，当删除用户信息时，会报错
	 */
	@Test
	public void onetToMany1(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 * 手动删除
	 * 在删除用户信息时，先查找订单信息，如果有该用户的信息，应先删除订单信息，在删除用户信息
	 */
	@Test
	public void onetToMany2(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		Set<Order> order = c.getOrder();
		for(Order order2:order)
			order2.setCustomer(null);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 * 级联删除
	 * 1.Customer的inverse设置为true，cascade设置为delete
	 * 在删除用户信息时，级联删除订单的相应信息
	 */
	@Test
	public void onetToMany3(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 *  级联更新
	 */
	@Test
	public void onetToMany4(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 5);
		Set<Order> order = c.getOrder();
		for(Order order2:order)
			order2.setName("uuu");
		session.beginTransaction().commit();
		session.close(); 
	}
	
}
