package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.CheckDocsQueue;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.FindVisaPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.pages.Renew_ApplicantSummary;
import com.evisa.qa.pages.Renew_ConfirmDetails;
import com.evisa.qa.pages.Renew_SubmissionSummaryPage;
import com.evisa.qa.pages.TR_AdditionalDetails;
import com.evisa.qa.pages.TR_ApplicantSummaryPage;
import com.evisa.qa.pages.TR_ConfirmDetailPage;
import com.evisa.qa.pages.TR_ConfirmPage;
import com.evisa.qa.pages.TR_RequiredDocPage;
import com.evisa.qa.pages.TR_SubmissionSummaryPage;
import com.evisa.qa.pages.TR_TDDetailsPage;
import com.evisa.qa.pages.VerifyPersonQueue;
import com.evisa.qa.util.DataProviders;
import com.evisa.qa.util.GetApplicationNo;
import com.evisa.qa.util.XLUtils;
import com.evisa.qa.util.Xls_Reader;
import com.vis.qa.pages.IDEPage;
import com.vis.qa.pages.RL1_HomePage;
import com.vis.qa.pages.RL1_Login;

public class TransferRenewTest extends EvisaBase {

	public static int p = 1;
	public static int q = 8;
	public static String applicationNumber;
	String appno;
	static String final_visa_status;
	static int int_visa_status;
	LoginPage loginPage;
	HomePage homepage;
	FindVisaPage FP;
	TR_ConfirmPage trcp;
	TR_TDDetailsPage trtd;
	TR_AdditionalDetails tradp;
	TR_RequiredDocPage trrdp;
	TR_ConfirmDetailPage trcdp;
	TR_ApplicantSummaryPage trapp;
	TR_SubmissionSummaryPage trssp;
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

	public TransferRenewTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		FP = homepage.GotoFindVisa();

	}

	@Test(dataProvider = "TransferRenew")
	public void TransferRenewVisa(String Visa_no, String Reason, String TD_Number, String TD_Type, String Issue_Date,
			String Expiry_Date, String PlaceOfIssue, String Mother_Name)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		FP.Ren_Visa_Search(Visa_no);
		trcp = FP.TransferRenew_Visa();
		trtd = trcp.SelectReason(Reason);
		tradp = trtd.NewTD_Details(TD_Number, TD_Type, Issue_Date, Expiry_Date, PlaceOfIssue);
		trrdp = tradp.EnterAddDetails(Mother_Name);
		trcdp = trrdp.UploadDocsPage();
		trapp = trcdp.ConfirmDetails();
		trssp = trapp.SubmitPay();
		Thread.sleep(5000);
		String applicationNumber = GetApplicationNo.GetVisaApp_transaction();
		System.out.println(applicationNumber);
		XLUtils.setcellData(DataProviders.dataPath, "TransferRenewVisa", p, q, applicationNumber);
		appno = XLUtils.getCellData(DataProviders.dataPath, "TransferRenewVisa", p, q);
		dgpr_login_test = new DGPR_Login_Test();
		initialization_dgpr();
		loginPage_dgpr = new DGPR_LoginPage();
		homepage_dgpr = loginPage_dgpr.login_dgpr(Prop.getProperty("username_dgpr"), Prop.getProperty("password_dgpr"));
		// loginPage_dgpr = loginPage_dgpr.ClickAdvance_dgpr();
		for (int k = 1; k <= 25; k++) {
			dbcon = new database_connection();
			final_visa_status = dbcon.TransferRenew_visa_app_status1();
			int_visa_status = Integer.parseInt(final_visa_status);
			System.out.println("Checking initial Visa App Status After Submission: " + int_visa_status);
			Thread.sleep(2000);
			if (int_visa_status == 12) {
				cdocs = new CheckDocsQueue();
				cdocs.clickCheckDoclink();
				cdocs.EnterVisaApp(appno);
				cdocs.ClickVisaApp(appno);
				Thread.sleep(4000);
				cdocs.VetDocuments();
				break;
			}
		}

		if (int_visa_status == 3) {
			System.out.println("Visa App is still in status 3, Exit Test");
			p = p + 1;
		} else {

			for (int k = 1; k <= 15; k++) {
				dbcon = new database_connection();
				final_visa_status = dbcon.TransferRenew_visa_app_status1();
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

		}
	}

	@DataProvider(name = "TransferRenew")
	public String[][] DataForRenewVisa() throws IOException {
		String[][] TransferRenew_VisaData = DataProviders.getDataForTransferRenew();
		return TransferRenew_VisaData;
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
