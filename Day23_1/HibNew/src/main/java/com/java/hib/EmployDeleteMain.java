package com.java.hib;

import java.util.Scanner;

public class EmployDeleteMain {
		public static void main(String[] args) {
			int empno;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Employ no");
			empno = sc.nextInt();
			EmployDAO dao = new EmployDAOImpl();
			System.out.println(dao.deleteEmployDao(empno));
		}
}
