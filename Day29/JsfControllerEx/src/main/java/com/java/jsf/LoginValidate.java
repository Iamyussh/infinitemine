package com.java.jsf;

import javax.faces.context.FacesContext;
import java.util.Map;

import javax.faces.application.FacesMessage;

public class LoginValidate {
	
	public String validate(Login login) {
		FacesContext context = FacesContext.getCurrentInstance();
		if(login.getUserName().equals("Infinite") && login.getPassCode().equals("Infinite")) {
			
			return "Menu.jsp?faces-redirect=true";			
		} else {
			
			context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Invalid Credentials", null));
			return "Login.jsp?faces-redirect=true";
		}
	}
	

}
