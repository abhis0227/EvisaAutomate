package com.evisa.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class VisaSelectPage extends EvisaBase {

	@FindBy(xpath = "//*[contains(@id,'26A///') and @class='click_here']")
	WebElement Visa_Sub_26A;

	@FindBy(xpath = "//*[contains(@id,'26B///') and @class='click_here']")
	WebElement Visa_Sub_26B;

	@FindBy(xpath = "//*[contains(@id,'36B///') and @class='click_here']")
	WebElement Visa_Sub_36A;

	@FindBy(xpath = "//*[contains(@id,'25D///') and @class='click_here']")
	WebElement Visa_Sub_25D;

	@FindBy(xpath = "//*[@id='visaTypes']")
	WebElement VisaType_Sel;

	@FindBy(xpath = "//*[@id='visaSubType']")
	WebElement Visa_SubType_Sel;

	@FindBy(id = "proceed")
	WebElement Visa_NextBtn;

	@FindBy(id = "submitform")
	WebElement OKBtn;

	public VisaSelectPage() {

		PageFactory.initElements(driver, this);
	}

	public TravelDocPage Sp_Visa_Select(String Visa_Type, String Visa_Subtype) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> visatype = driver.findElements(By.xpath("//select[@id='visaTypes']//option"));
		WebElement vsubtype = driver.findElement(By.xpath("//select[@id='visaSubType']"));

		for (int i = 1; i <= visatype.size(); i++) {
			String vtype = visatype.get(i).getText();
			System.out.println("visatype is :" + vtype);
			if (vtype.equalsIgnoreCase(Visa_Type)) {
				visatype.get(i).click();
				break;
			}
		}
		Thread.sleep(1500);
		List<WebElement> visasubtype = driver.findElements(By.xpath("//select[@id='visaSubType']//option"));
		if (vsubtype.isDisplayed()) {
			for (int j = 1; j <= visasubtype.size(); j++) {
				String vstype = visasubtype.get(j).getText();
				System.out.println("visasubtype is :" + vstype);
				if (vstype.equalsIgnoreCase(Visa_Subtype)) {
					visasubtype.get(j).click();
					break;
				}
			}
		}
		Thread.sleep(1000);
		Visa_NextBtn.click();
		OKBtn.click();
		return new TravelDocPage();
	}

	public TravelDocPage ClickVisa(String Visa_SubType) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'" + Visa_SubType + "///') and @class='click_here']")).click();
		driver.findElement(By.id("submitform")).click();
		return new TravelDocPage();

	}

};
