package com.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Utils.HibernateUtilTest;

public class UtilTest{
	public void d(){
		//获取全新的session的连接
		Session session = HibernateUtilTest.getopenSession();
		Transaction tx = session.beginTransaction();
		//session.save(user);
		tx.commit();
		session.close();
	}

}
