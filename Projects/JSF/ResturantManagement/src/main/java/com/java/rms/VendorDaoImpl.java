 package com.java.rms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class VendorDaoImpl implements VenderDAO{
	
	SessionFactory sessionFactory;
	Session session;
	
	private String localCode;
	private int venId;
	
	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public List<Vendor> showVendorDao() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		List<Vendor> vendorList = criteria.list();
		System.out.println(vendorList);
		return vendorList;
	}
	
	public int getVendorId(String vendorName) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		criteria.add(Restrictions.eq("venname", vendorName));
		Vendor vendor = (Vendor) criteria.uniqueResult();
		return vendor.getVenid();
	}
	public void employLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
		this.venId = getVendorId(localCode);
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("venName", this.localCode);
		sessionMap.put("venId", venId);
	}
	public List<String> showVendorNames() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		Projection projection = Projections.property("venname"); 
		criteria.setProjection(projection); 
		List<String> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	
	public String vendorLoginDao(Vendor vendor) {
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		criteria.add(Restrictions.eq("venusername", vendor.getVenusername()));
		criteria.add(Restrictions.eq("venpassword", vendor.getVenpassword()));
		criteria.setProjection(Projections.rowCount());
		long count=(long)criteria.uniqueResult();
		session.close();
		sessionFactory.close();
		if(count==1) {
			sessionFactory = SessionHelper.getConnection();
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Vendor.class);
			criteria.add(Restrictions.eqOrIsNull("venusername", vendor.getVenusername()));
			Vendor vendorFound = (Vendor) criteria.uniqueResult();
			sessionMap.put("venId", vendorFound.getVenid());
			sessionMap.put("loggedVendor", vendor.getVenname());			
			return "VendorDashboard.jsp?faces-redirect=true";
		}
		
		else {
			sessionMap.put("errorMessage", "Invalid Credentials....");
			return "VendorLogin.jsp?faces-redirect=true";
		}
		
	}
	
	public String showPendingOrders(){
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int venId = (int) sessionMap.get("venId");
		System.out.println(venId);
		Ordstatus status = Ordstatus.valueOf("PENDING");
		System.out.println(status);
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("venid", venId));
		//criteria.add(Restrictions.eq("ordstatus", status));
		List<Orders> OrderList = criteria.list();
		sessionMap.put("orderList", OrderList);
		return "VendorAction.jsp?faces-redirect=true";
		
	}
	
	
	
	public String acceptOrder(int venId) {
		
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionFactory = SessionHelper.getConnection();
			
			session = sessionFactory.openSession();
			  Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("venid",venId));
			Orders orderFound = (Orders)criteria.uniqueResult();
			orderFound.setOrdstatus(Ordstatus.ACCEPTED);
			Transaction trans = session.beginTransaction();
			sessionFactory = SessionHelper.getConnection();
			session = sessionFactory.openSession();
			session.update(orderFound);
			trans.commit();
			session.close();
			return "VendorAction.jsp?faces-redirect=true";
			
			
			
			
		
	}
	

	
	
	
	
	
}
