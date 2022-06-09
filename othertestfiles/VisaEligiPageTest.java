package com.evisa.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.AdditionalDetailsPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.pages.TravelDocPage;
import com.evisa.qa.pages.VisaEligiWizard;
import com.evisa.qa.pages.VisaSelectPage;
import com.evisa.qa.util.TestUtil;
//import com.evisa.qa.util.ReadGuru99ExcelFile;

public class VisaEligiPageTest extends EvisaBase {

	LoginPage loginPage;
	HomePage homepage;
	VisaEligiWizard ve;
	VisaSelectPage vs;
	TravelDocPage TD;
	AdditionalDetailsPage ad;

	public VisaEligiPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		ve = new VisaEligiWizard();
		loginPage = loginPage.ClickAdvance();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		ve = homepage.ApplyUnspVisa();
	}

	@DataProvider
	public Iterator<Object[]> getTestdata() throws Exception {
		ArrayList<Object[]> abhidata = TestUtil.getDataFromExcel();
		return abhidata.iterator();

	}

	@Test(dataProvider = "getTestdata")
	public void applyVisa(String Nationality, String GCC, String Visa_SubType, String Document_Nationality,
			String TD_Number, String TD_Type, String Issue_Date, String Expiry_Date, String Place_of_Issue,
			String Full_Name, String Given_Name, String Family_Name, String Gender, String DOB, String COB, String POB,
			String MOTHER_NAME, String GCC_Occupation, String MARITAL_STATUS, String Nati, String Relship, String TDNO)
			throws InterruptedException, IOException, SQLException, ClassNotFoundException {
		vs = new VisaSelectPage();
		vs = ve.SelectNationality(Nationality, GCC);
		TD = vs.ClickVisa(Visa_SubType);
		TD = new TravelDocPage();
		ad = TD.TDDetails(Nationality, Document_Nationality, TD_Number, TD_Type, Issue_Date, Expiry_Date,
				Place_of_Issue, Full_Name, Given_Name, Family_Name, Gender, DOB, COB, POB);
	}

}
