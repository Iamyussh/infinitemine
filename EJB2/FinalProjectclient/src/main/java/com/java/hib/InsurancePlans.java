package com.java.hib;

public class InsurancePlans {
	
	
	private int planid;
	private String insuranceid;
	private double premiumamt;
	private double coverageamt;
	private String discov;
	
	
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public String getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(String insuranceid) {
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
	public String getDiscov() {
		return discov;
	}
	public void setDiscov(String discov) {
		this.discov = discov;
	}
	public InsurancePlans(int planid, String insuranceid, double premiumamt, double coverageamt,String discov) {
		super();
		this.planid = planid;
		this.insuranceid = insuranceid;
		this.premiumamt = premiumamt;
		this.coverageamt = coverageamt;
		this.discov = discov;
	}
	public InsurancePlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsurancePlans [planid=" + planid + ", insuranceid=" + insuranceid + ", premiumamt=" + premiumamt
				+ ", coverageamt=" + coverageamt + ", discov=" + discov + "]";
	}
	
	
	

	
	
	
	
	

}
