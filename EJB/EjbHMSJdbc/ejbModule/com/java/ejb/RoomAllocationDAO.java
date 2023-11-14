package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface RoomAllocationDAO {
	List<String> showroomtypeDao() throws ClassNotFoundException, SQLException;
		
}
