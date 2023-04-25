package com.hotelManagement.model;

import java.util.List;

import com.hotelManagement.entity.Menu;

public class FoodBill {

	private List<Menu> menu;
	private double bill;

	public FoodBill() {
		// TODO Auto-generated constructor stub
	}

	public FoodBill(List<Menu> menu, double bill) {
		super();
		this.menu = menu;
		this.bill = bill;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	
}
