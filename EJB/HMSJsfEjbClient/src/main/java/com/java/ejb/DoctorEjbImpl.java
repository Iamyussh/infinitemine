package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public class DoctorEjbImpl {
		
	public List<Doctor> showDoctorEjb() throws NamingException,ClassNotFoundException,SQLException{
		DoctorEjbBeanRemote remote = 
				RemoteHelper.lookupRemoteStatelessDoctor();
		return remote.showDoctor();
	}
}
