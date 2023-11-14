package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class InsuranceEjbImpl {
	
	public List<InsuranceDetails> showPatientEjb() throws NamingException{
		FinalBeanRemote remote = RemoteHelper.lookupRemoteStatelessInsurance();
		return remote.showInsurancedetails();
	}
	
	
	
	
	
}
