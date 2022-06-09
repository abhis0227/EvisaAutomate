package com.evisa.qa.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evisa.qa.base.EvisaBase;
//import com.google.inject.spi.Element;

public class AdditionalDetailsPage extends EvisaBase {

	@FindBy(id = "motherFirstName")
	WebElement motherFirstName;

	@FindBy(id = "maritalStatus")
	WebElement maritalStatus;

	@FindBy(id = "dependentOnDTO.dependentNationalityDateGson")
	WebElement DepNationality;

	@FindBy(xpath = "//select[@id='dependentRelationShipDataGson']")
	WebElement Relation;

	@FindBy(xpath = "//*[@id='passportNo']")
	WebElement TD;

	@FindBy(id = "occupationDataGson")
	WebElement Occupation;

	@FindBy(id = "occuCode")
	WebElement Occupation_Code;

	@FindBy(id = "clearanceNumber")
	WebElement Clearance_No;

	@FindBy(xpath = "//Button[@name='nextForm' and @id='nextSubmit']")
	WebElement Next;

	@FindBy(id = "civilnum")
	WebElement Civil_Number;

	@FindBy(id = "fullName")
	WebElement FullName;

	public AdditionalDetailsPage() {

		PageFactory.initElements(driver, this);
	}

	public static boolean IsElementPresent(String locatorKey) {
		List<WebElement> elePresent = null;
		elePresent = driver.findElements(By.id(locatorKey));
		if (elePresent.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Required_DocumentPage AdditionalDetPage(String Mother_name, String GCC_Occupation, String Marital_status,
			String Nati, String Relship, String TDNO) throws InterruptedException {

		WebDriverWait mother_wait = new WebDriverWait(driver, 5);
		mother_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("motherFirstName")));
		motherFirstName.sendKeys(Mother_name);
		boolean gcc_occupation_name = IsElementPresent("occupationDataGson");
		if (gcc_occupation_name) {
			Select occupat = new Select(Occupation);
			occupat.selectByVisibleText(GCC_Occupation);
		}
		Select marital = new Select(maritalStatus);
		marital.selectByVisibleText(Marital_status);
		// Thread.sleep(1000);

		boolean depnation = IsElementPresent("dependentOnDTO.dependentNationalityDateGson");
		if (depnation) {
			Select depnat = new Select(DepNationality);
			depnat.selectByVisibleText(Nati);
			Select rel = new Select(Relation);
			rel.selectByVisibleText(Relship);
			TD.sendKeys(TDNO);

		}

		Next.click();

		return new Required_DocumentPage();
	}

	public Required_DocumentPage Sponsored_AdditionalDetPage(String occupation, String Occ_Code,
			String Clearance_Number, String MOTHER_NAME, String MARITAL_STATUS, String Civil_No, String Nati,
			String Full_Name, String Relship, String TDNO) throws InterruptedException {
		// Thread.sleep(1000);
		boolean occupation_present = IsElementPresent("occupationDataGson");
		if (occupation_present) {
			Select occupat = new Select(Occupation);
			occupat.selectByVisibleText(occupation);
		}
		boolean occupation_code_present = IsElementPresent("occuCode");
		if (occupation_code_present) {
			driver.findElement(By.id("occuCode")).sendKeys(Occ_Code);
			driver.findElement(By.id("occuCode")).sendKeys(Keys.TAB);
			Thread.sleep(500);
			Clearance_No.sendKeys(Clearance_Number);
		}
		Thread.sleep(500);
		motherFirstName.sendKeys(MOTHER_NAME);
		Select marital = new Select(driver.findElement(By.xpath("//Select[@id='maritalStatus']")));
		marital.selectByVisibleText(MARITAL_STATUS);
		// Thread.sleep(1000);
		boolean civil_num = IsElementPresent("civilnum");
		if (civil_num) {
			Civil_Number.sendKeys(Civil_No);
			Select depnat = new Select(DepNationality);
			depnat.selectByVisibleText(Nati);
			FullName.sendKeys(Full_Name);
			Select rel = new Select(Relation);
			rel.selectByVisibleText(Relship);
		}

		Next.click();

		return new Required_DocumentPage();
	}

}
