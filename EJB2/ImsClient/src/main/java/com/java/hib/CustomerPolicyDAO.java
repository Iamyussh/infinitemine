package com.java.hib;

import java.text.ParseException;

public interface CustomerPolicyDAO {
		
	
	String redirectTotakePolicy(int planid,double premiumamt);
	String takePolicy(CustomerPolicy Newpolicy) throws ParseException;
}
