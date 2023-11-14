package com.java.hib;

public class Dummy {
	
	public static void main(String[] args) {
		InsuranceDetailsDAOImpl dao=new InsuranceDetailsDAOImpl();
		
	//	System.out.println(dao.getListOfInsurancedetails(2, 6));
		
		InsurancePlansDAOImpl impl=new InsurancePlansDAOImpl();
		System.out.println(impl.showPlans("I010"));
	}

}
