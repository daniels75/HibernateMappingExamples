package org.daniels.examples.hibernate.one2one.main;

import java.util.Date;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneStockExample {
	
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	
	public static void main(String[] args) {

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Stock stock = new Stock();

		stock.setStockCode("StockCode1");
		stock.setStockName("StockName1");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		
		session.getTransaction().commit();
		
		sessionFactory.close();
	}
}
