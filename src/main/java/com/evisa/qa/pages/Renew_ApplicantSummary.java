package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Renew_ApplicantSummary extends EvisaBase {

	@FindBy(id = "othercard")
	WebElement AnyOther_Card;

	@FindBy(id = "submitPay")
	WebElement SubmitPay;

	@FindBy(id = "okButton")
	WebElement OkBtn;

	String app;

	public Renew_ApplicantSummary() {
		PageFactory.initElements(driver, this);
	}

	public Renew_SubmissionSummaryPage Submit_Pay() {
		AnyOther_Card.click();
		SubmitPay.click();
		OkBtn.click();
		return new Renew_SubmissionSummaryPage();
	}

}
