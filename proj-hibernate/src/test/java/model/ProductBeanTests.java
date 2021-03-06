//package model;
//
//import org.hibernate.Session;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//

//
//public class ProductBeanTests {
//	@Before
//	public void before() {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//	}
//	@Test
//	public void testGet() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
////select
//		ProductBean select = session.get(ProductBean.class, 1);
//		System.out.println("select="+select);
//	}
//	@After
//	public void after() {
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();		
//	}
//}
