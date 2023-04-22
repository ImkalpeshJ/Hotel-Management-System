package com.hotelManagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotelManagement.dao.MenuDao;
import com.hotelManagement.entity.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao dao;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	public List<Menu> readExcelSheet(String path) {
		List<Menu> list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				Row row = rows.next();
				int rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}
				Menu menu = new Menu();
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {

					Cell cell = (Cell) cells.next();
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 1:
						menu.setName(cell.getStringCellValue());
						break;
					case 2:
						menu.setPrice(cell.getNumericCellValue());
						break;
				}
			}list.add(menu);
		}
			} catch (Exception e) {

		}
		return list;
	}
	
	
	
	@Override
	public Map<String, Object> uploadSheet(MultipartFile myFile) {
		int[] arr;
		String path = "src/main/resources";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		try {
			byte[] data = myFile.getBytes();
			FileOutputStream outputStream = new FileOutputStream(
					new File(absolutePath + File.separator + myFile.getOriginalFilename()));
			outputStream.write(data);
			List<Menu> list = readExcelSheet(absolutePath + File.separator + myFile.getOriginalFilename());
			arr = dao.uploadSheet(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
