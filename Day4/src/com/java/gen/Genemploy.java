package com.java.gen;

import java.util.ArrayList;
import java.util.List;

public class Genemploy {
		
	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		
		employList.add(new Employ(1,"arnab",88323));
		employList.add(new Employ(2,"Ganesh",90323));
		employList.add(new Employ(3,"Rajesh",90123));
		employList.add(new Employ(4,"Sireesha",902323));
		employList.add(new Employ(5,"Pallavi",87323));
		
		for (Employ employ : employList) {
			System.out.println(employ);
		}
		
	
	
	}
}
