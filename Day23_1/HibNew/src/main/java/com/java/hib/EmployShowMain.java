package com.java.hib;

import java.util.List;

public class EmployShowMain {public static void main(String[] args) {
	

	EmployDAO dao = new EmployDAOImpl();
	List<Employ> employList = dao.showEmployDAO();
	for(Employ employ:employList) {
		System.out.println(employ);
	}
	
	
}
}
