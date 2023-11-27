package com.java.hib;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class InsuranceController {
	
	private InsuranceDetails insuranceDetails;
	private InsuranceDetailsDAOImpl insuranceDetailsdao;
	private InsurancePlans insurancePlan;
	private InsurancePlansDAOImpl insurancePlansdao;
	




	public InsuranceDetails getInsuranceDetails() {
		return insuranceDetails;
	}


	public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}


	public InsuranceDetailsDAOImpl getInsuranceDetailsdao() {
		return insuranceDetailsdao;
	}


	public void setInsuranceDetailsdao(InsuranceDetailsDAOImpl insuranceDetailsdao) {
		this.insuranceDetailsdao = insuranceDetailsdao;
	}


	public InsurancePlans getInsurancePlan() {
		return insurancePlan;
	}


	public void setInsurancePlan(InsurancePlans insurancePlan) {
		this.insurancePlan = insurancePlan;
	}


	public InsurancePlansDAOImpl getInsurancePlansdao() {
		return insurancePlansdao;
	}


	public void setInsurancePlansdao(InsurancePlansDAOImpl insurancePlansdao) {
		this.insurancePlansdao = insurancePlansdao;
	}


	public String addInsurance(InsuranceDetails insurancedetailsnew) {
		
		
		if(addinsurancevalidate(insurancedetailsnew)) {
			return insuranceDetailsdao.addInsuranceplan(insurancedetailsnew);
		}
		
		return "";
	}
	

	public String addInsurancePlans(InsurancePlans insurancePlansnew) {
		if(addinsuranceplansvalidate(insurancePlansnew)) {
			return insurancePlansdao.addInsuranceSubplan(insurancePlansnew);
		}
		
		return "";

	}
	
	
	
	
	public  boolean addinsuranceplansvalidate(InsurancePlans insurancePlansnew) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		//String quantityInput1 = double.toString(medicines.getPrice());
				String priceInput = Double.toString(insurancePlansnew.getPremiumamt());
				//String priceInput = Double.parseDouble(medicines.getPrice()));
			  // String doublePattern = "^-?\\\\d+(\\\\.\\\\d+)?$";
				//String doublePattern = "[-+]?\\\\d*\\\\.?\\\\d+";
				// String doublePattern = "^[0-9]+$";
				//String doublePattern = "";
				//  String price=  "^[0-9]+(\\\\.[0-9]+)?$";
				  String price= "[0-9]{1,13}(.[0-9]*)?";
						
//			 	Price cannot be Null
					if(insurancePlansnew.getPremiumamt()==0) {
						 context.addMessage("form:pamt",new FacesMessage("Premium amount cannot be null"));
						return false;
					}
				
				// Price cannot be String
			if(!Pattern.matches(price, priceInput)) {
					System.out.println("Err1");
					context.addMessage("form:pamt",new FacesMessage("Please enter numeric only"));
					//  context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "quantity cannot be character", null));
					 return false;
					
				}
		
		
		
		 String reg1 = "^[A-Za-z]+$";
		 if (insurancePlansnew.getDiscov().isEmpty() || !insurancePlansnew.getDiscov().matches(reg1)){
			 
	        	context.addMessage("dis", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Diseases field cannot be empty or numeric",null));
	           return false;		        
	    }
		 
		
	
		return true;
	}



	public boolean addinsurancevalidate(InsuranceDetails insurancedetailsnew) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		 if (insurancedetailsnew.getInsuranceName().equals(null)|| insurancedetailsnew.getInsuranceName().length() < 5) {
		        context.addMessage("iname", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Insurance name must contain at least 5 characters",null));
		        return false;
		    }
		 
		 
		 if (insurancedetailsnew.getPremiumStart() != null && insurancedetailsnew.getPremiumEnd() != null) {
		        if (insurancedetailsnew.getPremiumStart().after(insurancedetailsnew.getPremiumEnd())) {
		        	context.addMessage("pstart", new FacesMessage(
							FacesMessage.SEVERITY_ERROR,"End date must be greater than start date",null));
		           return false;
		        }
		    }
		 
		 if (insurancedetailsnew.getMinPeriod()> insurancedetailsnew.getMaxPeriod()) {
			 context.addMessage("minperiod", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Min Period must be less than Max Period",null));
		        return false;
		    }
		 
		 
		 if (insurancedetailsnew.getLaunchDate()==null) {
			 
	        	context.addMessage("ldate", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Please enter the launch date",null));
	           return false;
	        
	    }
	 
		 if (insurancedetailsnew.getStatus().matches("")) {
			 
		        	context.addMessage("status", new FacesMessage(
							FacesMessage.SEVERITY_ERROR,"Status cannot be empty",null));
		           return false;		        
		    }
		 		 
		return true;
		
		
		
		
		
	}
	

} 
