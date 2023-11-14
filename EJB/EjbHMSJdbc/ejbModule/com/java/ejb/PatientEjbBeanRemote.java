package com.java.ejb;

import java.sql.SQLException;

import javax.ejb.Remote;

@Remote
public interface PatientEjbBeanRemote {
	String addPatient(Patient patient) throws ClassNotFoundException, SQLException;
}
