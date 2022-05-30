package com.evisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evisa.qa.base.EvisaBase;

public class FindVisaPage extends EvisaBase {

	@FindBy(id = "visaNumber")
	WebElement Visa_Num;

	@FindBy(id = "submit")
	WebElement Search_Btn;

	@FindBy(id = "selectedUserType")
	WebElement User_Type;

	@FindBy(xpath = "//input[@name='dataInJSON'and @id='dataInJSON1']")
	WebElement Visa_Radio_Btn;

	@FindBy(id = "extend")
	WebElement Extend_Btn;

	@FindBy(id = "renewVisaButton")
	WebElement Renew_Btn;

	@FindBy(id = "transferAndrenewVisaButton")
	WebElement TransferRenew_Btn;

	@FindBy(id = "transfer")
	WebElement Transferpassport_Btn;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OK_Btn;

	public FindVisaPage() {

		PageFactory.initElements(driver, this);
	}

	public void Visa_Search(String visa_no, String Sponsor_Type) {
		Select usertype = new Select(User_Type);
		usertype.selectByVisibleText(Sponsor_Type);
		Visa_Num.sendKeys(visa_no);
		Search_Btn.click();
	}

	public void Ren_Visa_Search(String visa_no) {
		Visa_Num.sendKeys(visa_no);
		Search_Btn.click();
	}

	public Extend_VisaPage Extend_Visa() {
		Visa_Radio_Btn.click();
		Extend_Btn.click();
		return new Extend_VisaPage();

	}

	public Renew_ConfirmDetails Renew_Visa() {
		Visa_Radio_Btn.click();
		Renew_Btn.click();
		return new Renew_ConfirmDetails();

	}

	public TR_ConfirmPage TransferRenew_Visa() {
		Visa_Radio_Btn.click();
		TransferRenew_Btn.click();
		OK_Btn.click();
		return new TR_ConfirmPage();

	}

	public TP_ConfirmPage TransferPassport() {
		Visa_Radio_Btn.click();
		Transferpassport_Btn.click();
		OK_Btn.click();
		return new TP_ConfirmPage();

	}

}
