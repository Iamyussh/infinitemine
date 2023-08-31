package com.java.agent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImpl implements AgentDAO {

	static List<Agent> agentList;

	static {
		agentList = new ArrayList<Agent>();
	}
	@Override
	public List<Agent> showAgentDao() {
		// TODO Auto-generated method stub
		return agentList;
	}
	
	
	
	private int generateAgentId() {
		if (agentList.size()==0) {
			return 1;
		} else {
			return agentList.get(agentList.size()-1).getAgentId() +1;
		}
	}

	@Override
	public String addAgent(Agent agent) {
		int id = generateAgentId();
		agent.setAgentId(id);                                                                                              
		// TODO Auto-generated method stub
		agentList.add(agent);
		return "agent is added";
	}



	@Override
	public Agent searchAgentDao(int agentId) {
		// TODO Auto-generated method stub
		Agent agentFound = null;
		for(Agent agent : agentList){
			
		
		if(agent.getAgentId()==agentId){
			agentFound  =agent;
			break;
		}
}
		
		return agentFound;
	}



	@Override
	public String deleteAgentDao(int agentId) {
		// TODO Auto-generated method stub
		Agent agentFound = searchAgentDao(agentId);
		if(agentFound!=null){
			agentList.remove(agentFound);
			return "Agent Record Deleted...";
		}
		return "Agent Record Not Found";
	}



	@Override
	public String updateAgentDao(Agent agentUpdated) {
		// TODO Auto-generated method stub
		Agent agentFound = searchAgentDao(agentUpdated.getAgentId());
		if(agentFound!=null){
			for(Agent agent : agentList){
				if(agent.getAgentId() == agentUpdated.getAgentId()){
					agent.setFirstName(agentUpdated.getFirstName());
					agent.setLastName(agentUpdated.getLastName());
					agent.setCity(agentUpdated.getCity());
					agent.setPayMode(agentUpdated.getPayMode());
					agent.setPremium(agentUpdated.getPremium());
					break;
				}
				
			}
			return "agent Record Updated ..";
		}
		return "agent Record not Found ...";
	}



	@Override
	public String writeAgentFileDao() throws IOException   {
		// TODO Auto-generated method stub

		FileOutputStream  fout = 
				new FileOutputStream("D:/files/AgentProject.txt");
		
		ObjectOutputStream objout  = new ObjectOutputStream(fout);
		objout.writeObject(agentList);
		objout.close();
		fout.close();
		return "*** Data Stored in File";
	}



	@Override
	public String readAgentFiledao() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream  fin = 
				new FileInputStream("D:/files/AgentProject.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		agentList = (List<Agent>)objin.readObject();
		objin.close();
		fin.close();
		return "Data Retrieved From File";
	}

}
