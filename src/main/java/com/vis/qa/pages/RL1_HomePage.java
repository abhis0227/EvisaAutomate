package com.vis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class RL1_HomePage extends EvisaBase {

	@FindBy(linkText = "Search")
	WebElement Searchicon;

	@FindBy(linkText = "Visa Event Search")
	WebElement VisaSearch;

	@FindBy(xpath = "//input[@id='visaApplicationNumber']")
	WebElement EnterVisaApp;

	@FindBy(xpath = "//div[@id='submit']")
	WebElement ClickSearch;

	public RL1_HomePage() {
		PageFactory.initElements(driver, this);
	}

	public IDEPage ClickVisaSearch(String app) {
		Actions action = new Actions(driver);
		action.moveToElement(Searchicon).build().perform();
		VisaSearch.click();
		EnterVisaApp.sendKeys(app);
		ClickSearch.click();
		action.doubleClick(driver.findElement(By.xpath("//*[@id='visaSearchResult']//div//tbody//tr/td[" + app + "]")));
		return new IDEPage();
	}

}
