package habernateOne;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestOne {
	 public static void main(String[] args) {
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		// JDBC Connection  
		// 由工厂生产连接对象session 这个session不是Servlet里面的
		 Session session = sessionFactory.openSession();
	//-----------------------  insert into t_user values(1,'fsda','fdsa')
		 User user = new User();
		user.setPassword("123");
		user.setUsername("曾理国");
		session.save(user);
	   session.beginTransaction().commit();
	// (设置了事务自动提交之后，还要flush一下)
		/*session.flush();
		session.close();*/
	//   User user3= (User)session.load(user.getClass(), 2);

		//  User user2= (User)session.load(user.getClass(), 2);
		//    System.out.println(user2.toString());
//	   session.beginTransaction().commit();
	   
	// Query createQuery = session.createQuery("from User");
	//       List<User> list = createQuery.list();
	 //      for (User user2 : list) {
	//		System.out.println(user2);
	//	}*/
	    
	   session.close();
	   
	  
		
	
	}

}
