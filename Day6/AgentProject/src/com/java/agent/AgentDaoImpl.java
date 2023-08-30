package com.java.agent;

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

}
