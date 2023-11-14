package com.java.jsp;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	List<Employee>showEmployeeDAO() throws ClassNotFoundException,SQLException;

}
