package com.java.day5;

import java.util.Scanner;

public class thrEx {
	
	public void show(int n){
		if(n<0){
			throw new ArithmeticException("Negative Nos Not allowed");
			
		}
		else if(n==0){
			throw new NumberFormatException("zero is invalid value...");
			
		}
		else{
			System.out.println("N value is " +n);
		}
	}
	
	
	
			public static void main(String[] args) {
					int n;
						Scanner sc =new Scanner(System.in);
							System.out.println("Enter a number ");
								n = sc.nextInt();
								
								thrEx obj = new thrEx();
								try{
									obj.show(n);
									
								}
								
								catch(ArithmeticException e){
									System.err.println(e.getMessage());
								}
								catch(NumberFormatException e){
									System.err.println(e.getMessage());
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
}
}
