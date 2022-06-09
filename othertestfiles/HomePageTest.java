package com.evisa.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;

public class HomePageTest extends EvisaBase {

	HomePage homepage;
	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage = loginPage.ClickAdvance();
		homepage = loginPage.login(Prop.getProperty("username"), Prop.getProperty("password"));
	}

	@Test
	public void ApplyUnspVisaTest() {

		homepage.ApplyUnspVisa();
	}

}
