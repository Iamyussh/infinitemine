package com.java.ejb;

import java.sql.Date;

public class RoomAllocation {
	
	private String roomno;
	private String pid;
	private Date admissiondate;
	private Date releasedate;
	
	
	
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getAdmissiondate() {
		return admissiondate;
	}
	public void setAdmissiondate(Date admissiondate) {
		this.admissiondate = admissiondate;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public RoomAllocation(String roomno, String pid, Date admissiondate, Date releasedate) {
		super();
		this.roomno = roomno;
		this.pid = pid;
		this.admissiondate = admissiondate;
		this.releasedate = releasedate;
	}
	public RoomAllocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RoomAllocation [roomno=" + roomno + ", pid=" + pid + ", admissiondate=" + admissiondate
				+ ", releasedate=" + releasedate + "]";
	}
	
	
	
	
	

}
