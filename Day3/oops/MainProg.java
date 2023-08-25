package com.java.oops;

public class MainProg {
		public static void main(String[] args){
			Training[] arr = new Training[]{
					new Java("OOPs"),
					new Dotnet("Lambda"),
					new Angular("Services"),
					new Java("Collections"),
					new Java("Jsp"),
					new Dotnet("Entity Frameworks"),
					new Angular("Forms"),
					new Dotnet("Web api"),
					new Angular("Components"),
					new Java("Threads"),
					new Java("JDBC"),
					new Dotnet("Lambda"),
					new Angular("Services"),
					new Java("EJB")

			};
			
			for(Training i: arr){
				if(i.getClass().getSimpleName().equals("Java")){
					System.out.println(i);
				}
				
				for(Training training : arr){
					if(training instanceof Java){
						System.out.println(training );
					}
				}
			}
			
		
			
		}
}
