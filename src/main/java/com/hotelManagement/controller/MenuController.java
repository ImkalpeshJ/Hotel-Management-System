package com.hotelManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotelManagement.entity.Menu;
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
	
	@GetMapping(value = "/get-menu")
	public ResponseEntity<List<Menu>> getMenu() {
		List<Menu> menu = service.getMenu();
		if (menu.isEmpty()) {
			return new ResponseEntity<List<Menu>>(menu, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/get-menu-price-low-to-high")
	public ResponseEntity<List<Menu>> getMenuAsc() {
		List<Menu> menu = service.getMenuAsc();
		if (menu.isEmpty()) {
			return new ResponseEntity<List<Menu>>(menu, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);
		}
	}
}
