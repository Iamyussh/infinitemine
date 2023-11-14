package com.java.jsf;

public class Customer {
		private int cusid;
		private String cusname;
		private String phoneno;
		private String cususername;
		private String cuspassword;
		private String cusemail;
		public int getCusid() {
			return cusid;
		}
		public void setCusid(int cusid) {
			this.cusid = cusid;
		}
		public String getCusname() {
			return cusname;
		}
		public void setCusname(String cusname) {
			this.cusname = cusname;
		}
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}
		public String getCususername() {
			return cususername;
		}
		public void setCususername(String cususername) {
			this.cususername = cususername;
		}
		public String getCuspassword() {
			return cuspassword;
		}
		public void setCuspassword(String cuspassword) {
			this.cuspassword = cuspassword;
		}
		public String getCusemail() {
			return cusemail;
		}
		public void setCusemail(String cusemail) {
			this.cusemail = cusemail;
		}
		public Customer(int cusid, String cusname, String phoneno, String cususername, String cuspassword,
				String cusemail) {
			super();
			this.cusid = cusid;
			this.cusname = cusname;
			this.phoneno = phoneno;
			this.cususername = cususername;
			this.cuspassword = cuspassword;
			this.cusemail = cusemail;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
}
