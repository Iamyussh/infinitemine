package com.java.hib;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

public class InsuranceDetailsDAOImpl {
			SessionFactory sf;
			Session session;
	
	public List<InsuranceDetails> getListOfInsurancedetails(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<InsuranceDetails> cdList = null;
			session.beginTransaction();
			Criteria criteria = session.createCriteria(InsuranceDetails.class);
			criteria.setFirstResult(firstRow);
			criteria.setMaxResults(rowCount);
		return criteria.list();
	}
	
			
	public int countRows() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(InsuranceDetails.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public String addInsuranceplan(InsuranceDetails insuranceDetails){
		  String Id = generateId();
		
		Date launchDate = (Date) insuranceDetails.getLaunchDate();
		Date premiumStart = (Date) insuranceDetails.getPremiumStart();
		Date premiumEnd = (Date) insuranceDetails.getPremiumEnd(); 
	
		insuranceDetails.setInsuranceId(Id);
		insuranceDetails.setLaunchDate(launchDate);
		insuranceDetails.setPremiumStart(premiumStart);
		insuranceDetails.setPremiumEnd(premiumEnd);
		
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(insuranceDetails);
		trans.commit();
		sessionMap.put("insuranceid",insuranceDetails.getInsuranceId());
		return "AddSubplan.jsp?faces-redirect=true";  
	}
	
	public List<InsuranceDetails> showInsuranceDetails() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria  cr = session.createCriteria(InsuranceDetails.class);
		List<InsuranceDetails> insuranceList = cr.list();
		return insuranceList;
	}
	
	
	public String generateId() {
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Criteria criteria = session.createCriteria(InsuranceDetails.class);
	    criteria.setProjection(Projections.max("insuranceId"));
	    String insId = (String) criteria.uniqueResult();
	    
	    if ( insId== null) {
	        return "I001";
	    } else {
	        try {
	            int num = Integer.parseInt(insId.substring(2));
	            num++;
	          
//	            System.out.println(String.format("PH%03d", num));
	            return String.format("I%03d", num);
	        } catch (NumberFormatException e) {
	            return "";
	        }
	    }
	}

}
