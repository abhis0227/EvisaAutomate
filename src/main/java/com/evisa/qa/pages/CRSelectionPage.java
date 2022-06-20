package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class CRSelectionPage extends EvisaBase {

	@FindBy(id = "new-visa")
	WebElement NewVisa;

	@FindBy(id = "next-proceed")
	WebElement NextBtn;

	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']//input[@type='text' and @class='alphaNum']")
	WebElement SearchBox;

	public CRSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	public VisaSelectPage CR_Selection(String Sponsor_CR) throws InterruptedException {
		Thread.sleep(1000);
		SearchBox.sendKeys(Sponsor_CR);
		Thread.sleep(500);
		driver.findElement(By.xpath("//tbody[@role='alert']//tr//td[contains(text(),'" + Sponsor_CR + "')]")).click();
		NewVisa.click();
		NextBtn.click();
		return new VisaSelectPage();

	}

}
