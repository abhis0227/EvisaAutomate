package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Ext_TDDetailsPage extends EvisaBase {

	@FindBy(id = "place_of_issue")
	WebElement placeof_issue;

	@FindBy(id = "placeOFBirth")
	WebElement placeof_birth;

	@FindBy(id = "additionalNext")
	WebElement Next_Btn;

	public Ext_TDDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public Ext_AdditionalDetailsPage Enter_TDDetails(String PlaceofIssue, String PlaceofBirth) {

		String Placeofissue = placeof_issue.getAttribute("value");
		String Placeofbirth = placeof_birth.getAttribute("value");

		if (Placeofissue.isEmpty()) {
			placeof_issue.sendKeys(PlaceofIssue);
		}

		if (Placeofbirth.isEmpty()) {
			placeof_birth.sendKeys(PlaceofBirth);
		}

		Next_Btn.click();

		return new Ext_AdditionalDetailsPage();
	}
}
