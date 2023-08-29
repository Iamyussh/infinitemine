package com.java.gen;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {
		public static void main(String[] args) {
			Comparator <Employ>c = new NameComparator();
			SortedSet<Employ> employList = new TreeSet<Employ>(c);
			
			employList.add(new Employ(1,"Arnab",88323));
			employList.add(new Employ(2,"Ganesh",90323));
			employList.add(new Employ(3,"Rajesh",90123));
			employList.add(new Employ(4,"Sireesha",902323));
			employList.add(new Employ(5,"Pallavi",87323));
			
			for (Employ employ : employList) {
				System.out.println(employ);
			}
		}
}
