package com.evisa.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.DGPR_HomePage;
import com.evisa.qa.pages.DGPR_LoginPage;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;

@SuppressWarnings("unused")
public class LoginPageTest extends EvisaBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();

	}

	@Test
	public void logintest() throws InterruptedException {
		loginpage = loginpage.ClickAdvance();
		homepage = loginpage.login(Prop.getProperty("username"), Prop.getProperty("password"));

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
