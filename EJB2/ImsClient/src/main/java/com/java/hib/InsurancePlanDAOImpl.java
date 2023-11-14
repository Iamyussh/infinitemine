package com.java.hib;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class InsurancePlanDAOImpl {
	
	SessionFactory sf;
	Session session;
	
	
	
	public String redirectToInsurancePlan(int insuranceid) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println("insuranceid is : "+insuranceid);
		sessionMap.put("insuranceid", insuranceid);
		return "ShowInsurancePlan.jsp?faces-redirect=true";
	}
	
	
	public List<InsurancePlan> showPlans(int insuranceid){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		List<InsurancePlan> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(InsurancePlan.class);
		criteria.add(Restrictions.eqOrIsNull("insuranceid",insuranceid ));
	return criteria.list();
	
	
	
	}
	
	public int countRows() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(InsurancePlan.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
