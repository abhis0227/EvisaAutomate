package com.evisa.qa.util;

//Java program to write data in excel sheet using java code 

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {

	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public String xlFilePath;
	public static String path;
	public static GetApplicationNo gv;

	public static void main(String[] args) throws Exception {

		// Create blank workbook

		File file = new File(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Evisa_TestData_1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Apply");
		XSSFRow row = sheet.getRow(0);
		System.out.println(row);
//		XSSFCell cell = sheet.getRow(1).createCell(18);
//		//XSSFCell Cell = sheet.getRow(1).getCell(18);
//		System.out.println(cell);
//		//fis = new FileInputStream(path);
		// workbook = new XSSFWorkbook(fis);

//		if (GetApplicationNo.GetVisaApp().contentEquals("100")) {
//			cell.setCellValue("100");
//		} else {
//			cell.setCellValue("FAIL");
//		}

		// FileOutputStream outputStream = new FileOutputStream(
		// "C:\\Users\\Abhishek
		// Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Evisa_TestData_1.xlsx");
		// wb.write(outputStream);
		// wb.close();
		// System.out.println("Writesheet.xlsx written successfully");
	}
}
