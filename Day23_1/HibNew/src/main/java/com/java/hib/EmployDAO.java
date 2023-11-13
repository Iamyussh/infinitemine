package com.java.hib;

import java.util.List;

public interface EmployDAO {
	List<Employ> showEmployDAO();
	Employ searchEmployDao(int empno);
	String addEmployDao(Employ employ);
	String deleteEmployDao(int empno);
	

}
