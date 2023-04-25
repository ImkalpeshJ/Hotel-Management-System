package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Room;
import com.hotelManagement.model.FoodBill;

public interface CustomerDao {

	public Room getRoomById(long roomId);
	boolean checkIn(Customer customer);
	public void updateRoom(Room room);
	public Customer getCustomerById(long id);
	public FoodBill getFoodBill(List<Long> list);
	public boolean checkOut(Customer customer);

}
