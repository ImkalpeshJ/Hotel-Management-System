package com.hotelManagement.serviceIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.CustomerDao;
import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Room;
import com.hotelManagement.model.Billing;
import com.hotelManagement.model.FoodBill;
import com.hotelManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;

	@Override
	public boolean checkIn(Customer customer) {
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
		return dao.checkIn(customer);
	}

	@Override
	public Billing getFinalBill(long id) {
		Customer customer = dao.getCustomerById(id);
		double finalBill = 0;
		String[] strArray = customer.getOrderedFood().split(",");
		ArrayList<Long> longList = new ArrayList<Long>();
		for (String s : strArray) {
			longList.add(Long.parseLong(s));
		}
		FoodBill foodBill = dao.getFoodBill(longList);
		Billing billing = new Billing();
		billing.setCustomer(customer);
		finalBill = finalBill + customer.getRoom().getRoomType().getPrice()+foodBill.getBill();
		billing.setFinalBill(finalBill);
		return billing;
	}

	@Override
	public Customer getCustomerById(long id) {
		return dao.getCustomerById(id);
	}

	@Override
	public FoodBill getFoodBill(List<Long> list) {
		return dao.getFoodBill(list);
	}

	@Override
	public boolean checkOut(long id) {
		boolean isUpdated = false;
		Customer customer = dao.getCustomerById(id);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		customer.setStatus("Checked out at " + formattedDateTime);
		isUpdated = dao.checkOut(customer);
		return isUpdated;
	}

}
