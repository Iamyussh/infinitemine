package com.java.hib;

import java.util.Scanner;

public class EmploySearchMain {
		public static void main(String[] args) {
			
		
	int empno;
	Scanner  sc = new Scanner(System.in);
	System.out.println("Enter Employ NO ");
	empno = sc.nextInt();
	EmployDAO dao = new EmployDAOImpl();
	Employ employ = dao.searchEmployDao(empno);
	if(employ!=null) {
		System.out.println(employ);
	}
}
}