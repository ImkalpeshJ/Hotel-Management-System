package com.hotelManagement.service;

import java.util.List;

import com.hotelManagement.entity.Room;

public interface RoomService {

	boolean saveRoom(Room room);

	Room getRoomById(long roomId);

	boolean deleteRoom(long roomId);

	List<Room> getAllRoom();


}
