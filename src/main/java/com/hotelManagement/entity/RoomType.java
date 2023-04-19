package com.hotelManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "roomtype")
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long typeId;

	@Column(unique = true)
	private String typeName;

	@Column(nullable = false)
	private double price;

	public RoomType() {
		// TODO Auto-generated constructor stub
	}

	public RoomType(Long typeId, String typeName, double price) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.price = price;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RoomType [typeId=" + typeId + ", typeName=" + typeName + ", price=" + price + "]";
	}
	
}
