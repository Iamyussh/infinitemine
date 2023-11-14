package com.java.ejb;

import java.sql.SQLException;

import javax.naming.NamingException;

public class PatientEjbImpl {
	public String addPatientEjb(Patient patientNew) throws NamingException, ClassNotFoundException, SQLException {
		PatientEjbBeanRemote remote = 
				pRemoteHelper.lookupRemoteStatelessPatient();
		
		remote.addPatient(patientNew);
		return "patient added";
		
	}

}
