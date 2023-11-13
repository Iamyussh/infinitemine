package com.java.hib;

import java.util.Scanner;

public class AgentDeleteMain {
public static void main(String[] args) {
	
	int agentid;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Agent id");
	agentid = sc.nextInt();
	
	AgentDAO dao = new AgentDAOImpl();
	System.out.println(dao.deleteAgentDao(agentid));
}
}
