package com.hotelManagement.model;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Menu;
import com.hotelManagement.entity.Room;

public class Billing {
	
	private Customer customer;
	private double finalBill;
	
	public Billing() {
		// TODO Auto-generated constructor stub
	}

	public Billing(Customer customer, double finalBill) {
		super();
		this.customer = customer;
		this.finalBill = finalBill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getFinalBill() {
		return finalBill;
	}

	public void setFinalBill(double finalBill) {
		this.finalBill = finalBill;
	}

	


}
