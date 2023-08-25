package com.java.day1;

public class Factorial {
		public void calc(int n){
			int i =1;
			int f =1;
			while(i<=n){
				f = f*i;
				i++;
			}
			System.out.println("Factorial value is " +f);
		}
		
		public static void main(String [] args){
			int n =5;
			Factorial ovj = new Factorial();
			ovj.calc(n);
		}
}
