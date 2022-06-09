package com.evisa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evisa.qa.base.EvisaBase;

public class TravelDocPage extends EvisaBase {

	@FindBy(xpath = "//Select[@id='issuingStateDataGson']")
	// @FindBy(xpath="//div//select[@id='issuingStateDataGson' and @class='abc']")
	// @FindBy(id="issuingStateDataGson")
	WebElement docissue;

	@FindBy(id = "passportNo")
	WebElement DocNumber;

	@FindBy(xpath = "*//Select[@name='issuingStateDataGson']")
	WebElement DocNationality;

	@FindBy(id = "nationalityDataGson")
	WebElement Traveler_Nationality;

	@FindBy(xpath = "//Select[@id='travelDocDataGson']")
	WebElement DocType;

	@FindBy(xpath = "//Input[@id='issueDate']")
	WebElement Doc_IssueDate;

	@FindBy(xpath = "//Input[@id='expiryDate']")
	WebElement Doc_ExpiryDate;

	@FindBy(xpath = "//Input[@id='placeOfIssue']")
	WebElement PlaceofIssue;

	@FindBy(id = "fullName")
	WebElement Full_Name;

	@FindBy(xpath = "//Input[@id='givenName']")
	WebElement GivenName;

	@FindBy(xpath = "//Input[@id='familyName']")
	WebElement FamilyName;

	@FindBy(xpath = "//Select[@id='gender']")
	WebElement Gend;

	@FindBy(xpath = "//Input[@id='dateOfBirth']")
	WebElement Date_of_Birth;

	@FindBy(xpath = "//Select[@id='countryOfBirthDataGson']")
	WebElement Country_of_Birth;

	@FindBy(xpath = "//Input[@id='placeOFBirth']")
	WebElement Place_of_Birth;

	public TravelDocPage() {
		PageFactory.initElements(driver, this);
	}

	public AdditionalDetailsPage TDDetails(String Nationality, String Document_Nationality, String TD_Number,
			String TD_Type, String Issue_Date, String Expiry_Date, String Place_of_Issue, String Full_Name,
			String Given_Name, String Family_Name, String Gender, String DOB, String COB, String POB)
			throws InterruptedException {

		Thread.sleep(500);
		Select dos = new Select(docissue);
		dos.selectByVisibleText(Document_Nationality);
		driver.findElement(By.xpath("//Input[@id='passportNo']")).sendKeys(TD_Number);
		Select dtype = new Select(driver.findElement(By.xpath("//Select[@id='travelDocDataGson']")));
		dtype.selectByVisibleText(TD_Type);
		driver.findElement(By.xpath("//Input[@id='issueDate']")).sendKeys(Issue_Date);
		driver.findElement(By.xpath("//Input[@id='expiryDate']")).sendKeys(Expiry_Date);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//Input[@id='placeOfIssue']")).sendKeys(Place_of_Issue);

		boolean e1 = driver.findElement(By.id("fullName")).isDisplayed();

		if (e1 == true) {
			driver.findElement(By.id("fullName")).sendKeys(Full_Name);
		}

		driver.findElement(By.xpath("//Input[@id='givenName']")).sendKeys(Given_Name);
		driver.findElement(By.xpath("//Input[@id='familyName']")).sendKeys(Family_Name);
		Select Gen = new Select(driver.findElement(By.xpath("//Select[@id='gender']")));
		Gen.selectByVisibleText(Gender);
		driver.findElement(By.xpath("//Input[@id='dateOfBirth']")).sendKeys(DOB);
		Select Co = new Select(driver.findElement(By.xpath("//Select[@id='countryOfBirthDataGson']")));
		Co.selectByVisibleText(COB);
		driver.findElement(By.xpath("//Input[@id='placeOFBirth']")).sendKeys(POB);
		driver.findElement(By.xpath("//Button[@name='nextForm']")).click();
		return new AdditionalDetailsPage();
	}

	public AdditionalDetailsPage TDDetails_Spo(String Nationality, String Document_Nationality, String TD_Number,
			String TD_Type, String Issue_Date, String Expiry_Date, String Place_of_Issue, String Full_Name,
			String Given_Name, String Family_Name, String Gender, String DOB, String COB, String POB)
			throws InterruptedException {

		Thread.sleep(500);
		Select nat = new Select(Traveler_Nationality);
		nat.selectByVisibleText(Nationality);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(docissue));
		Select dostate = new Select(docissue);
		dostate.selectByVisibleText(Document_Nationality);
		driver.findElement(By.xpath("//Input[@id='passportNo']")).sendKeys(TD_Number);
		Select dtype = new Select(driver.findElement(By.xpath("//Select[@id='travelDocDataGson']")));
		dtype.selectByVisibleText(TD_Type);
		driver.findElement(By.xpath("//Input[@id='issueDate']")).sendKeys(Issue_Date);
		driver.findElement(By.xpath("//Input[@id='expiryDate']")).sendKeys(Expiry_Date);
		// Thread.sleep(2000);
		WebDriverWait poi = new WebDriverWait(driver, 3);
		poi.until(ExpectedConditions.presenceOfElementLocated(By.id("placeOfIssue")));
		driver.findElement(By.xpath("//Input[@id='placeOfIssue']")).sendKeys(Place_of_Issue);
		boolean e1 = driver.findElement(By.id("fullName")).isDisplayed();
		if (e1 == true) {
			driver.findElement(By.id("fullName")).sendKeys(Full_Name);
		}

		driver.findElement(By.xpath("//Input[@id='givenName']")).sendKeys(Given_Name);
		driver.findElement(By.xpath("//Input[@id='familyName']")).sendKeys(Family_Name);
		Select Gen = new Select(driver.findElement(By.xpath("//Select[@id='gender']")));
		Gen.selectByVisibleText(Gender);
		driver.findElement(By.xpath("//Input[@id='dateOfBirth']")).sendKeys(DOB);
		Select Co = new Select(driver.findElement(By.xpath("//Select[@id='countryOfBirthDataGson']")));
		Co.selectByVisibleText(COB);
		driver.findElement(By.xpath("//Input[@id='placeOFBirth']")).sendKeys(POB);
		driver.findElement(By.xpath("//Button[@name='nextForm']")).click();
		return new AdditionalDetailsPage();
	}

}
