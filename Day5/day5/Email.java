package com.java.day5;

import java.util.Scanner;

public class Email {
	
	public void check(String mail) throws EmailException, UserException{
		if(!mail.contains("@")){
			throw new EmailException("Specify the address");
		}
		else if(mail.split("@").length<10){
			throw new UserException("Invalid user...");
		}
		else{
			System.out.println("Correct email");
		}
	
	}
public static void main(String[] args) {
	String mail;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the email address ");
	mail = sc.next();
	
	Email obj = new Email();
	try {
		obj.check(mail);
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
}
