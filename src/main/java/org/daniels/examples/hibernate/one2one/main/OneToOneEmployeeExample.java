package org.daniels.examples.hibernate.one2one.main;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneEmployeeExample {
	
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	
	public static void main(String[] args) {
		final Employee employee = new Employee();
		employee.setFirstName("Daniel");
		employee.setLastName("Sadowski");
		
		final Address address = new Address();
		address.setCity("Danzig");
		address.setStreet("OliwaStr");
		
		employee.setAddress(address);
		address.setEmployee(employee);
		
		try {
			final Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			session.save(employee);

			session.getTransaction().commit();
			System.out.println(employee);
		
		}
		finally {
			sessionFactory.close();
		}
	}
}
