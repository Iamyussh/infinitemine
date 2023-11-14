package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DoctorEjbBean
 */
@Stateless
@Remote(DoctorEjbBeanRemote.class)
public class DoctorEjbBean implements DoctorEjbBeanRemote {

    /**
     * Default constructor. 
     */
    public DoctorEjbBean() {
        // TODO Auto-generated constructor stub
    }
    
    static DoctorDAO daoImpl;
    
    static {
    	daoImpl = new DoctorDAOImpl();
    }

	@Override
	public List<Doctor> showDoctor() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.ShowDoctorsDao();
	}

}
