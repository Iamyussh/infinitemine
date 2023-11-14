package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="patient_report")

public class PatientReport implements Serializable{
	
	@Id
  
    @Column(name = "Report_Id")
	private int reportid;
	@Column(name = "pid")
	private String pid;
	@Column(name = "TestCode")
	private  String testcode;
	@Column(name = "TestName")
	private  String testName;
	@Column(name = "TestDescription")
	private  String testdesc;
	@Column(name = "Cost")
	private  double cost;
	@Column(name = "Comments")
	private String comments;
	
	
	
	public PatientReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientReport(int reportid, String pid, String testcode, String testName, String testdesc, double cost,
			String comments) {
		super();
		this.reportid = reportid;
		this.pid = pid;
		this.testcode = testcode;
		this.testName = testName;
		this.testdesc = testdesc;
		this.cost = cost;
		this.comments = comments;
	}
	public int getReportid() {
		return reportid;
	}
	public void setReportid(int reportid) {
		this.reportid = reportid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTestcode() {
		return testcode;
	}
	public void setTestcode(String testcode) {
		this.testcode = testcode;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestdesc() {
		return testdesc;
	}
	public void setTestdesc(String testdesc) {
		this.testdesc = testdesc;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "PatientReport [reportid=" + reportid + ", pid=" + pid + ", testcode=" + testcode + ", testName="
				+ testName + ", testdesc=" + testdesc + ", cost=" + cost + ", comments=" + comments + "]";
	}
	
	
	
	

}
