package com.java.jsf;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
	public List<Employ> showEmploy(){
		List<Employ> employList  = new ArrayList<Employ>();
		employList.add(new Employ(1,"Saurav","Java","Developer",98076));
		employList.add(new Employ(2,"Ansal","Python","Programmer",65937));
		return employList;
	}

}
