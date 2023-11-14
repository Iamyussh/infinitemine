package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface RoommasterDAO {
	
	List<String >showroomtypedao() throws ClassNotFoundException, SQLException;

	List<String> showRoomNoDao(String roomType) throws ClassNotFoundException, SQLException;

}
