package com.java.collection;

import java.util.Scanner;

public class Scan2 {
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int a,b;
			System.out.println("enter two numbers ");
			a = sc.nextInt();
			b =sc.nextInt();
			int c = a + b;
			System.out.println("Sum is  " +c);
		}
}
