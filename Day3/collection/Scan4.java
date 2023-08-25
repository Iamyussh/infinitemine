package com.java.collection;

import java.util.Scanner;

public class Scan4 {
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
		
			System.out.println("enter leave status ");
			String str =sc.next();
			
			LeaveStatus st = LeaveStatus.valueOf(str);
			System.out.println(st);

			
		}
}
