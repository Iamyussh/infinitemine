package com.java.hib;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class InsurancePlansDAOImpl {
	
	SessionFactory sf;
	Session session;
	
	public String redirectToInsurancePlan(String insuranceid) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println("insuranceid is : "+insuranceid);
		sessionMap.put("insuranceid", insuranceid);
		return "ShowInsurancePlans.jsp?faces-redirect=true";
	}
	
	public List<InsurancePlans> showPlans(String insuranceid){
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("insuranceid", insuranceid);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		List<InsurancePlans> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(InsurancePlans.class);
		criteria.add(Restrictions.eqOrIsNull("insuranceid",insuranceid ));
	return criteria.list();
		
	}
	
	public String redirectToAddSubplan(String insuranceId) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("insuranceid", insuranceId);
		return "AddSubplan.jsp?faces-redirect=true";
	}
	
	public String addInsuranceSubplan(InsurancePlans insuranceplan){
	
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		String insid = (String)sessionMap.get("insuranceid");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
	//	insuranceplan.setInsuranceid(insid);
		session.save(insuranceplan);
		trans.commit();
		
		return "AddSubplan.jsp?faces-redirect=true";
	}
}
