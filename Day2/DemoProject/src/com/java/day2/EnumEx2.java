package com.java.day2;

public class EnumEx2 {
		public static void main(String[] args){
			String str = "DOTNET";
			Course course = Course.valueOf(str);
		     System.out.println(course);
		}
}
