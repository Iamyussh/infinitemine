package com.java.gen;

import java.util.Comparator;

public class Cgpacomparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.getCgpa()<o2.getCgpa()){
			return 1;
		}
		else{
			return -1;
		}
	}
	

}
