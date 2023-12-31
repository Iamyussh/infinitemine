package com.java.ejb;

import java.io.Serializable;

public class Agent implements Serializable{
	private int AgentID;
	private String Name;
	private String City;
	private Gender GENDER;
	private int MaritalStatus;
	private double Premium;
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(int agentID, String name, String city, Gender gENDER, int maritalStatus, double premium) {
		super();
		AgentID = agentID;
		Name = name;
		City = city;
		GENDER = gENDER;
		MaritalStatus = maritalStatus;
		Premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [AgentID=" + AgentID + ", Name=" + Name + ", City=" + City + ", GENDER=" + GENDER
				+ ", MaritalStatus=" + MaritalStatus + ", Premium=" + Premium + "]";
	}
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

	
}
