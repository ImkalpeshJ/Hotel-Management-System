package com.hotelManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "number")
    private Integer number;
    
    @OneToOne
    private RoomType roomType;
    
    @Column(name = "status")
    private String status;
    
    public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(Long id, Integer number, RoomType roomType, String status) {
		super();
		this.id = id;
		this.number = number;
		this.roomType = roomType;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", roomType=" + roomType + ", status=" + status + "]";
	}
    
}
