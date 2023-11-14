package com.java.hms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoomDAOImpl implements RoomDAO {

	
	SessionFactory sf;
	Session session;
	
	@Override
	public List<Room> ShowRoomDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		List<Room> roomList = cr.list();
		return roomList;
	}

}
