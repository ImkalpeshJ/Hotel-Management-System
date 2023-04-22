package com.hotelManagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotelManagement.service.MenuService;

@RestController
@RequestMapping(value="/menu")
public class MenuController {
	
	@Autowired
	MenuService service;
	
	@PostMapping(value = "/import-sheet")
	public ResponseEntity<Map<String, Object>> importSheet(@RequestParam MultipartFile file) {
		Map<String, Object> map = service.uploadSheet(file);
		System.out.println(file.getOriginalFilename());
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
}
