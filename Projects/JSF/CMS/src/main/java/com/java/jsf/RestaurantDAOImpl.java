package com.java.jsf;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class RestaurantDAOImpl {

	SessionFactory sf;
	Session session;
	
	
	private String localCode;
	
	
	
	
	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	public void restaurantLocaleChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();
		
	}

	
	private String menuchanged;
	
	
	public String getMenuchanged() {
		return menuchanged;
	}
	
	public void MenuLocaleChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();
	}

	public void setMenuchanged(String menuchanged) {
		this.menuchanged = menuchanged;
	}
	

	public List<Restaurant> showRestaurant(){
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		return cr.list();
	}
	
	
	public List<String> showRestaurantNames(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		Projection projection  = Projections.property("Restaurant_Name");
		cr.setProjection(projection);
		List<String> RestaurantNames = cr.list();
		return RestaurantNames;
	}
	

}
