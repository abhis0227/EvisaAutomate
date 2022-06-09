package com.evisa.qa.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;
import com.evisa.qa.util.GetApplicationNo;

public class Ext_ApplicantSummary extends EvisaBase {

	@FindBy(id = "othercard")
	WebElement AnyOther_Card;

	@FindBy(id = "submitPay")
	WebElement SubmitPay;

	@FindBy(id = "okButton")
	WebElement OkBtn;

	String app;

	public Ext_ApplicantSummary() {
		PageFactory.initElements(driver, this);
	}

	public Ext_SubmissionSummaryPage SubmitPay() {
		AnyOther_Card.click();
		SubmitPay.click();
		OkBtn.click();
		return new Ext_SubmissionSummaryPage();
	}

}
