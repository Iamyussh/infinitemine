package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;



public class AgentDAOImpl implements AgentDAO{
	SessionFactory sf;
	Session session;

	@Override
	public List<Agent> showAgentDAO(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Agent");
		List<Agent> agentlist = query.list();
		return agentlist;
	}

	@Override
	public Agent searchAgentDao(int id) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Agent where agentID ="+id);
		List<Agent> agentlist = query.list();
		if(agentlist.size()>0) {
			return agentlist.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public String deleteAgentDao(int id) {
		
		Agent agentFound = searchAgentDao(id);
		if(agentFound!=null) {
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			session.delete(agentFound);
			trans.commit();
			
			return "Agent record Deleted...";
		
		}
		else {
			return "Agent not found";
		}
		
	}

	@Override
	public String addAgentDao(Agent agent) {
		sf= SessionHelper.getConnection();
		session  = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(agent);
		trans.commit();
		return "Agent Record Inserted";
	}

	@Override
	public String UpdateAgentDao(Agent agent) {
		
		Agent agentfound = searchAgentDao(agent.getAgentid());
		if(agentfound!=null) {
		sf= SessionHelper.getConnection();
		session  = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(agent);
		trans.commit();
		return "Agent Record updated";
	}
		else {
			return "Agent record not updated";
		}

	}
}
