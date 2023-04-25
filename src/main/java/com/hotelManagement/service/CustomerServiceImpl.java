package com.hotelManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.CustomerDao;
import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Room;
import com.hotelManagement.model.Billing;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;

	@Override
	public boolean saveCustomer(Customer customer) {
//		Room room = dao.getRoomById(customer.getRoom().getId());
//		boolean isAdded = false;
//		if (room.getStatus().equals("Available")) {
//			isAdded =  dao.saveCustomer(customer);
//		}else {
//			return false;
//		}
//		room.setStatus("Occupied");
//		dao.updateRoom(room);
//		return isAdded;
		return dao.saveCustomer(customer);
	}

	@Override
	public Billing getFinalBill(Long id) {
		Customer customer = dao.getCustomerById(id);
		Billing billing = new Billing();
		billing.setCustomer(customer);
		return null;
	}

	@Override
	public Customer getCustomerById(long id) {
		return dao.getCustomerById(id);
	}

	@Override
	public double getFoodBill(List<Long> list) {
		return dao.getFoodBill(list);
	}
	
	

}
