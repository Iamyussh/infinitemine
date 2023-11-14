package com.java.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CustomerController {
	
	private Customer customer;
	private CustomerDAOImpl daoImpl;
	private RestaurantDAOImpl restaurantDao;
	
	
	public RestaurantDAOImpl getRestaurantDao() {
		return restaurantDao;
	}
	public void setRestaurantDao(RestaurantDAOImpl restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerDAOImpl getDaoImpl() {
		return daoImpl;
	}
	public void setDaoImpl(CustomerDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	
	public String addCustomer() {
		
	if(addcustomervalidate()==true) {
		return daoImpl.addCustomerDao(customer);
		
			}
	
	return "";
	}
	
	
	public boolean addcustomervalidate() {
			FacesContext context = FacesContext.getCurrentInstance();
			
			if(customer.getCusname().length()<=5) {
				context.addMessage("CustomerName", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Username must contain 5 characters",null));
				return false;
			}		
			if (!customer.getPhoneno().matches("[0-9]+")) {
			    context.addMessage("PhoneNo", new FacesMessage(
			        FacesMessage.SEVERITY_ERROR, "Mobile number should contain numbers only", null));
			    return false;
			} else if (customer.getPhoneno().length() != 10) {
			    context.addMessage("PhoneNo", new FacesMessage(
			        FacesMessage.SEVERITY_ERROR, "Invalid Mobile number (should be 10 digits)", null));
			    return false;
			}
									
			String regex = "^(?=.*[0-9])"
					+ "(?=.*[a-z])(?=.*[A-Z])"
					+ "(?=.*[@#$%^&+=])"
					+"(?=\\S+$).{8,20}";
						
			if(!customer.getCuspassword().matches(regex)) {
				context.addMessage("Password", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Password must contain 8 characters with 1 special character and 1 number",null));
				return false;
			}
			
			return true;
		
	}
	
	public String SearchCustomer() {
		return daoImpl.searchCustomerDetailsDao();
	}
	public String ShowCustomerWallet() {
		return daoImpl.showWalletDao();
	}
	
	
	
	
	
	
		
	
	

}
