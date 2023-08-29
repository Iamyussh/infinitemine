package ccom.java.day4;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortDemo {
	
	public static void main(String[] args){
		SortedSet names = new TreeSet();
		names.add("Sourav");
		names.add("Arnabh");
		names.add("Jitendra");
		names.add("Rajesh");
		names.add("Ganesh");
		names.add("Abhishek");
		names.add("Ayush");
		names.add("Anirudh");
		System.out.println("Names are ");
		for(Object obj : names){
			System.out.println(obj);
		}
		
		
	}

}
