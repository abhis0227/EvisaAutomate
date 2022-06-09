package com.ee.qa.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class EE_Login_test {

	public static WindowsDriver driver_EE = null;
	public static Actions action;

	@BeforeMethod
	public void SetUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files\\SITA\\Entry-Exit Client\\Sita.Pms.Shell.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "Windows_10");
		driver_EE = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		driver_EE.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void VOA_Movement() throws InterruptedException {
		action = new Actions(driver_EE);
		action.moveToElement(driver_EE.findElementByName("SITA Entry Exit"));
		action.doubleClick().perform();
		Thread.sleep(10000);
		// driver_EE.findElementByName("Text Area").click();
		// driver_EE.findElementByName("Text Area").sendKeys("SUPERB");
		// driver_EE.findElementByName("Enter Password").sendKeys("machine@123");
		// driver_EE.findElementByAccessibilityId("UserName").click();
		// driver_EE.findElementByAccessibilityId("UserName").sendKeys("AB");
		// driver_EE.findElementByClassName("#32769").click();
		// driver_EE.findElementByClassName("#32769").sendKeys("BVG");

		// driver_EE.findElementByName("TD No").sendKeys("ABC");
	}

//	@AfterMethod
//	public void CleanUp() {
//		
//		driver_EE.quit();
//	}

}
