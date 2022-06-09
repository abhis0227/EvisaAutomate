package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class Ext_AdditionalDetailsPage extends EvisaBase {

	@FindBy(id = "maritalStatus")
	WebElement Marital_Status;

	@FindBy(id = "motherFirstName")
	WebElement Mother_Name;

	@FindBy(id = "nextAttachment")
	WebElement Next_Btn;

	public Ext_AdditionalDetailsPage() {

		PageFactory.initElements(driver, this);
	}

	public Ext_RequiredDocPage Ext_AdditionalDetails_Page() {
		Next_Btn.click();
		return new Ext_RequiredDocPage();
	}

}
