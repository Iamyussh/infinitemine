package com.java.servlets;

import java.sql.Date;

public class Customer {
	
	private   int custid;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String phoneNo;
	private String Email;
	private String Status;
	private Date activatedate;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custid, String firstName, String lastName, String userName, String password, String email,
			String status, Date activatedate) {
		super();
		this.custid = custid;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		Email = email;
		Status = status;
		Activatedate = activatedate;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getActivatedate() {
		return Activatedate;
	}
	public void setActivatedate(Date activatedate) {
		Activatedate = activatedate;
	}
	
	
	
	
	

}
