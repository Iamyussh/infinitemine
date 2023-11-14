package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
	
	public static void main(String[] args) {
		
		try {
			CalculationBeanRemote service = (CalculationBeanRemote)
					new InitialContext().lookup("CalculationBean/remote");
			System.out.println(service.sum(5,2));
			System.out.println(service.sub(5,2));
			System.out.println(service.mult(5, 2));
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
