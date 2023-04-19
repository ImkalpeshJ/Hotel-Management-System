package com.hotelManagement.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

	public ResourceAlreadyExistsException(String msg) {
		super(msg);
	}
}