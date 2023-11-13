package infinite.Agent.dashboard;

import java.sql.SQLException;
import java.util.List;



public interface AgentDAO {
	
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	String addAgent(Agent agent) throws ClassNotFoundException, SQLException;
	Agent searchAgentDao(int agentId) throws ClassNotFoundException, SQLException;
	String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException;
	String deleteAgentDao(int agentId) throws ClassNotFoundException, SQLException;
	

}
