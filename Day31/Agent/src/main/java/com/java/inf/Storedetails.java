package com.java.inf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Storedetails {
	public static void main(String[] args) {
		SessionFactory factory= 
				new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		Agent a1 = new Agent();
		a1.se
		
	}

}
