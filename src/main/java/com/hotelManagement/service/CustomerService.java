package com.hotelManagement.service;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.model.Billing;

public interface CustomerService {

	boolean saveCustomer(Customer customer);

	Billing getFinalBill(Long id);

	Customer getCustomerById(long id);

	double getFoodBill(List<Long> list);

}
