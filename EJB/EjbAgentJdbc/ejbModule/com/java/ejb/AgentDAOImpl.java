package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAOImpl implements AgentDAO{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * From Agent";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<Agent> Agentlist = new ArrayList<Agent>();
			Agent Agent = null;
			while(rs.next()) {
				Agent = new Agent();
				Agent.setAgentID(rs.getInt("AgentID"));
				Agent.setName(rs.getString("Name"));
				Agent.setCity(rs.getString("City"));
				Agent.setGENDER(Gender.valueOf(rs.getString("gender")));
				Agent.setMaritalStatus((rs.getInt("MaritalStatus")));
				Agent.setPremium(rs.getDouble("Premium"));
				Agentlist.add(Agent);
			}
		return Agentlist;
	}

	@Override
	public Agent searchAgentDao(int AgentID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from Agent where AgentID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, AgentID);
		ResultSet rs = pst.executeQuery();
		Agent Agent =null;
		if(rs.next()) {
			Agent = new Agent();
			Agent.setAgentID(rs.getInt("AgentID"));
			Agent.setName(rs.getString("Name"));
			Agent.setCity(rs.getString("City"));
			Agent.setGENDER(Gender.valueOf(rs.getString("gender")));
			Agent.setMaritalStatus((rs.getInt("MaritalStatus")));
			Agent.setPremium(rs.getDouble("Premium"));
		}
		
		return Agent;
	}

	@Override
	public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Agent(Name,City,GENDER,MaritalStatus,Premium)" +"VALUES (?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGENDER().toString());
		pst.setInt(4, agent.getMaritalStatus());
		pst.setDouble(5, agent.getPremium());
		
		pst.executeUpdate();
		return "Data Inserted To the Table";
	}

	@Override
	public String deleteAgentDao(int AgentID) throws ClassNotFoundException, SQLException {
		Agent agent =searchAgentDao(AgentID);
		if(agent!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from Agent where AgentID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, AgentID);
			pst.executeUpdate();
			return "Agent Record Deleated";
		}
		return "Agent Record Not Found";
		
	
	
	}

	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		Agent AgentFound = searchAgentDao(agentNew.getAgentID());
		if(AgentFound!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update Agent set name=?,City=?,GENDER=?,MaritalStatus=?,Premium=? where AgentID=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, agentNew.getName());
			pst.setString(2, agentNew.getCity());
			pst.setString(3, agentNew.getGENDER().toString());
			pst.setInt(4, agentNew.getMaritalStatus());
			pst.setDouble(5, agentNew.getPremium());
			pst.setInt(6,agentNew.getAgentID());
			pst.executeUpdate();
			return "Agent Record Updated";
			
		}
		return "Agent Record Not Found";
		
	}
}
