package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class MenuDAOImpl {
	
	
	SessionFactory sf;
	Session session;
	public String showMenu(int Restaurant_ID) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("Restaurant_ID",Restaurant_ID));
		
		List<Menu> menuList = cr.list();
		sessionMap.put("menuList", menuList);
		return "ShowMenu.jsp?faces-redirect=true";
		
		
		
	}

}
