package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.hib.CustomerDetails;
import com.java.hib.SessionHelper;

public class InsuranceEjbImpl {
	
	public List<InsuranceDetails> showPatientEjb() throws NamingException{
		InsuranceBeanRemote remote = RemoteHelper.lookupRemoteStatelessInsurance();
		return remote.showInsurancedetail();
	}
	
	
	
	
	
}
