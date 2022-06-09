package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class LoginPage extends EvisaBase {

	// Page Factory - OR
	@FindBy(id = "_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_username")
	WebElement username;
	//

	@FindBy(id = "_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_password")
	WebElement password;

	@FindBy(id = "loginButtonId")
	WebElement LoginBtn;

	@FindBy(xpath = "//div[@class='logo_new']")
	WebElement evisaLogo;

	@FindBy(xpath = "//button[@id='details-button']")
	WebElement AdvanceBtn;

	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement Proceed; 
	
	@FindBy(xpath = "//button[text()='Send anyway']")
	WebElement SendAnyWay;

	// initializing page objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions available on Login Page

//	public String validateLoginPageTiltle() {
//		return driver.getTitle();
//	}

	public boolean validateEvisaLogo() {
		return evisaLogo.isDisplayed();

	}

	public LoginPage ClickAdvance() {
		AdvanceBtn.click();
		Proceed.click();
		return new LoginPage();

	}

	public HomePage login(String username1, String password1) throws InterruptedException {
		username.sendKeys(username1);
		// driver.findElement(By.xpath("//input[@id='_evisaregister_WAR_Evisaregisterportlet_login_username']")).sendKeys(username1);
		// driver.findElement(By.xpath("//input[@id='_evisaregister_WAR_Evisaregisterportlet_login_password']")).sendKeys(password1);
		password.sendKeys(password1);
		// Thread.sleep(5000);
		LoginBtn.click();
		Thread.sleep(2000);
		SendAnyWay.click();
		return new HomePage();
	}

};
