package com.java.gen;

public class Demo {
	public static void main(String[] args) {
		int a =13,b=14;
		Data obj = new Data();
		obj.swap(a, b);
		
		String s1 = "Sourav",s2="Ayush";
		obj.swap(s1, s2);
		
		double a1=12.5,a2=5.4;
		obj.swap(a1,a2);
	}
}
