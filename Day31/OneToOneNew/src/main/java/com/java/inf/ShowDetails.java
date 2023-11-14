package com.java.inf;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ShowDetails {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Employee e");
		List<Employee> list = query.list();
		for(Employee employee:list) {
			System.out.println(employee.getEmployeeId()+" " +employee.getName()
			+" " +employee.getEmail());
			
			Address address = employee.getAddress();
			System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+
			address.getState()+" "+address.getCountry()+" "+address.getPincode());
		}
	}

}
