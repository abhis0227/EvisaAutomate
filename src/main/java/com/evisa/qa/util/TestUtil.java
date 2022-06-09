package com.evisa.qa.util;

import java.io.IOException;
import java.util.ArrayList;

import com.evisa.qa.base.EvisaBase;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPICIT_WAIT = 10;

	static ReadGuru99ExcelFile reader;
	static ExcelRowCount rowcount;

	public static ArrayList<Object[]> getDataFromExcel() throws Exception {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		reader = new ReadGuru99ExcelFile();
		rowcount = new ExcelRowCount(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test2.xlsx");

		for (int i = 2; i <= rowcount.getRowCount("Apply"); i++) {

			String nationality = rowcount.getCellData("Apply", "Nationality", i);
			String Visa_SubType = rowcount.getCellData("Apply", "Visa_SubType", i);
			String Document_Nationality = rowcount.getCellData("Apply", "Document_Nationality", i);
			String TD_Number = rowcount.getCellData("Apply", "TD_Number", i);
			String TD_Type = rowcount.getCellData("Apply", "TD_Type", i);
			String Issue_Date = rowcount.getCellData("Apply", "Issue_Date", i);
			String Expiry_Date = rowcount.getCellData("Apply", "Expiry_Date", i);
			String Place_of_Issue = rowcount.getCellData("Apply", "Place_of_Issue", i);
			String Given_Name = rowcount.getCellData("Apply", "Given_Name", i);
			String Family_Name = rowcount.getCellData("Apply", "Family_Name", i);
			String Gender = rowcount.getCellData("Apply", "Gender", i);
			String DOB = rowcount.getCellData("Apply", " DOB", i);
			String COB = rowcount.getCellData("Apply", "COB", i);
			String POB = rowcount.getCellData("Apply", "POB ", i);
			String MOTHER_NAME = rowcount.getCellData("Apply", "Mother_Name", i);
			String MARITAL_STATUS = rowcount.getCellData("Apply", "Marital_Status", i);
			// ExcelRowCount.setCellData("Apply", "Application_Number", i, Expiry_Date);

			Object obj[] = { nationality, Visa_SubType, Document_Nationality, TD_Number, TD_Type, Issue_Date,
					Expiry_Date, Place_of_Issue, Given_Name, Family_Name, Gender, DOB, COB, POB, MOTHER_NAME,
					MARITAL_STATUS };
			myData.add(obj);

		}
		return myData;

	}

};
