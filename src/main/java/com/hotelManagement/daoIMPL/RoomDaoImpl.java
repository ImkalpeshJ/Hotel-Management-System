package com.hotelManagement.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.dao.RoomDao;
import com.hotelManagement.entity.Room;

@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	SessionFactory factory;
	
	
	@Override
	public boolean saveRoom(Room room) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(room);
			transaction.commit();
			isAdded = true;
		} catch (PersistenceException e) {
			isAdded = false;
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public Room getRoomById(long roomId) {
		Room room = null;
		Session session = null;
		try {
			session = factory.openSession();

			room = session.get(Room.class, roomId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return room;
	}

	@Override
	public boolean deleteRoom(long roomId) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Room room = session.get(Room.class, roomId);
			if (room != null) {
				session.delete(room);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;
	}

	@Override
	public List<Room> getAllRoom() {
		Session session = null;
		List<Room> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Room.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
