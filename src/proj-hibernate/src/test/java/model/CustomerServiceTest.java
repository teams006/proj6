package model;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.config.xml")
public class CustomerServiceTest {
	@Autowired private SessionFactory sessionFactory;
	@Autowired private CustomerService customerService;
	@Before public void before() {
		sessionFactory.getCurrentSession().beginTransaction();
	}
	@Test public void testLogin() {
		CustomerBean login = customerService.login("Alex", "A");
		System.out.println("login = "+login);
	}
	@Test public void testChangePassword() {
		boolean change = customerService.changePassword("Ellen", "E", "EEE");
		System.out.println("change = "+change);
	}
	@After public void after() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
}
