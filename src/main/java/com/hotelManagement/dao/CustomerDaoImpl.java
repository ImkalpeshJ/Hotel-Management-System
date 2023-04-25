package com.hotelManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Menu;
import com.hotelManagement.entity.Room;
import com.hotelManagement.entity.StaffMember;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Room getRoomById(long roomId) {
		Room room = null;
		Session session = null;
		try {
			session = sf.openSession();

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
	public boolean saveCustomer(Customer customer) {
		boolean isAdded = false;
		Session session = null;
		Room room = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			room = getRoomById(customer.getRoom().getId());
			if (room.getStatus().equals("Available")) {
				session.save(customer);

			}
			room.setStatus("Occupied");
			updateRoom(room);
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public void updateRoom(Room room) {
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Room dbRoom = getRoomById(room.getId());
			if (dbRoom != null) {
				session.update(room);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Customer getCustomerById(long id) {
		Session session = null;
		Customer customer = null;
		try {
			session = sf.openSession();

			customer = session.get(Customer.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return customer;
	}

	@Override
	public double getFoodBill(List<Long> list) {
		Session session = null;
		List<Menu> menuList = new ArrayList<Menu>();
		double foodBill = 0;
		try {
			for (Long id : list) {
				session = sf.openSession();
				Menu menu = session.get(Menu.class, id);
				menuList.add(menu);
			}
			
			for (Menu menu : menuList) {
				foodBill = foodBill+ menu.getPrice();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodBill;
	}

}
