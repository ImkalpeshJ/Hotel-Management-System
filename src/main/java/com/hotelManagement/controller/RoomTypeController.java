package com.hotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelManagement.entity.RoomType;
import com.hotelManagement.exception.ResourceAlreadyExistsException;
import com.hotelManagement.exception.ResourceNotFoundException;
import com.hotelManagement.service.RoomTypeService;

@RestController
@RequestMapping(value="/room-type")
public class RoomTypeController {
	
	@Autowired
	private RoomTypeService service;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Boolean> saveRoomType(@RequestBody RoomType type) {
		boolean isAdded = service.saveRoomType(type);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ResourceAlreadyExistsException("Resource Already Exists!");
		}
	}
	
	@GetMapping(value = "/get-roomType-by-id/{roomTypeId}")
	public ResponseEntity<RoomType> getRoomTypeById(@PathVariable long roomTypeId) {

		RoomType roomType = service.getRoomTypeById(roomTypeId);
		if (roomType != null) {
			return new ResponseEntity<RoomType>(roomType, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Boolean> deleteRoomType(@RequestParam long roomTypeId) {
		boolean isDeleted = service.deleteRoomType(roomTypeId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@GetMapping(value = "/get-all")
	public ResponseEntity<List<RoomType>> getAllRoomType() {
		List<RoomType> roomTypes = service.getAllRoomType();
		if (roomTypes.isEmpty()) {
			return new ResponseEntity<List<RoomType>>(roomTypes, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<RoomType>>(roomTypes, HttpStatus.OK);
		}
	}
}
