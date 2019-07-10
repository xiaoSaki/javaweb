package habernateOne;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;
public class Testone{
	@Test
	public void testOne(){
	Configuration con = new Configuration().configure();
	SessionFactory sessionFactory = con.buildSessionFactory();
	// JDBC Connection  
	// 由工厂生产连接对象session 这个session不是Servlet里面的
	 Session session = sessionFactory.openSession();
	 
	User user = (User) session.get(User.class, 2);
	session.beginTransaction().commit();
	session.close();
	sessionFactory.close();
	System.out.println(user);
	//user.setid();
	/*user.setPassword("1234");
	user.setUsername("林春蕊");
	session.save(user);*/
	}
	@Test
	public void testTwo(){
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		// JDBC Connection  
		// 由工厂生产连接对象session 这个session不是Servlet里面的
		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, 2);
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println(user);
		}
}
