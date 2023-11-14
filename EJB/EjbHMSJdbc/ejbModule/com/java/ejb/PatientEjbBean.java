package com.java.ejb;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PatientEjbBean
 */
@Stateless
@Remote(PatientEjbBeanRemote.class)
public class PatientEjbBean implements PatientEjbBeanRemote {

    /**
     * Default constructor. 
     */
    public PatientEjbBean() {
        // TODO Auto-generated constructor stub
    }
    	
    static PatientDAO daoImpl;
    
    static {
    	daoImpl = new PatientDAOImpl();
    }

	@Override
	public String addPatient(Patient patient) throws ClassNotFoundException, SQLException {
		
			return daoImpl.addPatient(patient);
		
	}
}
