package com.java.agent;

import java.util.List;

public class AgentBAL {
	static StringBuilder sb;
	static AgentDAO dao;
	
	static{
		sb =new StringBuilder();
		dao = new AgentDaoImpl();
	}
	
	public String addAgentBal(Agent agent) throws AgentException {
		if(validateAgent(agent)==true){
			return dao.addAgent(agent);
			
		}
		throw new AgentException(sb.toString());
	}
	public List<Agent>showAgentBal(){
		return dao.showAgentDao();
	}
	
	
	
	public boolean validateAgent(Agent agent){
		boolean flag= true;
	if(agent.getAgentId()<=0){
		flag = false;
	
	sb.append("Employ No Cannot be zero or negative ...\r\n");
	
}
	
	if(agent.getCity()=="Delhi"){
		flag = false;
		sb.append("Name cannot be city\r\n");
	}
	
	if(agent.getFirstName().length()<4){
		 flag=false;
		sb.append("Username first must have 4 letters minimum ...\r\n");
	}
	if(agent.getLastName().length()<4){
		 flag=false;
		sb.append("Userlast name must have  min 4 characters...\r\n");
	}
	if(agent.getPremium()<5000 || agent.getPremium()>9900){
		flag = false;
		sb.append("Premium must be between 5000 and 99000...\r\n");
	}
		return flag;		
	
	}
}
