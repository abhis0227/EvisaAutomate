package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.AdditionalDetailsPage;
import com.evisa.qa.pages.ApplicantionSummaryPage;
import com.evisa.qa.pages.CheckDocsQueue;
import com.evisa.qa.pages.ConfirmDetailPage;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.pages.Required_DocumentPage;
import com.evisa.qa.pages.SubmissionSummaryPage;
import com.evisa.qa.pages.TravelDocPage;
import com.evisa.qa.pages.VerifyPersonQueue;
import com.evisa.qa.pages.VisaEligiWizard;
import com.evisa.qa.pages.VisaSelectPage;
import com.evisa.qa.util.DataProviders;
import com.evisa.qa.util.GetApplicationNo;
import com.evisa.qa.util.XLUtils;
import com.evisa.qa.util.Xls_Reader;
import com.evisa.qa.util.database_conn;
import com.vis.qa.pages.IDEPage;
import com.vis.qa.pages.RL1_HomePage;
import com.vis.qa.pages.RL1_Login;

public class DGPR_Login_Test extends EvisaBase {

	public static int i = 1;
	public static int j = 22;
	public static String applicationNumber;
	String appno;
	static String final_visa_status;
	static int int_visa_status;
	LoginPage loginPage;
	HomePage homepage;
	VisaEligiWizard ve;
	VisaSelectPage vs;
	TravelDocPage TD;
	AdditionalDetailsPage ad;
	Required_DocumentPage rd;
	ConfirmDetailPage cd;
	ApplicantionSummaryPage as;
	SubmissionSummaryPage ss;
	Xls_Reader reader;
	DGPR_Login_Test dgpr_login_test;
	DGPR_LoginPage loginPage_dgpr;
	DGPR_HomePage homepage_dgpr;
	CheckDocsQueue cdocs;
	// database_conn dbcon1;
	database_connection dbcon;
	VerifyPersonQueue vp;
	RL1_Login rl1;
	RL1_HomePage vis_homepage;
	IDEPage ide;

	public DGPR_Login_Test() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		// ve = new VisaEligiWizard();
		// loginPage = loginPage.ClickAdvance();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		ve = new VisaEligiWizard();
		ve = homepage.ApplyUnspVisa();
	}

	@Test(dataProvider = "Unsp_Visa")
	public void applyVisa(String Nationality, String GCC, String Visa_SubType, String Document_Nationality,
			String TD_Number, String TD_Type, String Issue_Date, String Expiry_Date, String Place_of_Issue,
			String Full_Name, String Given_Name, String Family_Name, String Gender, String DOB, String COB, String POB,
			String MOTHER_NAME, String GCC_Occupation, String MARITAL_STATUS, String Nati, String Relship, String TDNO)
			throws InterruptedException, IOException, SQLException, ClassNotFoundException {

		vs = new VisaSelectPage();
		vs = ve.SelectNationality(Nationality, GCC);
		TD = new TravelDocPage();
		TD = vs.ClickVisa(Visa_SubType);
		ad = new AdditionalDetailsPage();
		ad = TD.TDDetails(Nationality, Document_Nationality, TD_Number, TD_Type, Issue_Date, Expiry_Date,
				Place_of_Issue, Full_Name, Given_Name, Family_Name, Gender, DOB, COB, POB);

		rd = new Required_DocumentPage();
		rd = ad.AdditionalDetPage(MOTHER_NAME, GCC_Occupation, MARITAL_STATUS, Nati, Relship, TDNO);
		cd = new ConfirmDetailPage();
		cd = rd.UploadDocsPage();
		as = new ApplicantionSummaryPage();
		as = cd.confirmdetailspage();
		ss = new SubmissionSummaryPage();
		ss = as.SubmitPay();
		// driver.navigate().refresh();
		applicationNumber = GetApplicationNo.GetVisaApp();
		System.out.println(applicationNumber);
		System.out.println("value of i in test :" + i);
		System.out.println("value of j in test :" + j);
		XLUtils.setcellData(DataProviders.dataPath, "VisaData", i, j, applicationNumber);
		appno = XLUtils.getCellData(DataProviders.dataPath, "VisaData", i, j);
		System.out.println(appno);
		dgpr_login_test = new DGPR_Login_Test();
		initialization_dgpr();
		loginPage_dgpr = new DGPR_LoginPage();
		homepage_dgpr = loginPage_dgpr.login_dgpr(Prop.getProperty("username_dgpr"), Prop.getProperty("password_dgpr"));
		// loginPage_dgpr = loginPage_dgpr.ClickAdvance_dgpr();
		for (int k = 1; k <= 25; k++) {
			dbcon = new database_connection();
			final_visa_status = dbcon.Unsp_visa_app_status1();
			int_visa_status = Integer.parseInt(final_visa_status);
			System.out.println("Checking initial Visa App Status After Submission: " + int_visa_status);
			Thread.sleep(2000);
			if (int_visa_status == 12) {
				cdocs = new CheckDocsQueue();
				cdocs.clickCheckDoclink();
				cdocs.EnterVisaApp(appno);
				Thread.sleep(2000);
				cdocs.ClickVisaApp(appno);
				Thread.sleep(4000);
				cdocs.VetDocuments();
				break;
			}
		}

		if (int_visa_status == 3) {
			System.out.println("Visa App is still in status 3, Exit Test");
			i = i + 1;
			System.out.println("value of i is :" + i);
			System.out.println("value of j is :" + j);
		} else {

			for (int k = 1; k <= 15; k++) {
				dbcon = new database_connection();
				final_visa_status = dbcon.Unsp_visa_app_status1();
				int_visa_status = Integer.parseInt(final_visa_status);
				System.out.println("Checking Visa App Status After Docs Check:" + int_visa_status);
				Thread.sleep(2000);
				if (int_visa_status == 16) {
					System.out.println("Application is in verify Queue");
					vp = new VerifyPersonQueue();
					vp.Clear_Verify(appno);

				} else if (int_visa_status == 20) {
					System.out.println("Application is in Immigration queue");

				} else if (int_visa_status == 24) {
					System.out.println("Application is in Security queue");
				}

				else if (int_visa_status == 31) {
					System.out.println("Application got Approved");
					break;
				}

				else if (int_visa_status == 34) {
					System.out.println("Visa Went to RL1: Exit and Login to VIS RL1");
					break;
				}
			}
			if (int_visa_status == 26) {
				System.out.println("Visa app stuck in security queue");

			}
//			if (int_visa_status == 34) {
//				RL1VIS_Login();
//				rl1 = new RL1_Login();
//				rl1.RL1_Login1(Prop.getProperty("vis_user"), Prop.getProperty("vis_pass"));
//				vis_homepage = new RL1_HomePage();
//				vis_homepage.ClickVisaSearch(appno);
//				ide = new IDEPage();
//				ide.TakeVisaAppDecision(appno);
//			}
			i = i + 1;
			System.out.println("value of i is :" + i);
			System.out.println("value of j is :" + j);
		}

	}

	@DataProvider(name = "Unsp_Visa")
	public String[][] DataForUnVisa() throws IOException {
		String[][] Unsp_VisaData = DataProviders.getDataForUnVisa();
		return Unsp_VisaData;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

};
