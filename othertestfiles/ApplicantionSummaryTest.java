package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.AdditionalDetailsPage;
import com.evisa.qa.pages.ApplicantionSummaryPage;
import com.evisa.qa.pages.ConfirmDetailPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.pages.Required_DocumentPage;
import com.evisa.qa.pages.SubmissionSummaryPage;
import com.evisa.qa.pages.TravelDocPage;
import com.evisa.qa.pages.VisaEligiWizard;
import com.evisa.qa.pages.VisaSelectPage;
import com.evisa.qa.util.GetApplicationNo;
import com.evisa.qa.util.TestUtil;
import com.evisa.qa.util.XLUtils;
import com.evisa.qa.util.Xls_Reader;

public class ApplicantionSummaryTest extends EvisaBase {

	int i = 1;
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
	XLUtils xlu;

	public ApplicantionSummaryTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		ve = new VisaEligiWizard();
		// loginPage = loginPage.ClickAdvance();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		ve = new VisaEligiWizard();
		ve = homepage.ApplyUnspVisa();
	}

	@DataProvider(name = "Apply_Visa_App")
	public Iterator<Object[]> getTestdata() throws Exception {
		ArrayList<Object[]> abhidata = TestUtil.getDataFromExcel();
		return abhidata.iterator();

	}

	@Test(dataProvider = "Apply_Visa_App")
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
		driver.navigate().refresh();
		String applicationNumber = GetApplicationNo.GetVisaApp();
		System.out.println(applicationNumber);
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\testdata\\Test2.xlsx");
		reader.setCellData("VisaData", "Visa_App", i, "applicationNumber");
		// xlu.setcellData(MARITAL_STATUS, applicationNumber, i, i, Expiry_Date);
		// reader.setCellData("Apply", "Visa_App",2,"100");
		// i = i + 1;

	}

//	@AfterMethod()
//	public void tearDown() {
//		driver.quit();
//	}
};
