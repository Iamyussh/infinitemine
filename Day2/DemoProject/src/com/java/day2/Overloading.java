package com.java.day2;

public class Overloading {
		public void show(int x){
	System.out.println("Show Method w.r.t. Integer " +x);
		}
		public void show(double x){
			System.out.println("Show Method w.r.t Double " +x);
		
		}
		public void show(String x){
			System.out.println("Show Method w.r.t String " +x);
		
		}
		
		public static void main(String[] args){
					Overloading obj = new Overloading();
					obj.show(12);
					obj.show(12.5);
					obj.show("Infinite");
		}
		}
