package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

public class EjbImpl {
		
	public List<Patientmaster> showPatientsEjb() throws NamingException{
		PatientmasterBeanRemote remote = RemoteHelper.lookupRemoteStatelessPatient();
		return remote.showPatients();
	}
	
	public String addPatientReportEjb(PatientReport report) throws NamingException {
		PatientmasterBeanRemote remote  = RemoteHelper.lookupRemoteStatelessPatient();
		remote.addPatientReport(report);
		
		return "Added Report Successfully";
		
	}
}
