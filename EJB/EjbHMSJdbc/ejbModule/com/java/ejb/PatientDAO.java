package com.java.ejb;

import java.sql.SQLException;

public interface PatientDAO {
	
	String addPatient(Patient patient) throws ClassNotFoundException, SQLException;

}
