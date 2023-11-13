package com.java.hib;

import java.util.Scanner;

public class AgentSearchMain {
	public static void main(String[] args) {
		
	
			int agentid;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Agent ID:");
			agentid = sc.nextInt();
			AgentDAO dao = new AgentDAOImpl();
			
			Agent agent = dao.searchAgentDao(agentid);
			if(agent!=null) {
				System.out.println(agent);
			}
}
}