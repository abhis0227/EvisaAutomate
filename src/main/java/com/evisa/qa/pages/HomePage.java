package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class HomePage extends EvisaBase {

	// Page Factory -OR

	@FindBy(xpath = "//a[contains(text(),' Apply for Visa ')]")
	WebElement ApplyLink;

	@FindBy(xpath = "//a[@id='applyUnsponsorbutton']")
	WebElement ApplyUnsp;

	@FindBy(linkText = "Apply for Sponsored Visa")
	WebElement ApplySponsored;

	@FindBy(id = "new-visa")
	WebElement NewVisa;

	@FindBy(id = "next-proceed")
	WebElement NextBtn;

	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']//input[@type='text' and @class='alphaNum']")
	WebElement SearchBox;

	@FindBy(id = "findVisa")
	WebElement FindVisa_Link;

	@FindBy(id = "accredRequestSubmissionButton")
	WebElement Accred_Req;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTiltle() {
		return driver.getTitle();
	}


	public VisaEligiWizard ApplyUnspVisa() {
		ApplyLink.click();
		ApplyUnsp.click();
		return new VisaEligiWizard();
	}

	public VisaSelectPage ApplySpVisa() {
		ApplyLink.click();
		ApplySponsored.click();
		return new VisaSelectPage();
	}

	public VisaSelectPage CR_Selection(String Sponsor_CR) throws InterruptedException {
		SearchBox.sendKeys(Sponsor_CR);
		Thread.sleep(500);
		driver.findElement(By.xpath("//tbody[@role='alert']//tr//td[contains(text(),'" + Sponsor_CR + "')]")).click();
		NewVisa.click();
		NextBtn.click();
		return new VisaSelectPage();

	}

	public FindVisaPage GotoFindVisa() {
		FindVisa_Link.click();
		return new FindVisaPage();
	}

	public Acc_RegType AccredReq() {
		Accred_Req.click();
		return new Acc_RegType();
	}

}
