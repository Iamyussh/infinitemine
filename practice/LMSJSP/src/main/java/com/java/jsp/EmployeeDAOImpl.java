package com.java.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
			Connection connection;
			PreparedStatement pst;
	@Override
	public List<Employee> showEmployeeDAO() throws ClassNotFoundException, SQLException {
		connection  = ConnectionHelper.getConnection();
		String cmd = "select * from employee";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		List<Employee> employList = new ArrayList<Employee>();
		while(rs.next()) {
			employee = new Employee();
			employee.setEmpId(rs.getInt("empId"));
			employee.setEmpName(rs.getString("EmpName"));
			employee.setEmpMail(rs.getString("EmpEmail"));
			employee.setMobileNo(rs.getString("MobileNo"));
			employee.setDateofJoin(rs.getDate("DateOfJoin"));
			employee.setManagerId(rs.getInt("ManagerId"));
			employee.setLeaveAvail(rs.getInt("LeaveAvail"));
			employList.add(employee);
			
		}
		
		return employList;
	}

}
