package com.evisa.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends EvisaBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();

	}

	@Parameters("browser")
	@BeforeClass(groups = { "Smoke", "Regression" })
//	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void SetUp(String browser) {
		initialization(browser);

	}

	@Test(priority = 1, groups = "Smoke", enabled = true)
	public void LoginPage_LogoTest() {
		loginpage = new LoginPage();
		boolean logo_disp = loginpage.validateEvisaLogo();
		Assert.assertTrue(logo_disp);

	}

	@Test(priority = 2, groups = "Regression", enabled = true)
	public void HomePage_LogoTest() throws InterruptedException {
		loginpage = new LoginPage();
		// homepage = new HomePage();
		// loginpage = loginpage.ClickAdvance();
		homepage = loginpage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		String HomePage_Title = homepage.validateLoginPageTiltle();
		Assert.assertEquals("Sponsor Home", HomePage_Title);

	}

//	@AfterMethod(groups = { "Smoke", "Regression" })
	@AfterClass(groups = { "Smoke", "Regression" })
	public void tearDown() {
		driver.close();
	}

}
