//package model.dao;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import model.ProductBean;
//import model.ProductDAO;
//import model.hibernate.HibernateUtil;
//
//public class ProductDAOHibernateTests {
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
//		ProductDAO productDao =
//				new ProductDAOHibernate(HibernateUtil.getSessionFactory());
//		List<ProductBean> selects = productDao.select();
//		System.out.println("selects="+selects);
//	}
//	@After
//	public void after() {
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();		
//	}
//}
