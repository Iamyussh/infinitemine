package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CustomerDAOImpl {
	SessionFactory sf;
	Session session;
	
	private String localCode;
	
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	
	
	public void employLocaleCodeChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();
	}
	public List<Customer> showCustomerDao(){
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		return cr.list();		
	}	
	public String addCustomerDao(Customer customer) {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		
		String body ="Welcome to Swiggylite  " +customer.getCusname() ;
		MailSend.mailOtp(customer.getCusemail(), "Your Account is created", body);
		
		return "ShowCustomers.jsp?faces-redirect=true" + "Account is created";
		
	
	}
	
	public String Loginvalidate(Customer customer) {
		
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		 sf = SessionHelper.getConnection();
		 session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("cususername",customer.getCususername()));
		cr.add(Restrictions.eq("cuspassword",customer.getCuspassword()));
		cr.setProjection(Projections.rowCount());
		long count = (Long)cr.uniqueResult();
		session.close();
		sf.close();
		if(count==1) {
			sessionMap.put("loggedCustomer",  customer.getCususername());
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.eq("cususername", customer.getCususername()));
			Customer customerFound = (Customer) cr.uniqueResult();
			sessionMap.put("customerFound", customerFound);
			sessionMap.put("cusid", customerFound.getCusid());
			return "Dashboard.jsp?faces-redirect=true";
		}
		else {
			sessionMap.put("errorMessage", "Invalid Credentials....");
			return "CustomerLogin.jsp?faces-redirect=true";
		}
		
	
	}
	
	public String searchCustomerDetailsDao() {

		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String customerLoggined = (String)sessionMap.get("loggedCustomer");
	sf = SessionHelper.getConnection();
	session = sf.openSession();
	Criteria criteria = session.createCriteria(Customer.class);

	criteria.add(Restrictions.eq("cususername", customerLoggined));
	Customer customerData = (Customer) criteria.uniqueResult();
	sessionMap.put("customerFound", customerData);
	sessionMap.put("customerId", customerData.getCusid());
	return "CustomerInfo.jsp?faces-redirect=true";

	}
	
	
	
	public String showWalletDao() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int cusid = (Integer)sessionMap.get("cusid");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Wallet.class);
		cr.add(Restrictions.eq("custId", cusid));
		List<Wallet> walletlist =cr.list();
		System.out.println("Total Records Retrieved" +walletlist.size());
		sessionMap.put("walletList", walletlist);
		return "ShowWallet.jsp?faces-redirect=true?";
		
	
	}
	
	
	public List<String> showWalletNames(){
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		int cusid = (Integer)sessionMap.get("cusid");
		Criteria cr = session.createCriteria(Wallet.class);
		cr.add(Restrictions.eq("custId",cusid));
		Projection projection = Projections.property("walletsource");
		cr.setProjection(projection);
		List<String> walletList = cr.list();
		System.out.println(walletList);
		return walletList;
	}
	
	

}
