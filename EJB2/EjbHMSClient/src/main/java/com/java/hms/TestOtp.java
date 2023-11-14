package com.java.hms;

public class TestOtp {
	public static void main(String[] args) {
		PatientDAOImpl impl = new PatientDAOImpl();
		System.out.println(impl.generateOtp());
	}
}
