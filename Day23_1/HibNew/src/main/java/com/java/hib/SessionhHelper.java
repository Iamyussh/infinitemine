package com.java.hib;


	import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


	public class SessionhHelper {
		
		public static SessionFactory getConnection() {
			return new AnnotationConfiguration().configure().buildSessionFactory();
			
		}

	}

