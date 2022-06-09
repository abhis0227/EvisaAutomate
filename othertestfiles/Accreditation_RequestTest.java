package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.Acc_AccredType;
import com.evisa.qa.pages.Acc_ConfirmDetailPage;
import com.evisa.qa.pages.Acc_RegType;
import com.evisa.qa.pages.Acc_RequiredDocsPage;
import com.evisa.qa.pages.AdditionalDetailsPage;
import com.evisa.qa.pages.ApplicantionSummaryPage;
import com.evisa.qa.pages.CheckDocsQueue;
import com.evisa.qa.pages.ConfirmDetailPage;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.FindVisaPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.pages.Renew_ApplicantSummary;
import com.evisa.qa.pages.Renew_ConfirmDetails;
import com.evisa.qa.pages.Renew_SubmissionSummaryPage;
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

public class Accreditation_RequestTest extends EvisaBase {

	public static int p = 1;
	public static int q = 5;
	public static String applicationNumber;
	String appno;
	static String final_visa_status;
	static int int_visa_status;
	LoginPage loginPage;
	HomePage homepage;
	Acc_RegType accrt;
	Acc_AccredType accat;
	Acc_RequiredDocsPage accrd;
	Acc_ConfirmDetailPage acccd;

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

	public Accreditation_RequestTest() {
		super();
	}
	@Parameters("browser")
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		accrt = homepage.AccredReq();

	}

	@Test(dataProvider = "Accred_Req")
	public void AccReq(String Sponsor_Type, String Sponsor_Group, String CR_Number, String Accred_Type)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		accat = accrt.SelSponsorType(Sponsor_Type, Sponsor_Group, CR_Number);
		accrd = accat.SelAccType(Accred_Type);
		acccd = accrd.UploadDocsPage();
		acccd.ConfirmDetails();
		Thread.sleep(5000);
		String applicationNumber = GetApplicationNo.GetVisaApp_transaction();
		System.out.println(applicationNumber);
		XLUtils.setcellData(DataProviders.dataPath, "RenewVisa", p, q, applicationNumber);
		appno = XLUtils.getCellData(DataProviders.dataPath, "RenewVisa", p, q);
		dgpr_login_test = new DGPR_Login_Test();
		initialization_dgpr();

	}

	@DataProvider(name = "Accred_Req")
	public String[][] DataForAccred() throws IOException {
		String[][] Accred_Data = DataProviders.getDataForAccredRequest();
		return Accred_Data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
