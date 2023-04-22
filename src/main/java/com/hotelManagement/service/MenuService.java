package com.hotelManagement.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface MenuService {

	Map<String, Object> uploadSheet(MultipartFile file);

}
