package com.java.hib;

import java.util.Scanner;

public class SearchEmpoyCr {
	public static void main(String[] args) {
		
		
		int empno;
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter Employ NO ");
		empno = sc.nextInt();
		EmployDAOImpl dao = new EmployDAOImpl();
		Employ employ = dao.searchEmployCr(empno);
		if(employ!=null) {
			System.out.println(employ);
		}
		else {
			System.out.println("not found");
		}
	}
	}
