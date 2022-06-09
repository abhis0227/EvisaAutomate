package com.evisa.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evisa.qa.base.EvisaBase;

public class Required_DocumentPage extends EvisaBase {

	@FindBy(xpath = "//label[@class ='uploadlabel btn btn-primary' and starts-with(@for,'doc')]")
	WebElement Visa_Count;

	@FindBy(xpath = "//input[@class='btn btn-default blackLoaderSheet' and @id='submitattachments']")
	WebElement Next;

	public Required_DocumentPage() {
		PageFactory.initElements(driver, this);
	}

	public static boolean IsElementPresent(String locatorKey) {
		List<WebElement> elePresent = null;
		elePresent = driver.findElements(By.xpath(locatorKey));
		if (elePresent.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public ConfirmDetailPage UploadDocsPage() throws InterruptedException {
		boolean document_present = IsElementPresent(
				"//label[@class ='uploadlabel btn btn-primary' and starts-with(@for,'doc')]");
		if (document_present) {
			List<WebElement> noofdocs = driver.findElements(
					By.xpath("//label[@class ='uploadlabel btn btn-primary' and starts-with(@for,'doc')]"));
			for (int j = 1; j <= noofdocs.size(); j++) {
				driver.findElement(By.xpath("//*[@id='d" + j + "']//*[starts-with(@id,'doc_' )]"))
						.sendKeys(new String[] { "E:\\VISA\\b" + j + ".jpg" });
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.xpath("//input[@class='btn btn-default blackLoaderSheet' and @id='submitattachments']"))
				.click();
		return new ConfirmDetailPage();
	}

}
