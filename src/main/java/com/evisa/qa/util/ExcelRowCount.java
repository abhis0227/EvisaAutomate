package com.evisa.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRowCount extends ReadGuru99ExcelFile {

	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public String xlFilePath;
	public static String path;
	static ReadGuru99ExcelFile readFile;

	public ExcelRowCount(String xlFilePath) throws Exception {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public static int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
		// int rowCount = sheet.getLastRowNum()+1;
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public static int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	// returns the data from a cell
	public static String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";
			// System.out.println(cell.getCellType());
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	// returns true if data is set successfully else false
	public static boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
//		readFile = new ReadGuru99ExcelFile();
		ExcelRowCount eat = new ExcelRowCount(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test2.xlsx");
		int colCount = eat.getColumnCount("Sheet1");
		System.out.println("Total Columns in the Excel : " + colCount);
		int rowCount = eat.getRowCount("Sheet1");
		System.out.println("Total rows in the Excel : " + rowCount);
//		// System.out.println("Total Rows in the Excel : " + rowCount);
//		// eat.readExcel(filePath, "Evisa_TestData.xlsx", "TDDetails");
//		String filePath = "C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata";
//		// readFile.readExcel(filePath, "Evisa_TestData_1.xlsx", "Apply");
//
//		//String abhi = eat.getCellData("Apply", " Gender", 2);
//		System.out.println(abhi);
//		eat.setCellData(Apply, "Application No.", 0, filePath)
//		
	}
}
