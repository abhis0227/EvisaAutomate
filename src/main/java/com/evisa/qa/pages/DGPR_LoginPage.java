package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class DGPR_LoginPage extends EvisaBase {

	@FindBy(xpath = "//input[@id='_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_username']")
	WebElement username_dgpr;

	@FindBy(xpath = "//input[@id='_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_password']")
	WebElement password_dgpr;

	@FindBy(xpath = "//div//input[@type='submit']")
	WebElement LoginBtn_dgpr;

	@FindBy(xpath = "//button[@id='details-button']")
	WebElement AdvanceBtn_dgpr;

	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement Proceed_dgpr;

	public DGPR_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public DGPR_HomePage login_dgpr(String username1, String password1) {
		username_dgpr.sendKeys(username1);
		password_dgpr.sendKeys(password1);
		LoginBtn_dgpr.click();
		return new DGPR_HomePage();
	}

	public DGPR_LoginPage ClickAdvance_dgpr() {
		AdvanceBtn_dgpr.click();
		Proceed_dgpr.click();
		return new DGPR_LoginPage();

	}

//	public static void main(String[] s) {
//		DGPR_LoginPage dgpr_login = new DGPR_LoginPage();
//		initialization_dgpr();
//		PageFactory.initElements(driver, dgpr_login);
//		dgpr_login.login_dgpr("gmanager1", "pass@w0rd");
//
//	}
}
