package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
import com.vis.qa.pages.IDEPage;
import com.vis.qa.pages.RL1_HomePage;
import com.vis.qa.pages.RL1_Login;

public class Sponsored_VisaTest extends EvisaBase {

	public static int p = 1;
	public static int q = 27;
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

	public Sponsored_VisaTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		// ve = new VisaEligiWizard();
		// loginPage = loginPage.ClickAdvance();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		vs = homepage.ApplySpVisa();

	}

	@Test(dataProvider = "Sp_Visa")
	public void ApplyVisa_Sponsored(String Sponsor_CR, String Visa_Type, String Visa_Subtype, String Nationality,
			String Document_Nationality, String TD_Number, String TD_Type, String Issue_Date, String Expiry_Date,
			String Place_of_Issue, String Full_Name, String Given_Name, String Family_Name, String Gender, String DOB,
			String COB, String POB, String occupation, String Occ_Code, String Clearance_Number, String MOTHER_NAME,
			String MARITAL_STATUS, String Civil_No, String Nati, String FullName, String Relship, String TDNO)
			throws InterruptedException, IOException, SQLException, ClassNotFoundException {

		vs = homepage.CR_Selection(Sponsor_CR);
		TD = vs.Sp_Visa_Select(Visa_Type, Visa_Subtype);
		ad = TD.TDDetails_Spo(Nationality, Document_Nationality, TD_Number, TD_Type, Issue_Date, Expiry_Date,
				Place_of_Issue, Full_Name, Given_Name, Family_Name, Gender, DOB, COB, POB);
		rd = ad.Sponsored_AdditionalDetPage(occupation, Occ_Code, Clearance_Number, MOTHER_NAME, MARITAL_STATUS,
				Civil_No, Nati, FullName, Relship, TDNO);
		cd = rd.UploadDocsPage();
		as = new ApplicantionSummaryPage();
		as = cd.confirmdetailspage();
		ss = new SubmissionSummaryPage();
		ss = as.SubmitPay();
		// driver.navigate().refresh();
		applicationNumber = GetApplicationNo.GetVisaApp();
		System.out.println(applicationNumber);
		XLUtils.setcellData(DataProviders.dataPath, "Sponsored_Visa", p, q, applicationNumber);
		appno = XLUtils.getCellData(DataProviders.dataPath, "Sponsored_Visa", p, q);
		dgpr_login_test = new DGPR_Login_Test();
		initialization_dgpr();
		loginPage_dgpr = new DGPR_LoginPage();
		homepage_dgpr = loginPage_dgpr.login_dgpr(Prop.getProperty("username_dgpr"), Prop.getProperty("password_dgpr"));
		// loginPage_dgpr = loginPage_dgpr.ClickAdvance_dgpr();
		for (int k = 1; k <= 25; k++) {
			dbcon = new database_connection();
			final_visa_status = dbcon.Sponsored_visa_app_status1();
			int_visa_status = Integer.parseInt(final_visa_status);
			System.out.println("Checking initial Visa App Status After Submission: " + int_visa_status);
			Thread.sleep(2000);
			if (int_visa_status == 12) {
				cdocs = new CheckDocsQueue();
				cdocs.clickCheckDoclink();
				cdocs.EnterVisaApp(appno);
				Thread.sleep(1000);
				cdocs.ClickVisaApp(appno);
				Thread.sleep(4000);
				cdocs.VetDocuments();
				break;
			}
		}

		if (int_visa_status == 3) {
			System.out.println("Visa App is still in status 3, Exit Test");
			p = p + 1;
			System.out.println("value of i is :" + p);
			System.out.println("value of j is :" + q);
		} else {

			for (int k = 1; k <= 15; k++) {
				dbcon = new database_connection();
				final_visa_status = dbcon.Sponsored_visa_app_status1();
				int_visa_status = Integer.parseInt(final_visa_status);
				System.out.println("Checking Visa App Status After Docs Check:" + int_visa_status);
				Thread.sleep(2000);
				if (int_visa_status == 16) {
					System.out.println("Application is in verify Queue");
					vp = new VerifyPersonQueue();
					vp.Clear_Verify(appno);

				}
				if (int_visa_status == 20) {
					System.out.println("Application is in Immigration queue");

				}
				if (int_visa_status == 24) {
					System.out.println("Application is in Security queue");
				}

				if (int_visa_status == 31) {
					System.out.println("Application got Approved");
					break;
				}

				if (int_visa_status == 34) {
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
			p = p + 1;
			System.out.println("value of i is :" + p);
			System.out.println("value of j is :" + q);

		}
	}

	@DataProvider(name = "Sp_Visa")
	public String[][] DataForSpVisa() throws IOException {
		String[][] Sp_VisaData = DataProviders.getDataSpoVisa();
		return Sp_VisaData;
	}

//		@AfterMethod
//		public void tearDown() {
//			driver.quit();
//		}

}
