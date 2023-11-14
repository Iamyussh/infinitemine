package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAOImpl implements PatientDAO{
	
	  Connection connection;
	    PreparedStatement pst;

	@Override
	public String addPatient(Patient patient) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO patient_master(pid,name,age,weight,gender,address,phoneno,disease,doctor_id)" +"VALUES (?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		
		
		pst.setString(1, patient.getPid());
		pst.setString(2, patient.getName());
		pst.setInt(3, patient.getAge());
		pst.setInt(4, patient.getWeight());
		pst.setString(5,patient.getGender());
		pst.setString(6, patient.getAddress());
		pst.setString(7,patient.getPhoneno());
		pst.setString(8,patient.getDisease());
		pst.setString(9, patient.getDoctorId());
		
		
		pst.executeUpdate();
		return "Data Inserted To the Table";
		
	}

	

}
