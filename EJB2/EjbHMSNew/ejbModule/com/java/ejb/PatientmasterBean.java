package com.java.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PatientmasterBean
 */
@Stateless
@Remote(PatientmasterBeanRemote.class)
public class PatientmasterBean implements PatientmasterBeanRemote {
	
	@PersistenceContext(unitName = "HmsPU")
	private EntityManager entitymanager;

    /**
     * Default constructor. 
     */
    public PatientmasterBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Patientmaster> showPatients() {
		Query query = entitymanager.createQuery("SELECT e from Patientmaster e");
		return (List<Patientmaster>) query.getResultList();
	}

	@Override
	public String addPatientReport(PatientReport report) {
			entitymanager.persist(report);
		
		
		return "Report added successfully...";
	}

}
