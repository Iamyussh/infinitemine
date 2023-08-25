package com.java.day1;

public class ArrayDemo2 {
		 public void show(){
			 String[] names = new String[]{
					 "Ayush","Piyush","Ariz","Santosh","Sagar"
			 };
			 
			 for(String i : names){
				 System.out.println(i);
			 }
		 }
		 public static void main(String[] args){
			 new ArrayDemo2().show();
		 }
}

