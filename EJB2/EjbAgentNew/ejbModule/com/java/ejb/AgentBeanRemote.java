package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AgentBeanRemote {
	List<Agent> showAgents();
}
