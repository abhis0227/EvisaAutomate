package others;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.testcases.ApplyVisaTest;
//import com.evisa.qa.testcases.ApprovedVisaFlow_E2E;
import com.evisa.qa.util.XLUtils;
import com.evisa.qa.util.Xls_Reader;

public class database_connection extends EvisaBase {

	static String final_visa_status;
	static String dataPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx";
	static String app;
	static Xls_Reader reader;
	// ApprovedVisaFlow_E2E test1;

	public static String Sponsored_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {

		// Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			reader = new Xls_Reader(
					"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		app = XLUtils.getCellData(dataPath, "Sponsored_Visa", ApplyVisaTest.p, ApplyVisaTest.q);

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.70.120:1521/ROPSIT1", "P3_EVISA_DATA",
				"P3_EVISA_DATA"); // SIT4
		Statement stmt = con.createStatement();
		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
		ResultSet rs = stmt.executeQuery(get_app_statuss);
		while (rs.next()) {
			final_visa_status = rs.getString("visa_app_status");

		}

		return final_visa_status;

	}
//
//	public String Unsp_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {
//
//		// Class.forName("oracle.jdbc.driver.OracleDriver");
//		reader = new Xls_Reader(
//				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
//		app = XLUtils.getCellData(dataPath, "ExtendVisit", Extend_Visa_Test.p, Extend_Visa_Test.q);
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.40.120:1521/ROPSIT1", "P4NT_EVISA_DATA",
//				"P4NT_EVISA_DATA");
//		Statement stmt = con.createStatement();
//		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
//		// String get_app_statuss = "select visa_app_status from visa_application where
//		// visa_app_no='10001476014'";
//		// System.out.println(get_app_statuss);
//		ResultSet rs = stmt.executeQuery(get_app_statuss);
//		while (rs.next()) {
//			final_visa_status = rs.getString("visa_app_status");
//			// System.out.println(final_visa_status);
//		}
//
//		return final_visa_status;
//
//	}
//
//	public String Extend_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {
//
//		// Class.forName("oracle.jdbc.driver.OracleDriver");
//		reader = new Xls_Reader(
//				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
//		app = XLUtils.getCellData(dataPath, "ExtendVisit", Extend_Visa_Test.p, Extend_Visa_Test.q);
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.40.120:1521/ROPSIT1", "P4NT_EVISA_DATA",
//				"P4NT_EVISA_DATA");
//		Statement stmt = con.createStatement();
//		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
//		// String get_app_statuss = "select visa_app_status from visa_application where
//		// visa_app_no='10001476014'";
//		// System.out.println(get_app_statuss);
//		ResultSet rs = stmt.executeQuery(get_app_statuss);
//		while (rs.next()) {
//			final_visa_status = rs.getString("visa_app_status");
//			// System.out.println(final_visa_status);
//		}
//
//		return final_visa_status;
//
//	}
//
//	public String Renew_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {
//
//		// Class.forName("oracle.jdbc.driver.OracleDriver");
//		reader = new Xls_Reader(
//				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
//		app = XLUtils.getCellData(dataPath, "RenewVisa", Renew_Visa_Test.p, Renew_Visa_Test.q);
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.40.120:1521/ROPSIT1", "P4NT_EVISA_DATA",
//				"P4NT_EVISA_DATA");
//		Statement stmt = con.createStatement();
//		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
//		// String get_app_statuss = "select visa_app_status from visa_application where
//		// visa_app_no='10001476014'";
//		// System.out.println(get_app_statuss);
//		ResultSet rs = stmt.executeQuery(get_app_statuss);
//		while (rs.next()) {
//			final_visa_status = rs.getString("visa_app_status");
//			// System.out.println(final_visa_status);
//		}
//
//		return final_visa_status;
//
//	}
//
//	public String TransferRenew_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {
//
//		// Class.forName("oracle.jdbc.driver.OracleDriver");
//		reader = new Xls_Reader(
//				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
//		app = XLUtils.getCellData(dataPath, "TransferRenewVisa", TransferRenewTest.p, TransferRenewTest.q);
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.40.120:1521/ROPSIT1", "P4NT_EVISA_DATA",
//				"P4NT_EVISA_DATA");
//		Statement stmt = con.createStatement();
//		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
//		// String get_app_statuss = "select visa_app_status from visa_application where
//		// visa_app_no='10001476014'";
//		// System.out.println(get_app_statuss);
//		ResultSet rs = stmt.executeQuery(get_app_statuss);
//		while (rs.next()) {
//			final_visa_status = rs.getString("visa_app_status");
//			// System.out.println(final_visa_status);
//		}
//
//		return final_visa_status;
//
//	}
//
//	public String TransferPassport_visa_app_status1() throws SQLException, IOException, ClassNotFoundException {
//
//		// Class.forName("oracle.jdbc.driver.OracleDriver");
//		reader = new Xls_Reader(
//				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test21.xlsx");
//		app = XLUtils.getCellData(dataPath, "TransferPassport", TransferPassportTest.p, TransferPassportTest.q);
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.38.40.120:1521/ROPSIT1", "P4NT_EVISA_DATA",
//				"P4NT_EVISA_DATA");
//		Statement stmt = con.createStatement();
//		String get_app_statuss = "select visa_app_status from visa_application where visa_app_no='" + app + "'";
//		// String get_app_statuss = "select visa_app_status from visa_application where
//		// visa_app_no='10001476014'";
//		// System.out.println(get_app_statuss);
//		ResultSet rs = stmt.executeQuery(get_app_statuss);
//		while (rs.next()) {
//			final_visa_status = rs.getString("visa_app_status");
//			// System.out.println(final_visa_status);
//		}
//
//		return final_visa_status;
//
//	}

//	public static void main(String[] s) throws ClassNotFoundException, SQLException, IOException {
//		database_connection db1 = new database_connection();
//		System.out.println(db1.Sponsored_visa_app_status1());
//	}

};
