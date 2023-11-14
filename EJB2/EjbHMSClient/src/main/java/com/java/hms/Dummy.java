package com.java.hms;

public class Dummy {
	public static void main(String[] args) {
		PatientDAOImpl dao= new  PatientDAOImpl();
		System.out.println(dao.generateOtp().getClass());
	}
}
