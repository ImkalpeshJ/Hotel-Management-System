package com.hotelManagement.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.entity.RoomType;

@Repository
public class RoomTypeDaoImpl implements RoomTypeDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean saveRoomType(RoomType type) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(type);
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
	public RoomType getRoomTypeById(long roomTypeId) {
		RoomType roomType = null;
		Session session = null;
		try {
			session = factory.openSession();

			roomType = session.get(RoomType.class, roomTypeId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return roomType;
	}
	

	@Override
	public boolean deleteRoomType(long roomTypeId) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			RoomType roomType = session.get(RoomType.class, roomTypeId);
			if (roomType != null) {
				session.delete(roomType);
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
	public List<RoomType> getAllRoomType() {
		Session session = null;
		List<RoomType> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(RoomType.class);
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
