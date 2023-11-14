package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

public class EjbImpl {
		
	public List<Agent> showAgentsEjb() throws NamingException{
		AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessPatient();
		return remote.showAgents();
	}
}
