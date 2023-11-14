package com.java.hms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PatientDAOImpl implements PatientDAO{

	SessionFactory sf;
	Session session;
	
	@Override
	public String addPatient(Patient patient) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(patient);
		trans.commit();
		return "addedPat.jsp?faces-redirect=true";
	}

}
