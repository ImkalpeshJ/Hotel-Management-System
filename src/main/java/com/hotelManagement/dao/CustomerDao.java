package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Room;

public interface CustomerDao {

	public Room getRoomById(long roomId);
	boolean saveCustomer(Customer customer);
	public void updateRoom(Room room);
	public Customer getCustomerById(long id);
	public double getFoodBill(List<Long> list);

}
