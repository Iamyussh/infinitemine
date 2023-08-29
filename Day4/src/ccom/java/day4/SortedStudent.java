package ccom.java.day4;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedStudent {
	public static void main(String[] args) {
		
	
	Comparator c = new studnamecomparator();

	Comparator gpa = new cgpacomparator();
	SortedSet student = new TreeSet(gpa);

	
	student.add(new Student(1,"Ayush","Delhi",8.9));
	student.add(new Student(2,"Ganesh","Hyd",8.8));
	student.add(new Student(3,"Rahul","bbsr",8.6));
	student.add(new Student(4,"Satya","Cuttack",8.5));
	student.add(new Student(5,"Ironman","New york",10));
	student.add(new Student(6,"Hulk","California",9.0));
	
	System.out.println("Sorted Data ");
	
	for(Object obj : student){
		Student stud = (Student)obj;
		System.out.println(obj);
	}
	}
}
