package com.vis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class IDEPage extends EvisaBase {

	@FindBy(xpath = "//select[@id='primaryLineInstruction']")
	WebElement VisaAppAction;

	@FindBy(xpath = "//div[@class='buttonArearef']//div[@id='closeReferral']")
	WebElement CloseRef;

	@FindBy(xpath = "//*[@id='closeReferralNotesText']")
	WebElement CloseRefNotes;

	@FindBy(xpath = "//*[@id='confirmCloseReferral']")
	WebElement ConfirmBtn;

	public IDEPage() {
		PageFactory.initElements(driver, this);
	}

	public void TakeVisaAppDecision(String ApprovalNotes) {

		Select sel = new Select(VisaAppAction);
		sel.selectByValue("Allow");
		CloseRef.click();
		driver.switchTo().alert().sendKeys(ApprovalNotes);
		// CloseRefNotes.sendKeys(ApprovalString);
		ConfirmBtn.click();
		driver.switchTo().alert().accept();

	}

}
