package ccom.java.day4;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class UserAuth {
			public static void main(String[] args) {
				Map userData  = new Hashtable();
				
				userData.put("Abhishek", "Kumar");
				userData.put("Jitendra", "Sahoo");
				userData.put("Piyush", "Raj");
				userData.put("Rahul", "Raman");
				userData.put("Tanya ", "Arora");
			
				
				
				String user,pwd;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter username ");
				user = sc.next();
				System.out.println("Enter password");
				pwd = sc.next();
				String data = (String)userData.getOrDefault(user,"Not found");
				//takes the input  as password
				
				
				if(pwd.equals(data)){
					System.out.println("Login Successful");
				}
				else{
					System.out.println("Invalid username or password");
				}
			}
}
