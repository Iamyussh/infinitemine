package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerPolicyDAOImpl implements CustomerPolicyDAO{
	
	SessionFactory sf;
	Session session;

	@Override
	public String redirectTotakePolicy(int planid,double premiumamt) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("planid", planid);
		sessionMap.put("premiumamt", premiumamt);
		return "TakePolicy.jsp?faces-redirect=true";
	}

	@Override
	public String takePolicy(CustomerPolicy Newpolicy) throws ParseException {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String custIdStr = (String) sessionMap.get("loggedCustId");
		String insuranceIdstr = (String) sessionMap.get("insuranceid");
		String planidstr = (String) sessionMap.get("planid");
		int custId = Integer.parseInt(custIdStr);
		int insuranceId = Integer.parseInt(insuranceIdstr);
		int planId = Integer.parseInt(planidstr);
		
		
		Newpolicy.setCustId(custId);
		Newpolicy.setInsuranceId(insuranceId);
		Newpolicy.setPlanid(planId);
		String payMode = Newpolicy.getPayMode().toString();
		
		
		double premiumAmt = (double) sessionMap.get("premiumamt");
		
		System.out.println(premiumAmt);
		
		double insuranceAmount = calculateInsuranceAmount(premiumAmt, payMode);
		
		Newpolicy.setInsuranceAmount(insuranceAmount);
		
		
		double initialAmount = calculateInitialAmount(insuranceAmount);
		Newpolicy.setInitialAmount(initialAmount);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(date);
		System.out.println("Current Date is " +sdf.parse(formattedDate));
		Newpolicy.setRegisterDate(sdf.parse(formattedDate));
				
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			System.out.println(Newpolicy);
			session.save(Newpolicy);
			transaction.commit();
			CustomerDetailsDAOImpl impl = new CustomerDetailsDAOImpl();
			impl.setStatusInCustomerDetails();	
			
			String username = (String)sessionMap.get("loggedUser");
			
			CustomerDetails customerFound = impl.searchcustomer(username);
			String email = customerFound.getEmail();
			Date regDate = sdf.parse(formattedDate);
			
			
			
			
			
			sendAlertmail(username, email, regDate);
			return "UserPage.jsp?faces-redirect=true";
			
	}
	
	
	
	double calculateInsuranceAmount(double insuranceAmount,String PayMode) {
		if(PayMode.equals("MONTHLY")) {
			return insuranceAmount/12;
		}
		
		else if(PayMode.equals("HALFYEARLY")) {
			return insuranceAmount/2;
		}
		else if(PayMode.equals("QUARTERLY")) {
			return insuranceAmount/4;
		}
		
		else {
			return insuranceAmount;
		}
	}
		
	
	
	double calculateInitialAmount (double insuranceAmount){
		double gstRate = 0.18; // 18% GST rate
		double gstAmount = insuranceAmount * gstRate;
		double initialAmount = insuranceAmount + gstAmount;
		return initialAmount;
	}
	
	
	public void sendAlertmail(String username,String email,Date regDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		Calendar calender = Calendar.getInstance();
		calender.setTime(regDate);
		calender.add(Calendar.MONTH, 1);
		Date dueDate = calender.getTime();
		String regdate = sdf.format(regDate);
		String duedate = sdf.format(dueDate);
		
		
		
		String body = "Welcome Mr/Miss  " + username + "\r\n" + "You have activated a policy  from date "
				+  regDate + "\r\n"  + "Next Payment Due Date is " + duedate;
		
		MailSend.mailOtp(email, "Otp Send Succesfully...", body);
	}
	
	
	public List<CustomerPolicy> showuserpolicies(int custid){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Integer loggedcustid = (Integer) sessionMap.get("loggedCustId");
		 custid=loggedcustid.intValue();
		
		System.out.println(custid);
		
		Criteria cr = session.createCriteria(CustomerPolicy.class);
		cr.add(Restrictions.eq("custId", custid));
		
		
		return cr.list();
		
	}
	
}
