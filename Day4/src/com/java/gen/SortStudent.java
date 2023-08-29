package com.java.gen;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortStudent {
	public static void main(String[] args) {
		
		Comparator<Student> c = new StudentnameComparator();
		Comparator<Student> gpa = new Cgpacomparator();
SortedSet<Student> studentlist = new TreeSet<Student>(gpa);
		
		studentlist.add(new  Student(1,"Ayush","Delhi",8.9));
		studentlist.add(new  Student(2,"Rahul","BBsr",8.6));
		studentlist.add(new  Student(3,"Tabbu","Khordha",8.2));
		studentlist.add(new  Student(4,"Ganesh","Hyd",8.5));
		studentlist.add(new  Student(5,"Ironman","New york",9.9));
		
		for ( Student student : studentlist) {
			System.out.println(student);
		}
		
	}

}
