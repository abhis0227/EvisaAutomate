package com.evisa.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class LoginPageTest extends EvisaBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();

	}
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void SetUp(String browser ) {
		initialization(browser);

	}

	@Test(priority = 1,groups = "Smoke")
	public void eVisaLogoTest() {
		loginpage = new LoginPage();
		boolean logo_disp = loginpage.validateEvisaLogo();
		Assert.assertTrue(logo_disp);
	}

	@Test(priority = 2, groups = "Regression")
	public void logintest() throws InterruptedException {
		loginpage = new LoginPage();
		// homepage = new HomePage();
		// loginpage = loginpage.ClickAdvance();
		homepage = loginpage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		String HomePage_Title = homepage.validateLoginPageTiltle();
		Assert.assertEquals("Sponsor Home", HomePage_Title);
	}

	@AfterMethod(groups = {"Smoke","Regression"})
	public void tearDown() {
		driver.quit();
	}

}
