package com.java.hib;

import java.util.Scanner;

public class AgentInsertMain {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Agent agent = new Agent();
			
			System.out.println("Enter the Agentid:");
			agent.setAgentid(sc.nextInt());
			
			System.out.println("Enter the Agent name:");
			agent.setName(sc.next());
			
			System.out.println("Enter the City:");
			agent.setCity(sc.next());
			
			System.out.println("Enter the GENDER:");
			agent.setGender(Gender.valueOf(sc.next()));
			
			System.out.println("Enter the MARITAL STATUS:");
			agent.setMaritalstatus(sc.nextInt());
			
			System.out.println("Enter the PREMIUM:");
			agent.setPremium(sc.nextDouble());
			
			AgentDAO dao = new AgentDAOImpl();
			System.out.println(dao.addAgentDao(agent));
			
			
			
			
			
		}
}
