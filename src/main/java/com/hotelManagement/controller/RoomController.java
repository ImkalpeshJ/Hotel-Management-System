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

import com.hotelManagement.entity.Room;
import com.hotelManagement.exception.ResourceAlreadyExistsException;
import com.hotelManagement.exception.ResourceNotFoundException;
import com.hotelManagement.service.RoomService;

@RestController
@RequestMapping(value="/room")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@PostMapping(value = "/save-new-room")
	public ResponseEntity<Boolean> saveRoom(@RequestBody Room room) {
		boolean isAdded = service.saveRoom(room);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ResourceAlreadyExistsException("Resource Already Exists!");
		}
	}
	
	@GetMapping(value = "/get-room-by-id/{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable long roomId) {

		Room room = service.getRoomById(roomId);
		if (room != null) {
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@DeleteMapping(value = "/delete-a-room")
	public ResponseEntity<Boolean> deleteRoom(@RequestParam long roomId) {
		boolean isDeleted = service.deleteRoom(roomId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@GetMapping(value = "/get-all-rooms")
	public ResponseEntity<List<Room>> getAllRoom() {
		List<Room> rooms = service.getAllRoom();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/get-available-rooms")
	public ResponseEntity<List<Room>> getAvailableRooms(){
		List<Room> rooms = service.getAvailableRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-occupied-rooms")
	public ResponseEntity<List<Room>> getOccupiedRooms(){
		List<Room> rooms = service.getOccupiedRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-available-ac-rooms")
	public ResponseEntity<List<Room>> getAvailableACRooms(){
		List<Room> rooms = service.getAvailableACRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-available-non-ac-rooms")
	public ResponseEntity<List<Room>> getAvailableNonACRooms(){
		List<Room> rooms = service.getAvailableNonACRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-available-normal-rooms")
	public ResponseEntity<List<Room>> getAvailableNormalRooms(){
		List<Room> rooms = service.getAvailableNormalRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-available-deluxe-rooms")
	public ResponseEntity<List<Room>> getAvailableDeluxeRooms(){
		List<Room> rooms = service.getAvailableDeluxeRooms();
		if (rooms.isEmpty()) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}	
	}
}
