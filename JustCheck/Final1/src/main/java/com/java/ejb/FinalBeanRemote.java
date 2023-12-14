package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FinalBeanRemote {
	
	List<InsuranceDetails>showInsurancedetails();

}
