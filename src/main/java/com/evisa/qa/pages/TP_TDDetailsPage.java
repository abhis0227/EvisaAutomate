package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class TP_TDDetailsPage extends EvisaBase {

	@FindBy(id = "passportNo")
	WebElement Doc_Num;

	@FindBy(id = "travelDocDataGson")
	WebElement Doc_Type;

	@FindBy(id = "issueDatePassportTrans")
	WebElement Issue_date;

	@FindBy(id = "expiryDate")
	WebElement Expiry_date;

	@FindBy(id = "additionalNext")
	WebElement NxtBtn;

	@FindBy(xpath = "//input[@id='place_of_issue']")
	WebElement POI;

	public TP_TDDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public TP_AdditionalDetails NewTD_Details(String TD_Number, String TD_Type, String Issue_Date, String Expiry_Date,
			String PlaceOfIssue) throws InterruptedException {

		Doc_Num.sendKeys(TD_Number);
		Select TDtype = new Select(Doc_Type);
		TDtype.selectByVisibleText(TD_Type);
		Issue_date.sendKeys(Issue_Date);
		Expiry_date.sendKeys(Expiry_Date);
		Thread.sleep(500);
		String placeofissue = POI.getAttribute("value");
		if (placeofissue.isEmpty()) {

			POI.sendKeys(PlaceOfIssue);
		}
		NxtBtn.click();
		return new TP_AdditionalDetails();
	}

}
