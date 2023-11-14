package com.java.jsf;

import java.util.List;

public interface EmployDAO {
	
	List<Employ>showEmployDao();
	String searchEmploy(int empno);
	String validate(Login login);
 
}
