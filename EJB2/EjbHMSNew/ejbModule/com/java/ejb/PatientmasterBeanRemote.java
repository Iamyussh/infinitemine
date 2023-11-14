package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PatientmasterBeanRemote {
	List<Patientmaster> showPatients();
	String	addPatientReport(PatientReport report);

}
