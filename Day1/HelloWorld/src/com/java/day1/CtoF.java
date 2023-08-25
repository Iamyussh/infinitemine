package com.java.day1;

public class CtoF {
	public void calc(double c){
		double F = c *9/5 +32;
		System.out.println("The temperature in Fahrenheit is " +F);
	}
	
	public static void main(String[] args){
		double c = 37;
		new CtoF().calc(c);
	}

}
