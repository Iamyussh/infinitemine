package com.java.hms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DoctorDAOImpl implements DoctorDAO{
	
	SessionFactory sf;
	Session session;

	
	
	@Override
	public List<Doctor> ShowDoctorsDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		List<Doctor> doctorsList = cr.list();
		return doctorsList;
		
	}
	
		
}
