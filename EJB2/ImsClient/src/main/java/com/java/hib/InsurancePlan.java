package com.java.hib;

public class InsurancePlan {
	
	private int planid;
	private int insuranceid;
	private double premiumamt;
	private double coverageamt;
	
	
	
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public int getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(int insuranceid) {
		this.insuranceid = insuranceid;
	}
	public double getPremiumamt() {
		return premiumamt;
	}
	public void setPremiumamt(double premiumamt) {
		this.premiumamt = premiumamt;
	}
	public double getCoverageamt() {
		return coverageamt;
	}
	public void setCoverageamt(double coverageamt) {
		this.coverageamt = coverageamt;
	}
	public InsurancePlan(int planid, int insuranceid, double premiumamt, double coverageamt) {
		super();
		this.planid = planid;
		this.insuranceid = insuranceid;
		this.premiumamt = premiumamt;
		this.coverageamt = coverageamt;
	}
	public InsurancePlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsurancePlan [planid=" + planid + ", insuranceid=" + insuranceid + ", premiumamt=" + premiumamt
				+ ", coverageamt=" + coverageamt + "]";
	}
	
	
	
	
	
	
	

}
