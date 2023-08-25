package com.java.day1;

public class CaseDemo1 {
		
	public void show(int choice ){
		switch(choice){
		case 1:
			System.out.println("Hi I am ayush...");
			break;
		case 2:
			System.out.println("Hi i am ganesh...");
			break;
		case 3:
			System.out.println("Hi I am Murari...");
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}
	
	public static void main(String[] args){
		int choice = 3;
		new CaseDemo1().show(choice);
	}
}
