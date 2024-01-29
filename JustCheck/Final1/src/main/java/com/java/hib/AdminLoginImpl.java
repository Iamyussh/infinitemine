package com.java.hib;

import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class AdminLoginImpl implements AdminLoginDAO{
	
	SessionFactory sf;
	Session session;
	
	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	@Override
	public String adminSignIn(AdminLogin admin) {
		String encr = EncryptPassword.getCode(admin.getPassword());
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(AdminLogin.class);
		cr.add(Restrictions.eq("username", admin.getUsername()));
		cr.setProjection(Projections.rowCount());
		long userNameCount = (long) cr.uniqueResult();
		if(userNameCount > 0) {
			return "User Already exit";
		}
		
		admin.setPassword(encr.trim());
		session.beginTransaction();
		int otp = generateOtp();
		admin.setOtp(String.valueOf(otp));
		session.save(admin);
		session.getTransaction().commit();
		String subject = "Welcome to My app";		
		
		return "AdminLogin.jsp?faces-redirect=true";	
	}
	
	@Override
	public String loginDao(AdminLogin adminauth) {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(AdminLogin.class);
		cr.add(Restrictions.eq("username",adminauth.getUsername()));
		cr.add(Restrictions.eq("password",EncryptPassword.getCode(adminauth.getPassword())));
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("username",adminauth.getUsername());
		
		cr.setProjection(Projections.rowCount());
		long count = (long) cr.uniqueResult();
		if(count == 1) {
			return"Menu.jsp?faces-redirect=true";
		}
		
		else {
			
			sessionMap.put("passWordErr3", "Enter a valid UserName and Password.");
			return "";
		}
	}

}
