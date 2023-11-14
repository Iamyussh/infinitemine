package com.java.jsp;

import java.sql.Date;

public class Employee {
	private int empId;
	private String empName;
	private String empMail;
	private String mobileNo;
	private Date dateofJoin;
	private int leaveAvail;
	private int managerId;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getDateofJoin() {
		return dateofJoin;
	}
	public void setDateofJoin(Date dateofJoin) {
		this.dateofJoin = dateofJoin;
	}
	public int getLeaveAvail() {
		return leaveAvail;
	}
	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empMail=" + empMail + ", mobileNo=" + mobileNo
				+ ", dateofJoin=" + dateofJoin + ", leaveAvail=" + leaveAvail + ", managerId=" + managerId + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
