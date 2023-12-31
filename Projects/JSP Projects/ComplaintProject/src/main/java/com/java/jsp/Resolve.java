package com.java.jsp;

import java.sql.Timestamp;

public class Resolve {
	private String ResolveID;
	private String ComplaintID;
	private Timestamp ComplaintDate;
	private Timestamp ResolveDate;
	private String ResolvedBy;
	private String Comments;
	
	@Override
	public String toString() {
		return "Resolve [ResolveID=" + ResolveID + ", ComplaintID=" + ComplaintID + ", ComplaintDate=" + ComplaintDate
				+ ", ResolveDate=" + ResolveDate + ", ResolvedBy=" + ResolvedBy + ", Comments=" + Comments + "]";
	}
	public Resolve(String resolveID, String complaintID, Timestamp complaintDate, Timestamp resolveDate,
			String resolvedBy, String comments) {
		super();
		ResolveID = resolveID;
		ComplaintID = complaintID;
		ComplaintDate = complaintDate;
		ResolveDate = resolveDate;
		ResolvedBy = resolvedBy;
		Comments = comments;
	}
	public String getResolveID() {
		return ResolveID;
	}
	public void setResolveID(String resolveID) {
		ResolveID = resolveID;
	}
	public String getComplaintID() {
		return ComplaintID;
	}
	public void setComplaintID(String complaintID) {
		ComplaintID = complaintID;
	}
	public Timestamp getComplaintDate() {
		return ComplaintDate;
	}
	public void setComplaintDate(Timestamp complaintDate) {
		ComplaintDate = complaintDate;
	}
	public Timestamp getResolveDate() {
		return ResolveDate;
	}
	public Resolve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setResolveDate(Timestamp resolveDate) {
		ResolveDate = resolveDate;
	}
	public String getResolvedBy() {
		return ResolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		ResolvedBy = resolvedBy;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	

}
