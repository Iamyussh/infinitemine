package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class RoomAllocationDAOImpl implements RoomAllocationDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	private String roomType;
	
	
	

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}




	@Override
	public List<String> showroomtypeDao() throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select distinct room_type from room_master";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<String> roomtypeList = new ArrayList<>();
			String roomType = null;
			while(rs.next()) {
				roomType = rs.getString("room_type");
				roomtypeList.add(roomType);
			}
			
			return roomtypeList;
	}
		
	
	public void roomTypechanged(ValueChangeEvent e) {
		this.roomType = e.getNewValue().toString();
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put(roomType,this.roomType);
	}
	
	
}
