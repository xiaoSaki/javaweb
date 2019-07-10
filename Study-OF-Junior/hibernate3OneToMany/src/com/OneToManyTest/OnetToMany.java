package com.OneToManyTest;

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
	    session.save(c);
	    Order o1 = new Order();
	    Order o2 = new Order();
	    o1.setName("”≤≈Ã");
	    o2.setName("± º«±æ");
	    o1.setCustomer(c);
	    o2.setCustomer(c);
	    c.getOrder().add(o1);
	    c.getOrder().add(o2); 
	    session.save(o1);
	    session.save(o2);
	     
	    session.beginTransaction().commit();
	    session.close(); 
	}
	
	/*
	 * 
	 */
	
}
