package com.evisa.qa.pages;

import org.openqa.selenium.By;

import com.evisa.qa.base.EvisaBase;

public class ApplicantionSummaryPage extends EvisaBase {

	public SubmissionSummaryPage SubmitPay() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='92D656AF-AD6D-4E2F-A3B9-E974847FD87A']")).click();// click checkbox
		driver.findElement(By.xpath("//*[@id='othercard']")).click();
		driver.findElement(By.xpath("//input[@id='submitPay']")).click();// submit and pay
		driver.findElement(By.xpath("//input[@id='okButton']")).click(); // OK BUTTON
		// driver.findElement(By.xpath("//div//button[@id='proceed-button']")).click();
		return new SubmissionSummaryPage();

	}

}
