package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TR_ConfirmPage extends EvisaBase {

	@FindBy(id = "renewVisaInvester")
	WebElement NxtBtn;

	public TR_ConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	public TR_TDDetailsPage SelectReason(String Reason) {
		driver.findElement(By.xpath("//input[@value='" + Reason + "']")).click();
		NxtBtn.click();
		return new TR_TDDetailsPage();
	}

}
