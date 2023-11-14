package com.java.jsf;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
	
	public List<String> getNames(){
		List<String> names = new ArrayList<String>();
		names.add("Rahul");
		names.add("Amit");
		names.add("Ansal");
		names.add("Subudhi");
		names.add("Satya");
		
		return names;
	}
	
	public List<Employ> showEmploy(){
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1,"Gaurav","Java","Developer",84245.33));
		employList.add(new Employ(2,"Harshit","J2ee","Expert",84235));
		employList.add(new Employ(3,"Swathi","Mysql","Programmer",845.33));
		employList.add(new Employ(4,"Abhisek","Angular","Developer",84245.33));
		employList.add(new Employ(5,"Sireesha","React","Developer",84245.33));
		return employList;
		
	}

}
