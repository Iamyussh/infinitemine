package com.java.hms;

public class Patient {
		
	private String pid;
    private String name;
    private int age;
    private int weight;
    private String gender;
    private String address;
    private String phoneno;
    private String disease;
    private String doctorId;
    private String username;
    private String otp;
    private String password;
    private String email;
    private String status;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender
				+ ", address=" + address + ", phoneno=" + phoneno + ", disease=" + disease + ", doctorId=" + doctorId
				+ ", username=" + username + ", otp=" + otp + ", password=" + password + ", email=" + email
				+ ", status=" + status + "]";
	}
	public Patient(String pid, String name, int age, int weight, String gender, String address, String phoneno,
			String disease, String doctorId, String username, String otp, String password, String email,
			String status) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.address = address;
		this.phoneno = phoneno;
		this.disease = disease;
		this.doctorId = doctorId;
		this.username = username;
		this.otp = otp;
		this.password = password;
		this.email = email;
		this.status = status;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
    
    
	
    
    
    
}
