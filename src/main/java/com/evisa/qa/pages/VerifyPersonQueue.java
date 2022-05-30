package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class VerifyPersonQueue extends EvisaBase {

	// @FindBy(xpath =
	// "//[@id='collapseListGroupHeading12']/h4/a[@href='./verifyPersonQueue?tabId=n5fmzv']")
	@FindBy(linkText = "Verify Person")
	WebElement Verifylink;

	@FindBy(xpath = "//input[@id='appNumber']")
	WebElement enterapp;

	@FindBy(xpath = "//div//button[@id='submitSearch']")
	WebElement Searchbtn;

	@FindBy(xpath = "//tbody//tr[starts-with(@id,'app')]")
	WebElement ClickVisaRecord;

	@FindBy(xpath = "//div[@class='list-group']//ul//li//input[@type='radio' and @id='NewPerson']")
	WebElement NewPersonRadio;

	@FindBy(xpath = "//input[@id='proceed']")
	WebElement ProceedBtn;

	@FindBy(xpath = "//button[@type='button' and @class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[text()='Ok']")
	WebElement ConfirmOKBtn;

	@FindBy(xpath = "//div//a[contains(text(),'Ok')]")
	WebElement FinalOK;

	@FindBy(xpath = "//*[@id='navbar-collapse']/ul/li/a/img")
	WebElement ClickHomeBtn;

	public VerifyPersonQueue() {
		PageFactory.initElements(driver, this);
	}

	public void Clear_Verify(String app) {

		Verifylink.click();
		enterapp.sendKeys(app);
		Searchbtn.click();
		driver.findElement(By.xpath("//tbody//tr[starts-with(@id,'" + app + "')]")).click();
		NewPersonRadio.click();
		ProceedBtn.click();
		ConfirmOKBtn.click();
		FinalOK.click();
		ClickHomeBtn.click();
	}

}
