package com.java.jsf;

import java.util.Map;

import javax.faces.context.FacesContext;

public class LoginValidate {
	public String validate(Login login) {
		Map<String,Object> sessionMap=
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		
		if(login.getUserName().equals("infinite") && login.getPassCode().equals("Infinite")) {
		return "Menu.xhtml?faces-redirect=true";
		
	}
		else {
			sessionMap.put("error", "Invalid Credentials😥😥");
			return "Login.xhtml?faces-redirect=true";
		}
		
	}
}
