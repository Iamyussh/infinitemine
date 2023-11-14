package com.java.rms;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class OrdersDaoImpl implements OrdersDAO{
	
	SessionFactory sf;
	Session session;
	
	@Override
	public String placeOrderDao(Orders order) {
		java.util.Date utilDate = new java.util.Date();
		Date currentDate = new Date(utilDate.getTime());
		
		Map<String, Object> sessionMap =
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int custId = (int) sessionMap.get("customerId");
		int venId = (int) sessionMap.get("venId");
		int menuId = (int) sessionMap.get("menuId");
		double price = (Double) sessionMap.get("billAmount");
		double billAmount = price * order.getOrdquantity();
		System.out.println(billAmount);
		String payType = (String) sessionMap.get("payType");
		WalletSource ws = WalletSource.valueOf(payType);
		double walletAmount = new CustomerDaoImpl().purseValue(payType);
		if (walletAmount - billAmount > 0) {
			order.setCusid(custId);
			order.setVenid(venId);
			order.setWalsource(payType);
			order.setMenid(menuId);
			order.setOrdbillamount(billAmount);
			order.setOrdstatus(Ordstatus.PENDING);
			order.setOrddate(currentDate);
			System.out.println(order);
			double balance = walletAmount - billAmount;
			
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			session.save(order);
			trans.commit();
			session.close();
			session = SessionHelper.getConnection().openSession();
			String q = "from Wallet where custId = " +custId + " AND walletSource = '" +ws +"'";
			System.out.println(q);
			Query query = session.createQuery(q);
			
			Wallet wallet = (Wallet)query.list().get(0);
			trans = session.beginTransaction(); 
			wallet.setWalletAmount(balance); 
			session.update(wallet);
			trans.commit();
			return "Dashboard.jsp?faces-redirect=true";
		} else {
			return "Message.jsp?faces-redirect=true";
		}
	
	}
	
	
	
	public String showOrderHistoryDao(){
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int custId = (int) sessionMap.get("customerId");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("cusid", custId));
		List<Orders> OrderList = criteria.list();
		sessionMap.put("orderList", OrderList);
		return "ShowOrderHistory.jsp?faces-redirect=true?";
		
	}
	
	

	public String showPendingOrderHistoryDao(){
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int custId = (int) sessionMap.get("customerId");
		Ordstatus Status = Ordstatus.valueOf("PENDING");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("cusid", custId));
		criteria.add(Restrictions.eq("ordstatus", Status));
		List<Orders> OrderList = criteria.list();
		sessionMap.put("orderList", OrderList);
		
		return "ShowPendingOrders.jsp?faces-redirect=true?";
		
	}
	
	
	public Orders searchOrder(int ordid) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("ordid",ordid));
		Orders order = (Orders)criteria.uniqueResult();
		return order;
	}
		
	
	public String acceptOrder(int ordid) {
		Orders order  =searchOrder(ordid);
		order.setCusid(ordid);
		order.setOrdstatus(Ordstatus.valueOf("ACCEPTED"));
		sf = SessionHelper.getConnection();
		Transaction trans = session.beginTransaction();
		session.update(order);
		trans.commit();
		return "VendorAction.jsp?faces-redirect=true?";
	}
	
	
	public String rejectOrder(int ordid) {
		Orders order = searchOrder(ordid);
		order.setCusid(ordid);
		order.setOrdstatus(Ordstatus.valueOf("DENIED"));
		sf = SessionHelper.getConnection();
		Transaction trans = session.beginTransaction();
		session.update(order);
		trans.commit();
		
		refundAmt(order.getCusid(), order.getWalsource(), order.getOrdbillamount());
		return "VendorAction.jsp?faces-redirect=true?";
			
	}
	
	public void refundAmt(int cusid,String walsource,double billamt) {
			CustomerDaoImpl impl = new CustomerDaoImpl();
			Wallet wallet = impl.searchwalletById(cusid ,walsource);
			System.out.println("cusid" +cusid);
			System.out.println("walsource " +walsource);
			System.out.println("Bill " +billamt);
			System.out.println("wallet amt : "+wallet.getWalletAmount());
			wallet.setWalletAmount(wallet.getWalletAmount() +billamt);
			System.out.println(wallet);
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction tran = session.beginTransaction();
			session.update(wallet);
			tran.commit();
			}
}
