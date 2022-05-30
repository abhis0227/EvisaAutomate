package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class VisaEligiWizard extends EvisaBase {

	@FindBy(xpath = "//Select[@id='nationality']")

	WebElement natdrop;

	@FindBy(xpath = "//Input[@id='isGCCResident2']")
	WebElement IsGCCResident_NO;

	@FindBy(xpath = "//Input[@id='isGCCResident1']")
	WebElement IsGCCResident_YES;

	@FindBy(xpath = "//Input[@type='submit']")
	WebElement ClickNext;

	@FindBy(id = "gccNationalitySelect")
	WebElement GCCDropdown;

	public VisaEligiWizard() {
		PageFactory.initElements(driver, this);
	}

	public VisaSelectPage SelectNationality(String nationality, String GCC) {

		Select select = new Select(natdrop);
		select.selectByVisibleText(nationality);
		IsGCCResident_YES.click();
		Select gcc = new Select(GCCDropdown);
		gcc.selectByVisibleText(GCC);
		ClickNext.click();
		return new VisaSelectPage();

	}

}
