package com.java.agent;

import java.util.List;
import java.util.Scanner;

public class AgentMain {
	static AgentBAL bal;
	static Scanner sc;
	static{
		bal = new AgentBAL();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args){
		int choice;
		do{
			System.out.println("O P T I O N S");
			System.out.println("-----------------");
			System.out.println("1. Add Agent");
			System.out.println("2. Show Agent ");
			
			System.out.println("Enter the choice   ");
			choice  = sc.nextInt();
			
			switch (choice) {
			case 1:
				try{
					addAgentMain();
				} catch(AgentException e){
					System.err.println(e.getMessage());
				}
				
				break;
			case 2:
					showAgentMain(); 
				break;
				
				
				
			case 6:
				return;
			}
		}while(choice!=6);
		}
	
	
			
			
			public static void addAgentMain() throws AgentException{
				Agent agent = new Agent();
				
				
				System.out.println("Enter firstName  ");
				agent.setFirstName(sc.next());
				System.out.println("Enter lastName  ");
				agent.setLastName(sc.next());
				
				System.out.println("Enter the city  ");
				agent.setCity(sc.next());
				System.out.println("Choose Paymode ");
				agent.setPayMode(PayMode.valueOf(sc.next()));
				System.out.println("Enter Premium  ");
				agent.setPremium(sc.nextDouble());
				
				
				
				
				System.out.println(bal.addAgentBal(agent));
				
			}
			public static void showAgentMain(){
				List<Agent> agentList = bal.showAgentBal();
				for(Agent agent : agentList){
					System.out.println(agent);
				}
			}
			
}
