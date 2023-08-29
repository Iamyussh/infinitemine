package ccom.java.day4;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	
	public static void main(String[] args){
		List names = new ArrayList();
		names.add("Arnab");
		names.add("Mukesh");
		names.add("Ganesh");
		names.add("Sireesha");
		names.add("Abhishek");
		System.out.println("Names are ");
		for(Object object : names){
			System.out.println(object);
		}
		
		//For adding the value
		names.add(2,"Anirudh");
		System.out.println("Names after adding ");
		for(Object object : names){
			System.out.println(object);
		}
		
		//for updating the value
		
		names.set(2,"Ayush");
		System.out.println("Names after updating ");
		for(Object object : names){
			System.out.println(object);
		}
		
	// removing the values
		
		names.remove(0);
		System.out.println("Remove by Index");
		for(Object object : names){
			System.out.println(object);
		}
		
		// remove by name
		names.remove("Sireesha");
		System.out.println("Remove by Object name");
		for(Object object : names){
			System.out.println(object);
		}
		
		
	}

}
