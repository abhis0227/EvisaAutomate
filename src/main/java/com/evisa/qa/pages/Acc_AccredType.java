package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class Acc_AccredType extends EvisaBase {

	@FindBy(id = "accredId")
	WebElement acctype;

	@FindBy(id = "next")
	WebElement NxtBtn;

	public Acc_AccredType() {
		PageFactory.initElements(driver, this);
	}

	public Acc_RequiredDocsPage SelAccType(String Accred_Type) {
		Select Acctype = new Select(acctype);
		Acctype.selectByVisibleText(Accred_Type);
		NxtBtn.click();
		return new Acc_RequiredDocsPage();

	}

}
