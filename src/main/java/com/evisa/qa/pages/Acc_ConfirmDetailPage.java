package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Acc_ConfirmDetailPage extends EvisaBase {

	@FindBy(id = "confirmReqSummary")
	WebElement NxtBtn;

	@FindBy(id = "okButton")
	WebElement OkBtn;

	public Acc_ConfirmDetailPage() {
		PageFactory.initElements(driver, this);
	}

	public void ConfirmDetails() {
		NxtBtn.click();
		OkBtn.click();
		// return new Acc_ConfirmDetails();
	}
}
