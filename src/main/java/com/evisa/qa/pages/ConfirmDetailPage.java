package com.evisa.qa.pages;

import org.openqa.selenium.By;

import com.evisa.qa.base.EvisaBase;

public class ConfirmDetailPage extends EvisaBase {

	public ApplicantionSummaryPage confirmdetailspage() {
		driver.findElement(By.xpath("//input[@id='confirmAppSummary']")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-default' and @id='okButton']")).click();
		return new ApplicantionSummaryPage();

	}

}
