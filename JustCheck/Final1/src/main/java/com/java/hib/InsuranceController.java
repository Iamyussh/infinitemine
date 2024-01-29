package com.java.hib;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class InsuranceController {

	private InsuranceDetails insuranceDetails;
	private InsuranceDetailsDAOImpl insuranceDetailsdao;
	private InsurancePlans insurancePlans;
	private InsurancePlansDAOImpl insurancePlansdao;

	public InsuranceDetails getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	public InsurancePlans getInsurancePlans() {
		return insurancePlans;
	}

	public void setInsurancePlans(InsurancePlans insurancePlans) {
		this.insurancePlans = insurancePlans;
	}

	public InsurancePlansDAOImpl getInsurancePlansdao() {
		return insurancePlansdao;
	}

	public InsuranceDetailsDAOImpl getInsuranceDetailsdao() {
		return insuranceDetailsdao;
	}

	public void setInsuranceDetailsdao(InsuranceDetailsDAOImpl insuranceDetailsdao) {
		this.insuranceDetailsdao = insuranceDetailsdao;
	}

	public void setInsurancePlansdao(InsurancePlansDAOImpl insurancePlansdao) {
		this.insurancePlansdao = insurancePlansdao;
	}

	public String addInsurance(InsuranceDetails insurancedetailsnew) {
		if (addinsurancevalidate(insurancedetailsnew)) {
			return insuranceDetailsdao.addInsuranceplan(insurancedetailsnew);
		}
		return "";
	}

	public String addInsurancePlans(InsurancePlans insurancePlansnew) {

		System.out.println(insurancePlansnew);
		if (addinsuranceplansvalidate(insurancePlansnew)) {
			return insurancePlansdao.addInsuranceSubplan(insurancePlansnew);
		}

		return "";

	}
	
	
	public String  updateInsurancedetail(InsuranceDetails insurancedetailsnew) {
		if (updateinsurancevalidate(insurancedetailsnew)) {
			return insuranceDetailsdao.UpdateInsurance(insurancedetailsnew);
		}
		return "";
	}
	
	

	private boolean updateinsurancevalidate(InsuranceDetails insurancedetailsnew) {
		// TODO Auto-generated method stub
		
		FacesContext context = FacesContext.getCurrentInstance();

		boolean flag = true;


		if (insurancedetailsnew.getPremiumStart() == null) {

			context.addMessage("form:pstart",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the start date", null));
			flag = false;

		}

		if (insurancedetailsnew.getPremiumEnd() == null) {

			context.addMessage("form:pend",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the end date", null));
			flag = false;

		}

		if (insurancedetailsnew.getPremiumStart() != null && insurancedetailsnew.getPremiumEnd() != null) {
			if (insurancedetailsnew.getPremiumStart().after(insurancedetailsnew.getPremiumEnd())) {
				context.addMessage("form:pstart", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"End date must be greater than start date", null));
				flag = false;
			}
		}

		if (insurancedetailsnew.getLaunchDate() == null) {

			context.addMessage("form:ldate",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the launch date", null));
			flag = false;

		}

		if (insurancedetailsnew.getStatus().equals(null)) {

			context.addMessage("form:status",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status cannot be empty", null));
			flag = false;
		}

		return flag;

	
	
	}

	public boolean addinsuranceplansvalidate(InsurancePlans insurancePlansnew) {
		FacesContext context = FacesContext.getCurrentInstance();

		String reg2 = "^-?\\d+(?:\\.\\d+)?$";

		boolean flag = true;

		String camt = Double.toString(insurancePlansnew.getCoverageamt());

		String reg1 = "^[A-Za-z]+$";
		if (insurancePlansnew.getDiscov().isEmpty() || !insurancePlansnew.getDiscov().matches(reg1)) {

			context.addMessage("dis",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Diseases field cannot be empty or numeric", null));
			flag = false;
		}

		String amtt = Double.toString(insurancePlansnew.getPremiumamt());

		String exp1 = "[0-9]{1,13}(.[0-9]*)?";

		if (insurancePlansnew.getPremiumamt() == 0) {
			context.addMessage("form:pamt", new FacesMessage("Premium amount cannot be null"));
			flag = false;
		}

		if (insurancePlansnew.getCoverageamt() == 0) {
			context.addMessage("form:cvgamt", new FacesMessage("Coverage amount cannot be null"));
			flag = false;
		}

		if (!Pattern.matches(exp1, amtt)) {
			System.out.println("Err1");
			context.addMessage("form:pamt", new FacesMessage("Please enter numeric only"));
			// context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// "quantity cannot be character", null));
			flag = false;

		}

		if (!Pattern.matches(exp1, amtt)) {

			context.addMessage("form:cvgamt", new FacesMessage("Please enter numeric only"));
			// context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// "quantity cannot be character", null));
			flag = false;

		}
		
		
		
		return flag;
	}

	public boolean addinsurancevalidate(InsuranceDetails insurancedetailsnew) {

		FacesContext context = FacesContext.getCurrentInstance();

		boolean flag = true;

		if (insurancedetailsnew.getInsuranceName().equals(null)
				|| insurancedetailsnew.getInsuranceName().length() < 5) {
			context.addMessage("form:iname", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Insurance name must contain at least 5 characters", null));
			flag = false;
		}

		if (insurancedetailsnew.getType() == null || insurancedetailsnew.getType().isEmpty()) {
		    context.addMessage("form:type", new FacesMessage(FacesMessage.SEVERITY_ERROR,
		            "Please select a plan type", null));
		    flag = false;
		}
		
		
		if (insurancedetailsnew.getStatus()== null || insurancedetailsnew.getStatus().isEmpty()) {
		    context.addMessage("form:status", new FacesMessage(FacesMessage.SEVERITY_ERROR,
		            "Please select a Status", null));
		    flag = false;
		}
		

		

		if (insurancedetailsnew.getPremiumStart() == null) {

			context.addMessage("form:pstart",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the start date", null));
			flag = false;

		}

		if (insurancedetailsnew.getPremiumEnd() == null) {

			context.addMessage("form:pend",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the end date", null));
			flag = false;

		}

		if (insurancedetailsnew.getPremiumStart() != null && insurancedetailsnew.getPremiumEnd() != null) {
			if (insurancedetailsnew.getPremiumStart().after(insurancedetailsnew.getPremiumEnd())) {
				context.addMessage("form:pstart", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"End date must be greater than start date", null));
				flag = false;
			}
		}

		if (insurancedetailsnew.getLaunchDate() == null) {

			context.addMessage("form:ldate",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the launch date", null));
			flag = false;

		}

		if (insurancedetailsnew.getStatus().equals(null)) {

			context.addMessage("form:status",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status cannot be empty", null));
			flag = false;
		}

		return flag;

	}
}
