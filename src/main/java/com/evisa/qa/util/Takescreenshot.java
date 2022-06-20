/**
 * 
 */
package com.evisa.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.evisa.qa.base.EvisaBase;

/**
 * @author Abhishek.Sharma3
 *
 */
public class Takescreenshot extends EvisaBase {

	public static void failedscreenshot(String screenshotName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/" + screenshotName + ".png"));
	}

}
	