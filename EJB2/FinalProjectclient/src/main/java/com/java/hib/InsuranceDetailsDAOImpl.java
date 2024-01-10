package com.java.hib;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class InsuranceDetailsDAOImpl {
	SessionFactory sf;
	Session session;

	public List<InsuranceDetails> getListOfInsurancedetails(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<InsuranceDetails> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(InsuranceDetails.class);
		

		if (orderById.equals("asc")) {
			criteria.addOrder(Order.asc("insuranceId"));
		}

		else if (orderById.equals("desc")) {
			criteria.addOrder(Order.desc("insuranceId"));
		} else if (orderByInsuranceName.equals("asc")) {
			criteria.addOrder(Order.asc("insuranceName"));
		} else if (orderByInsuranceName.equals("desc")) {
			criteria.addOrder(Order.desc("insuranceName"));
		} else if (orderByType.equals("asc")) {
			criteria.addOrder(Order.asc("type"));
		} else if (orderByType.equals("desc")) {
			criteria.addOrder(Order.desc("type"));
		} else if (orderByPstart.equals("asc")) {
			criteria.addOrder(Order.asc("premiumStart"));
		} else if (orderByPstart.equals("desc")) {
			criteria.addOrder(Order.desc("premiumStart"));
		} else if (orderByPend.equals("asc")) {
			criteria.addOrder(Order.asc("premiumEnd"));
		} else if (orderByPend.equals("asc")) {
			criteria.addOrder(Order.desc("premiumEnd"));
		} else if (orderByldate.equals("asc")) {
			criteria.addOrder(Order.asc("launchDate"));
		} else if (orderByldate.equals("desc")) {
			criteria.addOrder(Order.desc("launchDate"));
		}else if (orderBystatus.equals("asc")) {
				criteria.addOrder(Order.asc("status"));
			} else if (orderBystatus.equals("desc")) {
				criteria.addOrder(Order.desc("status"));
			}else {
			System.out.println("done");
		}
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

	public String addInsuranceplan(InsuranceDetails insuranceDetails) {
		String Id = generateId();

		Date launchDate = (Date) insuranceDetails.getLaunchDate();
		Date premiumStart = (Date) insuranceDetails.getPremiumStart();
		Date premiumEnd = (Date) insuranceDetails.getPremiumEnd();

		insuranceDetails.setInsuranceId(Id);
		insuranceDetails.setLaunchDate(launchDate);
		insuranceDetails.setPremiumStart(premiumStart);
		insuranceDetails.setPremiumEnd(premiumEnd);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(insuranceDetails);
		trans.commit();
		sessionMap.put("insuranceid", insuranceDetails.getInsuranceId());
		sessionMap.put("details", "Insurance Plan was added successfully");
		return "AddSubplan.jsp?faces-redirect=true";
	}

	public List<InsuranceDetails> showInsuranceDetails() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(InsuranceDetails.class);
		List<InsuranceDetails> insuranceList = cr.list();
		return insuranceList;
	}

	public String searchInsuranceDetails(String insuranceId) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(InsuranceDetails.class);
		cr.add(Restrictions.eq("insuranceId", insuranceId));
		InsuranceDetails insuranceFound = (InsuranceDetails) cr.uniqueResult();
		sessionMap.put("insuranceFound", insuranceFound);
		return "EditInsurance.jsp?faces-redirect=true";
	}

	public String generateId() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(InsuranceDetails.class);		
		criteria.setProjection(Projections.max("insuranceId"));		
		String insId = (String) criteria.uniqueResult();
		
		if (insId == null) {
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

	public String UpdateInsurance(InsuranceDetails InsuranceEdit) {
		System.out.println("hit");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(InsuranceEdit);
		trans.commit();
		return "InsuranceDetailsPagination.jsp?faces-redirect=true";
	}
	
	
	
	
	//  SORTING THE COLUMNS 

	static String orderByInsuranceName = "test";
	static String orderByType = "test";
	static String orderById = "test";
	static String orderByPstart = "test";
	static String orderByPend = "test";
	static String orderByldate = "test";
	static String orderBystatus = "test";

	public String sortByinsuranceName() {

		if (orderByInsuranceName.length() == 4) {
			orderByInsuranceName = "asc";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		} else if (orderByInsuranceName.equals("asc")) {
			orderByInsuranceName = "desc";

			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		}
		return "";
	}

	public String sortorderByType() {

		if (orderByType.length() == 4) {
			orderByType = "asc";

			orderByInsuranceName = "test";

			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		} else if (orderByType.equals("asc")) {
			orderByType = "desc";

			orderByInsuranceName = "test";

			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		}
		return "";
	}

	public String sortorderById() {

		if (orderById.length() == 4) {
			orderById = "asc";

			orderByInsuranceName = "test";
			orderByType = "test";

			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		} else if (orderById.equals("asc")) {
			orderById = "desc";

			orderByInsuranceName = "test";
			orderByType = "test";

			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		}
		return "";
	}

	public String sortorderByPstart() {

		if (orderByPstart.length() == 4) {
			orderByPstart = "asc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";

			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		} else if (orderByPstart.equals("asc")) {
			orderByPstart = "desc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";

			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		}
		return "";
	}

	public String sortorderByPend() {

		if (orderByPend.length() == 4) {
			orderByPend = "asc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";

		} else if (orderByPend.equals("asc")) {
			orderByPend = "desc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderByldate = "test";
			orderBystatus = "test";
		}
		return "";
	}

	public String sortorderByldate() {

		if (orderByldate.length() == 4) {
			orderByldate = "asc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderBystatus = "test";

		} else if (orderByldate.equals("asc")) {
			orderByldate = "desc";

			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			orderBystatus = "test";

		}
		return "";
	}
	
	public String sortorderBystatus() {

		if (orderBystatus.length()==4) {
			System.out.println("ayuuu"+ orderBystatus.length());
			orderBystatus = "asc";

			orderByldate = "test";
			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
			

		}
		else if(orderBystatus.equals("asc")) {
			
			orderBystatus = "desc";

			orderByldate = "test";
			orderByInsuranceName = "test";
			orderByType = "test";
			orderById = "test";
			orderByPstart = "test";
			orderByPend = "test";
		
			
		}
		System.out.println("Sorting status");
		return "";
		
	}

	public String logout() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.clear();
		return "AdminLogin.jsp?faces-redirect=true";

	}

}
