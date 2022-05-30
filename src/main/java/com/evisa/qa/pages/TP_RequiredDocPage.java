package com.evisa.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evisa.qa.base.EvisaBase;

public class TP_RequiredDocPage extends EvisaBase {

	@FindBy(id = "submitattachments")
	WebElement NxtBtn;

	public TP_RequiredDocPage() {

		PageFactory.initElements(driver, this);
	}

	public static boolean IsDocPresent(String locatorKey) {
		List<WebElement> elePresent = null;
		elePresent = driver.findElements(By.xpath(locatorKey));
		if (elePresent.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public TP_ConfirmDetailPage UploadDocsPage() throws InterruptedException {
		boolean document_present = IsDocPresent(
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
		NxtBtn.click();
		return new TP_ConfirmDetailPage();
	}

}
