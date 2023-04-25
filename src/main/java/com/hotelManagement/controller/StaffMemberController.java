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

import com.hotelManagement.entity.StaffMember;
import com.hotelManagement.service.StaffMemberService;
import com.hotelManagement.exception.ResourceAlreadyExistsException;
import com.hotelManagement.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/staff-member")
public class StaffMemberController {

	@Autowired
	private StaffMemberService service;

	@PostMapping(value = "/new-staff")
	public ResponseEntity<Boolean> saveStaff(@RequestBody StaffMember member) {
		boolean isAdded = service.saveStaff(member);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ResourceAlreadyExistsException("Resource Already Exists!");
		}
	}

	@GetMapping(value = "/get-staffMember-by-id/{staffMemberId}")
	public ResponseEntity<StaffMember> getStaffById(@PathVariable long staffMemberId) {

		StaffMember staffMember = service.getStaffById(staffMemberId);
		if (staffMember != null) {
			return new ResponseEntity<StaffMember>(staffMember, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@DeleteMapping(value = "/delete-staff-member")
	public ResponseEntity<Boolean> deleteStaffMember(@RequestParam long staffMemberId) {
		boolean isDeleted = service.deleteStaffMember(staffMemberId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@PutMapping(value = "/update-staff-member")
	public ResponseEntity<Boolean> updateStaff(@RequestBody StaffMember staffMember) {
		boolean isUpdated = service.updateStaff(staffMember);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource not found!");
		}
	}

	@GetMapping(value = "/get-all-staff-members")
	public ResponseEntity<List<StaffMember>> getAllStaff() {
		List<StaffMember> staffMembers = service.getAllStaff();
		if (staffMembers.isEmpty()) {
			return new ResponseEntity<List<StaffMember>>(staffMembers, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<StaffMember>>(staffMembers, HttpStatus.OK);
		}
	}

}
