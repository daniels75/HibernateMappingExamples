package org.daniels.examples.hibernate.main;

import java.util.Date;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.daniels.examples.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("David");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
