package com.java.gen;

import java.util.Comparator;

public class StudentnameComparator implements Comparator<Student> {

	@Override
	public int compare(Student ob1, Student ob2) {
		// TODO Auto-generated method stub
		return ob1.getName().compareTo(ob2.getName());		
	}

}
