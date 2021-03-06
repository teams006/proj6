//package model.dao;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import model.CustomerBean;
//import model.CustomerDAO;
//import model.hibernate.HibernateUtil;
//
//public class CustomerDAOHibernateTests {
//	@Before
//	public void before() {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//	}
//	@Test
//	public void testContext() {
//		
//	}
//	@Test
//	public void testSelect() {
//		CustomerDAO customerDao =
//				new CustomerDAOHibernate(HibernateUtil.getSessionFactory());
//		CustomerBean bean = customerDao.select("Alex");
//		System.out.println(bean);
//	}
//	@Test
//	public void testUpdate() {
//		CustomerDAO customerDao =
//				new CustomerDAOHibernate(HibernateUtil.getSessionFactory());
//		boolean update = customerDao.update("E".getBytes(),
//				"ellen@lab.com", new java.util.Date(0), "Ellen");
//		System.out.println("update="+update);
//	}
//	@After
//	public void after() {
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();		
//	}
//}
