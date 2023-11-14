package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO{
	
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Doctor> ShowDoctorsDao() throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * From doctor_master";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<Doctor> Doctorlist = new ArrayList<Doctor>();
			Doctor Doctor = null;
			while(rs.next()) {
				Doctor = new Doctor();
				Doctor.setDrId(rs.getString("Dr_id"));
				Doctor.setDrName(rs.getString("Dr_name"));
				Doctor.setDept(rs.getString("Dept"));				
				Doctorlist.add(Doctor);
			}
		return Doctorlist;
	}

	
	
	
		
	}
	
		

