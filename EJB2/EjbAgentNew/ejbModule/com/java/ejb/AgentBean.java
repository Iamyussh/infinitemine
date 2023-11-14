package com.java.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AgentBean
 */
@Stateless
@Remote(AgentBeanRemote.class)
public class AgentBean implements AgentBeanRemote {
	@PersistenceContext(unitName = "AgentMySqlDS")
	private EntityManager entitymanager;
    /**
     * Default constructor. 
     */
    public AgentBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agent> showAgents() {
		Query query = entitymanager.createQuery("SELECT a from Agent a");
		return (List<Agent>) query.getResultList();
		
		
	}

}
