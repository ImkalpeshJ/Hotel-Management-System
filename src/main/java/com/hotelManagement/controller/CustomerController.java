package com.hotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.exception.ResourceAlreadyExistsException;
import com.hotelManagement.exception.ResourceNotFoundException;
import com.hotelManagement.model.Billing;
import com.hotelManagement.model.FoodBill;
import com.hotelManagement.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping(value = "/check-in")
	public ResponseEntity<Boolean> checkIn(@RequestBody Customer customer) {
		boolean isAdded = service.checkIn(customer);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ResourceAlreadyExistsException("This Room i Occupied!");
		}
	}
	
	@PutMapping(value = "/check-out")
	public ResponseEntity<Boolean> checkOut(@RequestParam long id) {
		boolean isUpdated = service.checkOut(id);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}
	
	@PutMapping(value = "/add-food-order")
	public ResponseEntity<Boolean> addOrder(@RequestParam long id, String order) {
		boolean isUpdated = service.addOrder(id, order);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}
	
	@GetMapping(value = "/get-customer-by-id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

		Customer customer = service.getCustomerById(id);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}
	
	@GetMapping(value = "/get-final-bill/{customerId}")
	public ResponseEntity<Billing> getFinalBill(@PathVariable Long customerId) {
		Billing billing = service.getFinalBill(customerId);
		if (!(billing == null)) {
			return new ResponseEntity<Billing>(billing, HttpStatus.OK);
		} else {
			return new ResponseEntity<Billing>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping(value="/get-food-bill")
	public ResponseEntity<FoodBill> getFoodBill(@RequestBody List<Long> list){
		FoodBill foodBill = service.getFoodBill(list);
		return new ResponseEntity<FoodBill>(foodBill, HttpStatus.OK);
	}
}
