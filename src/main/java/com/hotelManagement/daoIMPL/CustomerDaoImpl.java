package com.hotelManagement.daoIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.dao.CustomerDao;
import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Menu;
import com.hotelManagement.entity.Room;
import com.hotelManagement.entity.StaffMember;
import com.hotelManagement.model.FoodBill;

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
	public boolean checkIn(Customer customer) {
		boolean isAdded = false;
		Session session = null;
		Room room = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			room = getRoomById(customer.getRoom().getId());
			if (room.getStatus().equals("Available")) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDateTime = now.format(formatter);
				customer.setStatus("Checked in at " + formattedDateTime);
				session.save(customer);
				transaction.commit();

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
	public FoodBill getFoodBill(List<Long> list) {
		Session session = null;
		List<Menu> menuList = new ArrayList<Menu>();
		FoodBill foodBill = new FoodBill();
		double bill = 0;
		try {
			for (Long id : list) {
				session = sf.openSession();
				Menu menu = session.get(Menu.class, id);
				menuList.add(menu);
			}

			for (Menu menu : menuList) {
				bill = bill + menu.getPrice();
			}
			foodBill.setMenu(menuList);
			foodBill.setBill(bill);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodBill;
	}

	@Override
	public boolean checkOut(Customer customer) {
		Session session = null;
		boolean isUpdated = false;
		Room room = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Customer dbCustomer = getCustomerById(customer.getId());
			room = getRoomById(customer.getRoom().getId());
			if (dbCustomer != null) {
				session.update(customer);
				transaction.commit();
			}
			room.setStatus("Available");
			updateRoom(room);
			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

}
