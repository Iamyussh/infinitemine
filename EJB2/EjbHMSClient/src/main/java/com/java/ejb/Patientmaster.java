package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_master")

public class Patientmaster implements Serializable {
		
	@Id
	@Column(name="pid")
	private String pid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	@Column(name="weight")
	private int weight;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="phoneno")
	
	private String phoneno;
	@Column(name="disease")
	private String disease;
	@Column(name="doctor_id")
	private String doctorId;
	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="otp")
	private int otp;
	@Column(name="email")
	private String email;
	@Column(name="status")
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
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
		return "Patientmaster [pid=" + pid + ", name=" + name + ", age=" + age + ", weight=" + weight + ", gender="
				+ gender + ", address=" + address + ", phoneno=" + phoneno + ", disease=" + disease + ", doctorId="
				+ doctorId + ", username=" + username + ", password=" + password + ", otp=" + otp + ", email=" + email
				+ ", status=" + status + "]";
	}
	public Patientmaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patientmaster(String pid, String name, int age, int weight, String gender, String address, String phoneno,
			String disease, String doctorId, String username, String password, int otp, String email, String status) {
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
		this.password = password;
		this.otp = otp;
		this.email = email;
		this.status = status;
	}
	
	
	
	
	
	
	
	
}
