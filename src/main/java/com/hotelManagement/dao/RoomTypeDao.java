package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.RoomType;

public interface RoomTypeDao {

	boolean saveRoomType(RoomType type);

	RoomType getRoomTypeById(long roomTypeId);

	boolean deleteRoomType(long roomTypeId);

	List<RoomType> getAllRoomType();

}
