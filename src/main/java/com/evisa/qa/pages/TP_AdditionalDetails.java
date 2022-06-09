package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TP_AdditionalDetails extends EvisaBase {

	@FindBy(id = "motherFirstName")
	WebElement mothername;

	@FindBy(id = "nextAttachment")
	WebElement NextBtn;

	public TP_AdditionalDetails() {

		PageFactory.initElements(driver, this);
	}

	public TP_RequiredDocPage EnterAddDetails(String Mother_Name) {
		String Mother = mothername.getAttribute("value");
		if (Mother.isEmpty()) {
			mothername.sendKeys(Mother_Name);
		}
		NextBtn.click();
		return new TP_RequiredDocPage();
	}

}
