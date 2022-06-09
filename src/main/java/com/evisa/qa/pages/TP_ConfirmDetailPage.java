package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TP_ConfirmDetailPage extends EvisaBase {

	@FindBy(id = "confirmTheApplication")
	WebElement NxtBtn;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement YesBtn;

	public TP_ConfirmDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public TP_ApplicantSummaryPage ConfirmDetails() {
		NxtBtn.click();
		YesBtn.click();
		return new TP_ApplicantSummaryPage();
	}

}
