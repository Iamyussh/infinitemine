package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {
		
	List<Doctor>ShowDoctorsDao() throws ClassNotFoundException, SQLException;
	
	
	
}
