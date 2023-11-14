package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agent")

public class Agent implements Serializable{
	
	@Id
	@Column(name="agentID")
	private int AgentID;
	
	@Column(name="Name")
	private String Name;
	@Column(name="city")
	private String City;
	@Column(name="gender")
	private Gender GENDER;
	@Column(name="maritalstatus")
	private int MaritalStatus;
	@Column(name="premium")
	private double Premium;
	
	public int getAgentID() {
		return AgentID;
	}
	public void setAgentID(int agentID) {
		AgentID = agentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Gender getGENDER() {
		return GENDER;
	}
	public void setGENDER(Gender gENDER) {
		GENDER = gENDER;
	}
	public int getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public double getPremium() {
		return Premium;
	}
	public void setPremium(double premium) {
		Premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [AgentID=" + AgentID + ", Name=" + Name + ", City=" + City + ", GENDER=" + GENDER
				+ ", MaritalStatus=" + MaritalStatus + ", Premium=" + Premium + "]";
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
}
