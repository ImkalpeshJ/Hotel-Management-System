package com.hotelManagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.RoomDao;
import com.hotelManagement.entity.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao dao;

	@Override
	public boolean saveRoom(Room room) {
		return dao.saveRoom(room);
	}

	@Override
	public Room getRoomById(long roomId) {
		return dao.getRoomById(roomId);
	}

	@Override
	public boolean deleteRoom(long roomId) {
		return dao.deleteRoom(roomId);
	}

	@Override
	public List<Room> getAllRoom() {
		return dao.getAllRoom();
	}

	@Override
	public List<Room> getAvailableRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (room.getStatus().equals("Available")) {
				rooms.add(room);
			}

		}
		return rooms;
	}

}
