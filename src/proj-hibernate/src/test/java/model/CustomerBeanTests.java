//package model;
//
//import org.hibernate.Session;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import model.hibernate.HibernateUtil;
//
//public class CustomerBeanTests {
//	@Before
//	public void before() {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//	}
//	@Test
//	public void testSave() {
//		CustomerBean bean = new CustomerBean();
//		bean.setCustid("xxx");
//		bean.setPassword("xxx".getBytes());
//		bean.setEmail("xxx@xxx.com.tw");
//		bean.setBirth(new java.util.Date());
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.save(bean);
//	}
//	@After
//	public void after() {
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//	}
//}
