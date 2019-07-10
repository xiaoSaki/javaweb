package habernateOne;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.hibernate.Utils.HibernateUtilTest;

public class Dynamic_updateTest {
	@Test
	public void dynamic_updateTest() {
		
		 Session session = HibernateUtilTest.getopenSession();
	//-----------------------  insert into t_user values(1,'fsda','fdsa')
		 /*
		  * 持久层，指定更新的用户编号
		  */
		 User user =  (User) session.get(User.class,3);
		 //user.setId(3);
		/* 瞬时态*/
		/* User user1 = new User();
		 user1.setId(2);*/
		 user.setPassword("1232222");
		//user.setUsername("曾理国");
		session.update(user);
	   session.beginTransaction().commit();
}
}