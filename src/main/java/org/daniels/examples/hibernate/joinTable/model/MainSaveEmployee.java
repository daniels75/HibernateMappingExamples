package org.daniels.examples.hibernate.joinTable.model;

import java.util.HashSet;
import java.util.Set;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainSaveEmployee {
	
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	
	public static void main(String[] args) {
		EmployeeRev emplyeeRev = new EmployeeRev();
		emplyeeRev.setName("dan1");
		emplyeeRev.setId2(4);
		emplyeeRev.setRev(3);
		
		AddressRev addressRev = new AddressRev();
		addressRev.setId2(3);
		addressRev.setRev(4);
		
		Set<AddressRev> addresses = new HashSet<AddressRev>();
		addresses.add(addressRev);
		
		emplyeeRev.setAdddressRev(addresses);

		
		saveAndPrint(emplyeeRev);
	}

	private static void saveAndPrint(final Object entityToSave) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			session.save(entityToSave);

			session.getTransaction().commit();
			System.out.println(entityToSave);
		
		}
		finally {
			sessionFactory.close();
		}
	}
}
