package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.CustomerBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.config.xml"})
public class SessionFactoryTests {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		sessionFactory.getCurrentSession().beginTransaction();
		Session session = sessionFactory.getCurrentSession();
		CustomerBean select = session.get(CustomerBean.class, "Alex");
		System.out.println("select="+select);
		sessionFactory.getCurrentSession().getTransaction().commit();
//		sessionFactory.getCurrentSession().close();
		
	}

}
