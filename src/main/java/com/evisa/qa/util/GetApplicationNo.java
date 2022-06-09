package com.evisa.qa.util;

import org.openqa.selenium.By;
import com.evisa.qa.base.EvisaBase;

public class GetApplicationNo extends EvisaBase {
	static String sr;
	static String application_num;
	static Xls_Reader reader;

	public static String GetVisaApp() {
		sr = driver.findElement(By.xpath("//td[@id='appNo']")).getText();
		return sr;
	}

	public static String GetVisaApp_transaction() {

		application_num = driver.findElement(By.xpath("//table//tbody//tr//td[6]")).getText();
		return application_num;
	}

}
