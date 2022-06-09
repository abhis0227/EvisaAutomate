package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TP_ConfirmPage extends EvisaBase {

	@FindBy(id = "nextTransfer")
	WebElement NxtBtn;

	public TP_ConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	public TP_TDDetailsPage SelectReason(String Reason) {
		driver.findElement(By.xpath("//input[@value='" + Reason + "']")).click();
		NxtBtn.click();
		return new TP_TDDetailsPage();
	}

}
