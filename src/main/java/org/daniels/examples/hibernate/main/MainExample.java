package org.daniels.examples.hibernate.main;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainExample {

	public static void main(String[] args) {
	
		
		//Get Session
		final SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		final Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save("whatever");
		//Commit transaction
		session.getTransaction().commit();
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
