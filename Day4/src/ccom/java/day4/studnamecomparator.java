package ccom.java.day4;

import java.util.Comparator;

public class studnamecomparator implements Comparator {

	@Override
	public int compare(Object ob1, Object ob2) {
		// TODO Auto-generated method stubpublic int compare(Object ob1, Object ob2) {
		// TODO Auto-generated method stub
		Student e1 = (Student)ob1;
		Student e2 = (Student)ob2;
		return e1.getName().compareTo(e2.getName());
	}
		
	

}
