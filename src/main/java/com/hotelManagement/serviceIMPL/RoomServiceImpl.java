package com.hotelManagement.serviceIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.RoomDao;
import com.hotelManagement.entity.Room;
import com.hotelManagement.service.RoomService;

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

	@Override
	public List<Room> getAvailableACRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (!(room.getRoomType().getTypeName().contains("Non")) && room.getStatus().equals("Available")) {
				rooms.add(room);
			}
		}
		return rooms;
	}

	@Override
	public List<Room> getAvailableNonACRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (room.getRoomType().getTypeName().contains("Non") && room.getStatus().equals("Available")) {
				rooms.add(room);
			}
		}
		return rooms;
	}

	@Override
	public List<Room> getAvailableNormalRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (room.getRoomType().getTypeName().contains("Normal") && room.getStatus().equals("Available")) {
				rooms.add(room);
			}
		}
		return rooms;
	}

	@Override
	public List<Room> getAvailableDeluxeRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (room.getRoomType().getTypeName().contains("Deluxe") && room.getStatus().equals("Available")) {
				rooms.add(room);
			}
		}
		return rooms;
	}

	@Override
	public List<Room> getOccupiedRooms() {
		List<Room> allRooms = dao.getAllRoom();
		List<Room> rooms = new ArrayList<>();
		for (Room room : allRooms) {
			if (room.getStatus().equals("Occupied")) {
				rooms.add(room);
			}

		}
		return rooms;
	}

}
