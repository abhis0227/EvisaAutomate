package com.evisa.qa.util;

import java.io.IOException;
import java.util.ArrayList;

import com.evisa.qa.base.EvisaBase;

public class DataProviders extends EvisaBase {

	public static String dataPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx";

	public static String[][] getDataForUnVisa() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "VisaData"); //
		int colcount = XLUtils.getCellCount(dataPath, "VisaData", 1); //
		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "VisaData", i, j);
			}
		}
		return VisaData;
	}

	public static String[][] getDataSpoVisa() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "Sponsored_Visa"); // 1
		// System.out.println(rownum);
		int colcount = XLUtils.getCellCount(dataPath, "Sponsored_Visa", 1); // 27
		// System.out.println(colcount);

		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "Sponsored_Visa", i, j);
				// System.out.println(VisaData[i-1][j] + " ");
			}

		}
		return VisaData;
	}

	public static String[][] getDataForExtension() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "ExtendVisit");
		int colcount = XLUtils.getCellCount(dataPath, "ExtendVisit", 1);
		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "ExtendVisit", i, j);
			}
		}
		return VisaData;
	}

	public static String[][] getDataForRenew() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "RenewVisa");
		int colcount = XLUtils.getCellCount(dataPath, "RenewVisa", 1);
		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "RenewVisa", i, j);
			}
		}
		return VisaData;
	}

	public static String[][] getDataForTransferRenew() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "TransferRenewVisa");
		int colcount = XLUtils.getCellCount(dataPath, "TransferRenewVisa", 1);
		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "TransferRenewVisa", i, j);
			}
		}
		return VisaData;
	}

	public static String[][] getDataForTransferPassport() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "TransferPassport");
		int colcount = XLUtils.getCellCount(dataPath, "TransferPassport", 1);
		String VisaData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "TransferPassport", i, j);
			}
		}
		return VisaData;
	}

	public static String[][] getDataForAccredRequest() throws IOException {
		int rownum = XLUtils.getRowCount(dataPath, "AccreditationRequest");
		int colcount = XLUtils.getCellCount(dataPath, "AccreditationRequest", 1);
		String VisaData[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				VisaData[i - 1][j] = XLUtils.getCellData(dataPath, "AccreditationRequest", i, j);
			}
		}
		return VisaData;

	}

//	public static void main(String[] args) throws IOException {
//		getDataSpoVisa();
//	}

}
