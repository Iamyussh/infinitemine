package com.java.hms;

import java.util.List;

public class main {
	   public static void main(String[] args) {
	        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

	        // Fetch the list of doctors
	        List<Doctor> doctorsList = doctorDAO.ShowDoctorsDao();

	        // Display doctor records in the console
	        for (Doctor doctor : doctorsList) {
	            System.out.println("Doctor ID: " + doctor.getDrId());
	            System.out.println("Doctor Name: " + doctor.getDrName());
	            System.out.println("Department: " + doctor.getDept());
	            System.out.println();
	        }
	    }
}
