package com.evisa.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class Renew_ConfirmDetails extends EvisaBase {

	@FindBy(id = "placeOFBirth")
	WebElement POB;

	@FindBy(id = "place_of_issue")
	WebElement POI;

	@FindBy(id = "motherFirstName")
	WebElement mother_name;

	@FindBy(id = "maritalStatus")
	WebElement marital_status;

	@FindBy(xpath = "//button[@id='confirmTheApplication']")
	WebElement NextBtn;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement YesBtn;

	public Renew_ConfirmDetails() {
		PageFactory.initElements(driver, this);
	}

	public static boolean IsdocPresent(String locatorKey) {
		List<WebElement> elePresent = null;
		elePresent = driver.findElements(By.xpath(locatorKey));
		if (elePresent.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Renew_ApplicantSummary RenewApp(String PlaceofBirth, String PlaceofIssue, String Mother_Name)
			throws InterruptedException {

		boolean Placeofbirth = POB.getAttribute("value").isEmpty();
		boolean Placeofissue = POI.getAttribute("value").isEmpty();
		boolean mothername = mother_name.getAttribute("value").isEmpty();
		boolean document_present = IsdocPresent(
				"//label[@class ='uploadlabel btn btn-primary' and starts-with(@for,'doc')]");

		if (Placeofbirth) {
			POB.sendKeys(PlaceofBirth);

		}

		if (Placeofissue) {
			POI.sendKeys(PlaceofIssue);
			// Thread.sleep(1000);
		}

		if (mothername) {
			mother_name.sendKeys(Mother_Name);

		}

		if (document_present) {

			List<WebElement> noofdocs = driver.findElements(
					By.xpath("//label[@class ='uploadlabel btn btn-primary' and starts-with(@for,'doc')]"));
			for (int j = 1; j <= noofdocs.size(); j++) {
				driver.findElement(By.xpath("//*[@id='d" + j + "']//*[starts-with(@id,'doc_' )]"))
						.sendKeys(new String[] { "E:\\VISA\\b" + j + ".jpg" });
				Thread.sleep(1000);
			}
		}
		Thread.sleep(1000);
		NextBtn.click();
		YesBtn.click();
		return new Renew_ApplicantSummary();
	}

}
