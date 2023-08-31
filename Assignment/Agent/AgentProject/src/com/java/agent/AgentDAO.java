package com.java.agent;

import java.io.IOException;
import java.util.List;

public interface AgentDAO {
	
	List<Agent> showAgentDao();
	String addAgent(Agent agent);
	Agent searchAgentDao(int agentId);
	String deleteAgentDao(int agentId);
	String updateAgentDao(Agent agentUpdated);
	String writeAgentFileDao() throws IOException;
	String readAgentFiledao() throws ClassNotFoundException, IOException;
	

}
