package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TR_ApplicantSummaryPage extends EvisaBase {

	@FindBy(id = "othercard")
	WebElement Othercard;

	@FindBy(id = "submitPay")
	WebElement SubmitBtn;

	public TR_ApplicantSummaryPage() {

		PageFactory.initElements(driver, this);
	}

	public TR_SubmissionSummaryPage SubmitPay() {
		Othercard.click();
		SubmitBtn.click();
		return new TR_SubmissionSummaryPage();
	}

}
