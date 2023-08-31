package com.java.agent;

import java.io.IOException;
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
			System.out.println("3. Search Agent ");
			System.out.println("4. Delete Agent ");
			System.out.println("5. Update Agent");
			System.out.println("6. Exit");
			System.out.println("7. Write your Agentfile");
			System.out.println("8  Read from Agentfile");

			
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
			case 3:
				searchAgentMain();
				break;
				
			case 4:
				deleteAgentMain();
				break;
			case 5:
				try {
					updateAgentMain();
				} catch (AgentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				
			case 6:
				return;
			case 7:
				try {
					writeAgentFileMain();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 8:
				try {
					readAgentFileMain();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
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
			
			public static void searchAgentMain(){
				int agentId;
				System.out.println("Enter Agent No  ");
				agentId = sc.nextInt();
				Agent agent = bal.searchAgentBal(agentId);
				if(agent !=null){
					System.out.println(agent);
				}
				else{
					System.out.println("Record not Found..." );
				}
			}
			
			public static void deleteAgentMain(){
				int agentId;
				System.out.println("Enter Agent Number   ");
				agentId = sc.nextInt();
				System.out.println(bal.deleteAgentBal(agentId));
				
			}
			
			public static void updateAgentMain() throws AgentException{
				Agent agentUpdated = new Agent();
				System.out.println("Enter Agent Id   ");
				agentUpdated.setAgentId(sc.nextInt());
				System.out.println("Enter FirstName  ");
				agentUpdated.setFirstName(sc.next());
				System.out.println("Enter LastName  ");
				agentUpdated.setLastName(sc.next());
				System.out.println("Enter City  ");
				agentUpdated.setCity(sc.next());
				System.out.println("Enter Paymentmode MONTHLY/QUATERLY/ANNUALLY,HALFYEARLY");
				agentUpdated.setPayMode(PayMode.valueOf(sc.next()));
				System.out.println("Enter Premium  ");
				agentUpdated.setPremium(sc.nextDouble());
				
				System.out.println(bal.updateAgentBal(agentUpdated));

					}
			
			
			public static void writeAgentFileMain() throws IOException{
				 System.out.println(bal.writeAgentFileBal());
			 }
			 public static void readAgentFileMain() throws ClassNotFoundException, IOException{
				 System.out.println(bal.readAgentFileBal());
			 }
			
}
