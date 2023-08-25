package com.java.day2;

public class BoxingDemo {
	private static double b1;

	public static void main(String[] args){
		int a =12;
		String str = "Infinite";
		double b =12.5;
		
		
//		Boxing Implementation
		
		Object ob1 = a;
		Object ob2 = str;
		Object ob3 = b;
		
		int a1 = (Integer) ob1;
		String s1 = (String)ob2;
		double b1 = (Double)ob3;
		
		System.out.println(a1);
		System.out.println(s1);
		System.out.println(b1);
		
	}

}
