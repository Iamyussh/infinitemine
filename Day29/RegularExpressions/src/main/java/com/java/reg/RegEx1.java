package com.java.reg;
import java.util.regex.*;

public class RegEx1 {
	public static void main(String[]args) {
		System.out.println(Pattern.matches(".h","ch"));
		System.out.println(Pattern.matches("..f..i..","infinite"));
		System.out.println(Pattern.matches("[aeiou]", "a"));
		System.out.println(Pattern.matches("[aeiou]", "s"));
		
		//write a an expression that starts with  letters except aeiou
		
		System.out.println(Pattern.matches("[^aeiou]","a"));
		System.out.println(Pattern.matches("[^aeiou]","z"));
		System.out.println(Pattern.matches("[abcd]+","abccdd"));
		
		
		// X?  X occurs or not at all
//		X+ X occurs once or more times
//		
//		X* 
//		X(n)
//		X(n,)
//		X(Y,z)
		
		System.out.println(Pattern.matches("[a-zA-Z]+", "Prasanna"));
		System.out.println(Pattern.matches("[a-zA-Z]+", "Prasanna123"));
		
		System.out.println(Pattern.matches("[0-9]{10}","1234567890"));
		System.out.println(Pattern.matches("[0-9]{10}","123456789"));
		System.out.println(Pattern.matches("[0-9]{10}","ABCD1234"));
		System.out.println(Pattern.matches("[0-9]{4}","ABCD1234"));
		
		
		System.out.println(Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}","1234 1234 1234"));
		System.out.println(Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}","123412341234"));
		System.out.println(Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}","123 123 123"));
		
		System.out.println(Pattern.matches("[+][9][1]-[0-9]{10}","+91-8279780926"));
		
		System.out.println(Pattern.matches("\\d{5}","12345"));
		System.out.println(Pattern.matches("\\D+","12345"));
		System.out.println(Pattern.matches("\\D+","ABCD@#$$%"));
		
		// capital D for non-digits
		
		
		System.out.println(Pattern.matches("\\S+","HiHow"));
		System.out.println(Pattern.matches("\\S+","Hi How"));
		
		
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+"(?=\\S+$).{8,20}";
		
		System.out.println(Pattern.matches(regex,"Prasanna@1"));
		
		
		
		
		
		
		
	}

}
