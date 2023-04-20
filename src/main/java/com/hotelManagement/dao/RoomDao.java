package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.Room;

public interface RoomDao {
	boolean saveRoom(Room room);

	Room getRoomById(long roomId);

	boolean deleteRoom(long roomId);

	List<Room> getAllRoom();

}
