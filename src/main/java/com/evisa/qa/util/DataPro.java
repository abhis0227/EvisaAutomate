package com.evisa.qa.util;

import java.util.ArrayList;

import com.evisa.qa.base.EvisaBase;

public class DataPro {

	static DataPro dp;
	static Xls_Reader reader;
	static String datapath = "C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Evisa_TestData_1.xlsx";

//	public DataPro() {
//		super();
//	}

	public static ArrayList<Object[]> method() {
		ArrayList<Object[]> myData1 = new ArrayList<Object[]>();

		int rowCount = reader.getRowCount("Evisa_TestData_1");
		// Object obj1[][]= new Object[rowCount][17];
		for (int i = 0; i < rowCount; i++)
			for (int j = 0; j < 17; j++) {
				Object obj1[][] = { { reader.getCellData("Evisa_TestData_1", j, i) } };
				// System.out.println(obj1);
				myData1.add(obj1);
				// myData = dp.getCellData("Test2", j, i);
			}
		// System.out.println(myData);
		return myData1;
	}

	public static void main(String[] args) {

		reader = new Xls_Reader(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Evisa_TestData_1.xlsx");
		dp = new DataPro();
		dp.method();
	}

};
