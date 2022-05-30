package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TP_ApplicantSummaryPage extends EvisaBase {

//	@FindBy(id = "othercard")
//	WebElement Othercard;

	@FindBy(id = "submitPay")
	WebElement SubmitBtn;

	public TP_ApplicantSummaryPage() {

		PageFactory.initElements(driver, this);
	}

	public TP_SubmissionSummaryPage SubmitPay() {
		SubmitBtn.click();
		return new TP_SubmissionSummaryPage();
	}

}
