package ccom.java.day4;

import java.util.HashSet;
import java.util.Set;

public class Setdemo1 {
public static void main(String[] args){
	Set names = new HashSet();
		names.add("Asif");
		names.add("Piyush");
		names.add("Ariz");
		names.add("Sabyasachi");
		names.add("Sourav");
		
		
		names.add("Asif");
		names.add("Piyush");
		names.add("Ariz");
		names.add("Sabyasachi");
		names.add("Sourav");
		
		
		names.add("Asif");
		names.add("Piyush");
		names.add("Ariz");
		names.add("Sabyasachi");
		names.add("Sourav");
		
		
		for(Object obj : names){
			System.out.println(obj);
		}
}
}
