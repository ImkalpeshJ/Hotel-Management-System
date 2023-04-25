package com.hotelManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private Long id;
	
	private String name;
	
	@OneToOne
	private Room room;
	
	@OneToOne
	private StaffMember member;
	
	private String status;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String name, Room room, StaffMember member, String status) {
		super();
		this.id = id;
		this.name = name;
		this.room = room;
		this.member = member;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public StaffMember getMember() {
		return member;
	}

	public void setMember(StaffMember member) {
		this.member = member;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

		
}
