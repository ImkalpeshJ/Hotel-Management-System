package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.Menu;

public interface MenuDao {

	int[] uploadSheet(List<Menu> list);

}
