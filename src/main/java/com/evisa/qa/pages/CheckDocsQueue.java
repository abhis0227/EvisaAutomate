package com.evisa.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evisa.qa.base.EvisaBase;

import okio.Timeout;

public class CheckDocsQueue extends EvisaBase {

	@FindBy(xpath = "//*[contains(@href,'/getCheckDocQueue')]")
	WebElement Docslink;

	@FindBy(xpath = "//input[@id='appNumber']")
	WebElement enterapp;

	@FindBy(xpath = "//div//button[@id='submitSearch']")
	WebElement Searchbtn;

	@FindBy(xpath = "//tbody//tr[starts-with(@id,'app')]")
	WebElement ClickVisaRecord;

	@FindBy(id = "checkdocApprove")
	WebElement GreenTickMark;

	@FindBy(id = "checkdocviewcheck")
	WebElement EyeTickMark;

	@FindBy(xpath = "//div[@id='page-selection']//a[@href='#!']")
	WebElement TickDocs;

	@FindBy(xpath = "//button[@id='nextButton']")
	WebElement NextBtn;

	@FindBy(xpath = "//div//button[@id='OkBtn']")
	WebElement OKBtn;

	@FindBy(xpath = "//div//a[contains(text(),'Ok')]")
	WebElement FinalOK;

	@FindBy(xpath = "//*[@id='navbar-collapse']/ul/li/a/img")
	WebElement ClickHomeBtn;

	public CheckDocsQueue() {
		PageFactory.initElements(driver, this);
	}

	public void clickCheckDoclink() {
		Docslink.click();

	}

	public void EnterVisaApp(String app) throws InterruptedException {
		enterapp.sendKeys(app);
		Searchbtn.click();
	}

	public void ClickVisaApp(String app) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//tbody//tr[starts-with(@id,'" + app + "')]")).click();
	}

	public void VetDocuments() throws InterruptedException {

		List<WebElement> no_of_docs = driver.findElements(By.xpath("//div[@id='page-selection']//a[@href='#!']"));

		System.out.println(no_of_docs.size());

		for (int i = 1; i <= no_of_docs.size() - 2; i++) {
			Thread.sleep(1000);
			if (GreenTickMark.isDisplayed()) {
				GreenTickMark.click();
				// Thread.sleep(1000);
			} else
				EyeTickMark.click();
		}

		NextBtn.click();
		OKBtn.click();
		FinalOK.click();
		ClickHomeBtn.click();

	}
}
