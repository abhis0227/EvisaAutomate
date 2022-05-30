package com.evisa.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	static String dataPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx";

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFRow row;
	public static XSSFSheet ws;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		String data;

		try {

			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {

			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setcellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fo.close();

	}

//	public static void main(String[] args) throws IOException {
//		XLUtils xlu = new XLUtils();
//		int row = XLUtils.getRowCount(dataPath, "VisaData");
//		int col = XLUtils.getCellCount(dataPath, "VisaData", 1);
//		System.out.println(row);
//		System.out.println(col);
//
//	}
};
