package com.hotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.exception.ResourceAlreadyExistsException;
import com.hotelManagement.exception.ResourceNotFoundException;
import com.hotelManagement.model.Billing;
import com.hotelManagement.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Boolean> saveCustomer(@RequestBody Customer customer) {
		boolean isAdded = service.saveCustomer(customer);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ResourceAlreadyExistsException("This Room i Occupied!");
		}
	}
	
	@GetMapping(value = "/get-customer-by-id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {

		Customer customer = service.getCustomerById(id);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}
	
	@GetMapping(value = "/get-final/{customerId}")
	public ResponseEntity<Billing> getFinalBill(@PathVariable Long id) {
		Billing billing = service.getFinalBill(id);
		if (!(billing == null)) {
			return new ResponseEntity<Billing>(billing, HttpStatus.OK);
		} else {
			return new ResponseEntity<Billing>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping(value="/get-food-bill")
	public ResponseEntity<Double> getFoodBill(@RequestBody List<Long> list){
		double foodBill = (Double)service.getFoodBill(list);
		return new ResponseEntity<Double>(foodBill, HttpStatus.OK);
	}
}
