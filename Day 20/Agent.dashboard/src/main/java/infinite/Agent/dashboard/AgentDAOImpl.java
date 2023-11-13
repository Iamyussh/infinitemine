package infinite.Agent.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






public class AgentDAOImpl implements AgentDAO {
	
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException,SQLException{
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()) {
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentId"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaritalstatus(rs.getInt("maritalstatus"));
			agent.setPremium(rs.getDouble("premium"));
			
			agentList.add(agent);
		}
		return agentList;
		
		
	}

	@Override
	public String addAgent(Agent agent) throws ClassNotFoundException,SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into agent(agentId,name,city,gender,maritalstatus,premium) "
         		+ " values(?,?,?,?,?,?)";
		 PreparedStatement pst = connection.prepareStatement(cmd);
         pst.setInt(1, agent.getAgentId());
         pst.setString(2, agent.getName());
         pst.setString(3, agent.getCity());
         pst.setString(4, agent.getGender().toString());
         pst.setInt(5, agent.getMaritalstatus());
         pst.setDouble(6, agent.getPremium());
         pst.executeUpdate();
         return "Agent is added...";
		
	}

	
	
	@Override
	public Agent searchAgentDao(int agentId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Agent where agentId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		if (rs.next()) {
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentId"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaritalstatus(rs.getInt("maritalstatus"));
			agent.setPremium(rs.getDouble("premium"));
		}
		return agent;
	}
		
	
	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		Agent agentFound = searchAgentDao(agentNew.getAgentId());
		if (agentFound!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Agent set agentID=?, name=?, city=?, gender=?, maritalstatus=?, premium=? Where "
					+ " agentID=?";
			pst = connection.prepareStatement(cmd);
			
			pst.setInt(1, agentNew.getAgentId());
			pst.setString(2, agentNew.getName());
			pst.setString(3, agentNew.getCity());
			pst.setString(4, agentNew.getGender().toString());
			pst.setInt(5, agentNew.getMaritalstatus());
			pst.setDouble(6, agentNew.getPremium());
			pst.setInt(7, agentNew.getAgentId());
			
			pst.executeUpdate();
			return "Agent Record Updated...";
		}
		return "Agent Record Not Found...";
	
	
	
	
	}

	
		@Override
		public String deleteAgentDao(int agentId) throws ClassNotFoundException, SQLException {
			
				connection = ConnectionHelper.getConnection();
				String cmd = "Delete from Agent where agentId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, agentId);
				pst.executeUpdate();
				return "Agent Record Deleted...";
			
			
		
		
	}

	
	
	
}
