package com.java.hms;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PatientDAOImpl implements PatientDAO{

	SessionFactory sf;
	Session session;
	
	
	public String generateOtp() {
		int len=6;
		  String AlphaNumericString = "0123456789";
			  StringBuilder sb = new StringBuilder(len);
			  for (int i=0;i<len;i++) {
			   int index = (int)(AlphaNumericString.length()
			      * Math.random());
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
			  return sb.toString();
	}
	
	@Override
	public String addPatient(Patient patient) {
		
		String otp1 =generateOtp();
		
		patient.setStatus("PENDING");
		patient.setOtp(otp1);
		System.out.println("This is the otp" +otp1);
		System.out.println(patient);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(patient);
		trans.commit();
		
		String body ="Welcome Mr/Miss  " + patient.getName() + "\r\n"+
				"Your OTP Generated Successfully..." +"\r\n" + 
				"OTP is " +otp1;
		MailSend.mailOtp(patient.getEmail(), "Otp Send Succesfully...", body);
		
		return "CreatePassword.jsp?faces-redirect=true";
		
	}
		
	public Patient searchpatientname(String username) {
		sf = SessionHelper.getConnection();
		session  = sf.openSession();
		
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eqOrIsNull("username",username));
		
		Patient patient =(Patient) cr.uniqueResult();
		
		
		return patient;
	}
	
	
	
	public String setPatientPassword(Patient patient) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eqOrIsNull("username",patient.getUsername()));
		Projection projection = Projections.property("otp");
		cr.setProjection(projection);
		String otP = (String)cr.uniqueResult();
		String password = patient.getPassword();

		session.close();
		sf.close();
		
		if(otP.equals(patient.getOtp())) {
			
			Patient patientFound = searchpatientname(patient.getUsername());
			patientFound.setPassword(password);
			patientFound.setStatus("ACTIVE");
			
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(patientFound);
			transaction.commit();
			
			return "LoginPatient.jsp?faces-redirect=true";
			
		}
		else {
			Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("otpError","Invalid UserName or Otp...");
			return "Invalid UserName or Otp...";
		}
	}
	
	
	
	public String loginvalidate(Patient patient) {
		
		
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("username",patient.getUsername()));
		cr.add(Restrictions.eq("password", patient.getPassword()));
		
		cr.setProjection(Projections.rowCount());
		long count = (long)cr.uniqueResult();
		
		if(count==1) {
			sessionMap.put("loggeduser", patient.getUsername());
			System.out.println(patient.getName());
			return "Dashboard.jsp?faces-redirect=true";
			
		}
		else {
			sessionMap.put("loginError", "Invalid UserName or Password...");
			return "Invalid UserName or Password...";
		}
		
	
		
	}
	
	

}
