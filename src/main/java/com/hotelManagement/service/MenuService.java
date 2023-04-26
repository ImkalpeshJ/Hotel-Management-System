package com.hotelManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.hotelManagement.entity.Menu;

public interface MenuService {

	Map<String, Object> uploadSheet(MultipartFile file);

	List<Menu> getMenu();

	List<Menu> getMenuAsc();

}
