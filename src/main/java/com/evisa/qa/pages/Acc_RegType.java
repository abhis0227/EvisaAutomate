package com.evisa.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class Acc_RegType extends EvisaBase {

	@FindBy(id = "sponsorTypeId")
	WebElement SpoType;

	@FindBy(id = "grpType")
	WebElement SpoGrp;

	@FindBy(id = "crNum")
	WebElement crnum;

	@FindBy(id = "searchBtn")
	WebElement SrchBtn;

	@FindBy(id = "sponsorDataInGson1")
	WebElement SpoRadio;

	@FindBy(id = "next")
	WebElement NxtBtn;

	public Acc_RegType() {
		PageFactory.initElements(driver, this);
	}

	public static boolean IsSpoGroupPresent(String locatorKey) {
		List<WebElement> elePresent = null;
		elePresent = driver.findElements(By.id(locatorKey));
		if (elePresent.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Acc_AccredType SelSponsorType(String Sponsor_Type, String Sponsor_Group, String CR_Number) {
		Select spotype = new Select(SpoType);
		spotype.selectByValue(Sponsor_Type);
		boolean pre = IsSpoGroupPresent("grpType");
		if (pre) {
			Select Spogrp = new Select(SpoGrp);
			Spogrp.selectByVisibleText(Sponsor_Group);
		}
		crnum.sendKeys(CR_Number);
		SrchBtn.click();
		SpoRadio.click();
		NxtBtn.click();
		return new Acc_AccredType();

	}

}
