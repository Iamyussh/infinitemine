package com.java.hib;

import java.util.List;

public class EmployShowCr {
		public static void main(String[] args) {
			
		
	EmployDAOImpl dao = new EmployDAOImpl();
	List<Employ> employList = dao.showEmployCr();
	for(Employ employ:employList) {
		System.out.println(employ);
	}
}
}