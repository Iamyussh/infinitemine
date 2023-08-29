package ccom.java.day4;

import java.util.Comparator;

public class cgpacomparator implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Student e1 = (Student)obj1;
		Student e2 = (Student)obj2;
		if(e2.getCgpa()>e1.getCgpa()){
			return 1;
		}
		return -1;
	}

}
