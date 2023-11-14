package com.java.jsf;

import java.util.List;

public interface AgentDAO {

	List<Agent> showAgentDao();

	

	String addAgentDao(Agent agent);

	String updateAgentDao(Agent agentUpdated);

	String deleteAgentDao(int agentid);



	String searchAgentDao(int agentid);



	


}
