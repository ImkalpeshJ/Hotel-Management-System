package com.hotelManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.RoomTypeDao;
import com.hotelManagement.entity.RoomType;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

	@Autowired
	RoomTypeDao dao;
	
	@Override
	public boolean saveRoomType(RoomType type) {
		return dao.saveRoomType(type);
	}

	@Override
	public RoomType getRoomTypeById(long roomTypeId) {
		return dao.getRoomTypeById(roomTypeId);
	}

	@Override
	public boolean deleteRoomType(long roomTypeId) {
		return dao.deleteRoomType(roomTypeId);
	}

	@Override
	public List<RoomType> getAllRoomType() {
		return dao.getAllRoomType();
	}

}
