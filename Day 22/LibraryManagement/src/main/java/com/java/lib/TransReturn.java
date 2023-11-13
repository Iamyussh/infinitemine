package com.java.lib;

import java.util.Date;

public class TransReturn {
	private String Username;
	private int BookId;
	private Date Fromdate;	
	private Date Todate;
	
	
	
	@Override
	public String toString() {
		return "TransReturn [Username=" + Username + ", BookId=" + BookId + ", Fromdate=" + Fromdate + ", Todate="
				+ Todate + "]";
	}
	public TransReturn(String username, int bookId, Date fromdate, Date todate) {
		super();
		Username = username;
		BookId = bookId;
		Fromdate = fromdate;
		Todate = todate;
	}
	public TransReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public Date getFromdate() {
		return Fromdate;
	}
	public void setFromdate(Date fromdate) {
		Fromdate = fromdate;
	}
	public Date getTodate() {
		return Todate;
	}
	public void setTodate(Date todate) {
		Todate = todate;
	}
	
	
	
	

}
