package habernateOne;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.hibernate.Utils.HibernateUtilTest;

public class Dynamic_insertTest {
	@Test
	public void dynamic_insertTest() {
		
		 Session session = HibernateUtilTest.getopenSession();
	//-----------------------  insert into t_user values(1,'fsda','fdsa')
		 User user = new User();
		user.setPassword("123");
		//user.setUsername("ÔøÀí¹ú");
		session.save(user);
	   session.beginTransaction().commit();
}
}
