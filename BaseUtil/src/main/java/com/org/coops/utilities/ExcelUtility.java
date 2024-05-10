package com.org.coops.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static final Logger s_logger = LogManager.getLogger(ExcelUtility.class);
	public static Object[][] getExcelData(String fileName, String sheetName, String methodName) {
		Object data[][] = null;
		List<List<Object>> methodData = new ArrayList<>();
		s_logger.info("Loading the Excel sheet :: " + sheetName);
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			try (XSSFWorkbook wb = new XSSFWorkbook(fileInputStream)) {
				XSSFSheet sheet = wb.getSheet(sheetName);
				XSSFRow row = sheet.getRow(0);
				Cell cell = null;
				for(int i = 0; i <= sheet.getLastRowNum(); i++) {
					List<Object> rowData = new ArrayList<>();
					row = sheet.getRow(i);
					if(methodName.equals(row.getCell(0).getStringCellValue())) {
						for(int j = 1; j < row.getLastCellNum(); j++) {
							DataFormatter formatter = new DataFormatter();
							cell = row.getCell(j);
							rowData.add(formatter.formatCellValue(cell));
						}
						methodData.add(rowData);
					}
				}
			}
			data = methodData.stream().map(u -> u.toArray(new Object[0])).toArray(Object[][]::new);
		} catch (Exception e) {
			s_logger.error("The Exception is :: " + e.getMessage());
		}
		return data;
	}
}
