package com.evisa.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Ext_ConfimApplicantPage extends EvisaBase {

	@FindBy(id = "confirmTheApplication")
	WebElement Next;

	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]")
	WebElement Yes_Btn;

	public Ext_ConfimApplicantPage() {
		PageFactory.initElements(driver, this);
	}

	public Ext_ApplicantSummary ConfirmDetails() throws InterruptedException {
		Next.click();
		Yes_Btn.click();
		return new Ext_ApplicantSummary();
	}

}
