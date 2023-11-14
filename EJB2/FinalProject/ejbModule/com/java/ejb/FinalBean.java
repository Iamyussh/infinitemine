package com.java.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 * Session Bean implementation class InsuranceBean
 */
@Stateless
@Remote(FinalBeanRemote.class)
public class FinalBean implements FinalBeanRemote {
	
	@PersistenceContext(unitName = "finalPU")
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public FinalBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<InsuranceDetails> showInsurancedetails() {
		
		Query query = entityManager.createQuery("SELECT e FROM InsuranceDetails e");
		return (List<InsuranceDetails>) query.getResultList();
		
		
	}

}
