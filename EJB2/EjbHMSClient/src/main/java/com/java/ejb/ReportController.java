package com.java.ejb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class ReportController {
	
	private PatientReport patientReport;
	private EjbImpl ejbImpl ;
	
	
	
	
	
	public PatientReport getPatientReport() {
		return patientReport;
	}


	public void setPatientReport(PatientReport patientReport) {
		this.patientReport = patientReport;
	}


	public EjbImpl getEjbImpl() {
		return ejbImpl;
	}


	public void setEjbImpl(EjbImpl ejbImpl) {
		this.ejbImpl = ejbImpl;
	}


	public String addReport(PatientReport patientreportnew) throws NamingException {
		
		if(addreportvalidate(patientreportnew)) {
		return ejbImpl.addPatientReportEjb(patientreportnew);
	}
		return "";
	}
	
	
	public boolean addreportvalidate(PatientReport patientReport) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		String pid="";
		if(patientReport.getPid().matches(pid)) {
			context.addMessage("pid", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Patient id cannot be Empty",null));
			return false;
		}
		
		
		
		
		String testCodeRegex = "^T.*";
		
		if(!patientReport.getTestcode().matches(testCodeRegex)) {
			context.addMessage("testcode", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Test code must start with T",null));
			return false;
		}
		
		
		String testNameRegex = "^.{5,}$";
		if(!patientReport.getTestName().matches(testNameRegex)) {
			context.addMessage("testname", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Test Name must contain 5 characters",null));
			return false;
		}
		
		

		if (!(patientReport.getCost()>50)){
		    context.addMessage("cost", new FacesMessage(
		            FacesMessage.SEVERITY_ERROR, "Cost must be 50 or greater than 50", null));
		    return false;
		}



		
		return true;
	}
	
	

}
