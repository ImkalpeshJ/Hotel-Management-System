package com.hotelManagement.service;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.model.Billing;
import com.hotelManagement.model.FoodBill;

public interface CustomerService {

	boolean checkIn(Customer customer);

	Billing getFinalBill(long id);

	Customer getCustomerById(long id);

	FoodBill getFoodBill(List<Long> list);

	boolean checkOut(long id);

	boolean addOrder(long id, String order);

}
