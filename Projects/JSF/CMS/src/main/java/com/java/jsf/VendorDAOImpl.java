package com.java.jsf;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class VendorDAOImpl implements VendorDAO{
	SessionFactory sf;
	Session session;
	
	
	private String localCode;
	private int venId;
	


	public String getLocalCode() {
		return localCode;
	}


	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}


	public int getVenId() {
		return venId;
	}
	
	public void setVenId(int venId) {
		this.venId = venId;
	}






	@Override
		public List<Vendor> showVendorDAO(){
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			
			Criteria cr = session.createCriteria(Vendor.class);
			
			List<Vendor> vendorList = cr.list();
			System.out.println(vendorList);
			return vendorList;
			
		}
			
	public int getVendorid(String vendorName) {
		sf= SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eq("venname", vendorName));
		Vendor vendor = (Vendor)cr.uniqueResult();
		return vendor.getVenid();
		
	}
	
	
	public List<String> showVendorNames(){
		sf= SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		Projection projection = Projections.property("venname");
		cr.setProjection(projection);
		List<String> list = cr.list();
		System.out.println(list);
		return list;
		
		
	}
	
	
	public void employLocaleCodeChanged(ValueChangeEvent e) {
		this.localCode =e.getNewValue().toString();
		this.venId = getVendorid(localCode);
	}

}
