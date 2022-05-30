package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Extend_VisaPage extends EvisaBase {

	@FindBy(id = "extendVisa")
	WebElement Next_Btn;

	public Extend_VisaPage() {

		PageFactory.initElements(driver, this);
	}

	public Ext_TDDetailsPage ClickNext() {
		Next_Btn.click();
		return new Ext_TDDetailsPage();
	}

}
