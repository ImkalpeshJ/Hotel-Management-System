package com.hotelManagement.model;

import java.util.List;

import com.hotelManagement.entity.Customer;
import com.hotelManagement.entity.Menu;
import com.hotelManagement.entity.Room;

public class Billing {
	
	private Customer customer;
	private double foodBill;
	private double finalBill;
	
	public Billing() {
		// TODO Auto-generated constructor stub
	}

	public Billing(Customer customer, double foodBill, double finalBill) {
		super();
		this.customer = customer;
		this.foodBill = foodBill;
		this.finalBill = finalBill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getFoodBill() {
		return foodBill;
	}

	public void setFoodBill(double foodBill) {
		this.foodBill = foodBill;
	}

	public double getFinalBill() {
		return finalBill;
	}

	public void setFinalBill(double finalBill) {
		this.finalBill = finalBill;
	}

	@Override
	public String toString() {
		return "Billing [customer=" + customer + ", foodBill=" + foodBill + ", finalBill=" + finalBill + "]";
	}


}
