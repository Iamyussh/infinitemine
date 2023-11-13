package com.java.hib;

import java.util.List;

public interface AgentDAO {
		List<Agent>showAgentDAO();
		Agent searchAgentDao(int id);
		String deleteAgentDao(int id);
		String addAgentDao(Agent agent);
		String UpdateAgentDao(Agent agent);
}
