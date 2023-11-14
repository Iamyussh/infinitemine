package com.java.hib;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class InsuranceController {
	
	private InsuranceDetails insuranceDetails;
	private InsuranceDetailsDAOImpl insuranceDetailsdao;
	private InsurancePlans insuranceplans;
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
		
		String reg2 = "^-?\\d+(?:\\.\\d+)?$";
		 
		 
		 String pamt=Double.toString(insurancePlansnew.getPremiumamt());
		 
		 if (pamt.isEmpty() || pamt.matches(reg2)){
			 
	        	context.addMessage("bfts", new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Premium Amount cannot be null or cannot be string",null));
	           return false;		        
	    }
		
		 String reg1 = "^[A-Za-z]+$";
		 if (insurancePlansnew.getBenefits().isEmpty() || !insurancePlansnew.getBenefits().matches(reg1)){
			 
	        	context.addMessage("bfts", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Benefits field cannot be empty or numeric",null));
	           return false;		        
	    }
		 
		
	
		return false;
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
