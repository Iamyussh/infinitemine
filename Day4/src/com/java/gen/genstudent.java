package com.java.gen;

import java.util.ArrayList;
import java.util.List;

public class genstudent {
	public static void main(String[] args) {
		List<Student> studentlist = new ArrayList<Student>();
		
		studentlist.add(new  Student(1,"Ayush","Delhi",8.9));
		studentlist.add(new  Student(1,"Rahul","BBsr",8.6));
		studentlist.add(new  Student(1,"Tabbu","Khordha",8.2));
		studentlist.add(new  Student(1,"Ganesh","Hyd",8.5));
		studentlist.add(new  Student(1,"Ironman","New york",9.9));
		
		for (Student student : studentlist) {
			System.out.println(student);
		}
	}

}
