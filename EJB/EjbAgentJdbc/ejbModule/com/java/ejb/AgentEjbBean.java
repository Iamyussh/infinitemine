package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AgentEjbBean
 */
@Stateless
@Remote(AgentEjbBeanRemote.class)
public class AgentEjbBean implements AgentEjbBeanRemote {

    /**
     * Default constructor. 
     */
    public AgentEjbBean() {
        
    }
    
 static AgentDAO daoImpl;
    
    static {
    	daoImpl = new AgentDAOImpl();
    }

	@Override
	public List<Agent> showAgent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showAgentDao();
	}

	@Override
	public Agent searchAgent(int agentid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.searchAgentDao(agentid);
	}

	@Override
	public String addAgent(Agent agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.addAgentDao(agent);
	}

	@Override
	public String deleteAgent(int agentid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.deleteAgentDao(agentid);
	}

	@Override
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.updateAgentDao(agent);
	}

}
