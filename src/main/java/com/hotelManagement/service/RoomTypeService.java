package com.hotelManagement.service;

import java.util.List;

import com.hotelManagement.entity.RoomType;

public interface RoomTypeService {

	boolean saveRoomType(RoomType type);

	RoomType getRoomTypeById(long roomTypeId);

	boolean deleteRoomType(long roomTypeId);

	List<RoomType> getAllRoomType();

}
