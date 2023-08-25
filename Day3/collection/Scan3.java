package com.java.collection;

import java.util.Scanner;

public class Scan3 {
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			Employ employ = new Employ();
			System.out.println("Enter Employ no ");
			employ.setEmpno(sc.nextInt());
			System.out.println("Enter the Name ");
			employ.setName(sc.next());
			System.out.println("Enter Basic  ");
			employ.setBasic(sc.nextDouble());
			System.out.println(employ);
		}
}
