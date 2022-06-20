package com.evisa.qa.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evisa.qa.base.EvisaBase;

public class database_conn extends EvisaBase {

	String final_visa_status;
	String dataPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx";
	int i = 1;
	int j = 22;
	static String app;
	Xls_Reader reader;

	public String visa_app_status1() throws SQLException, IOException, ClassNotFoundException {

		// Class.forName("oracle.jdbc.driver.OracleDriver");
		reader = new Xls_Reader(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
		app = XLUtils.getCellData(dataPath, "VisaData", i, j);
		// System.out.println("App for DB con:"+app);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.100.111:1521/OMDBUAT3", "UAT_EVISA_DATA",
				"UAT_EVISA_DATA");
		Statement stmt = con.createStatement();
		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
		// String get_app_statuss = "select visa_app_status from visa_application where
		// visa_app_no='10001476014'";
		// System.out.println(get_app_statuss);
		ResultSet rs = stmt.executeQuery(get_app_statuss);
		while (rs.next()) {
			final_visa_status = rs.getString("visa_app_status");
			System.out.println(final_visa_status);
		}
		// i = i + 1;
		return final_visa_status;

	}

	 public static void main(String[] s) throws ClassNotFoundException,
	 SQLException, IOException {
		database_conn db1 = new database_conn();
		db1.visa_app_status1();
	}

};
