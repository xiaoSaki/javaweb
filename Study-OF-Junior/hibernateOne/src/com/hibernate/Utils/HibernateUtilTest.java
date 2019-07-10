package com.hibernate.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtilTest {
	private static SessionFactory f;
	/*static 静态块：只执行一次
	执行的时间：
	1、类加载
	2、静态方法运行时*/
	static{
		//加载配置文件获得核心配置对象
		Configuration con = new Configuration().configure();
		//获得工厂 SessionFactory，相当于连接池
		f = con.buildSessionFactory();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
			public void run(){
				System.out.println("jvm虚拟机加载关闭");
				f.close();
			}
		}));	
	}
	/*获取全新连接*/
	public static Session getopenSession(){
		//获得会话session，相当于链接Connection
		Session session = f.openSession();
		return session;
	}
	
   /*获取当前连接*/
	public static Session getCurrentSession(){
		Session session = f.getCurrentSession();
		return session;
	}
	public static void main(String[] args) {
		System.out.println(HibernateUtilTest.getCurrentSession());
	}
}
