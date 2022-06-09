package com.vis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriverService.Builder;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.internal.BaseClassFinder;
import com.evisa.qa.base.EvisaBase;

public class RL1_Login extends EvisaBase {

	@FindBy(id = "username")
	WebElement username;
	String name;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//div//input[@type='submit']")
	WebElement LoginBtn;

	public RL1_Login() {
		super();
		PageFactory.initElements(driver, this);

	}

	public RL1_HomePage RL1_Login1(String vis_username, String vis_Password) throws InterruptedException {
		try {

			username.sendKeys(vis_username);
			password.sendKeys(vis_Password);
			Thread.sleep(3000);
			LoginBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return new RL1_HomePage();
	}

//	public static void main(String[] args) throws InterruptedException {
//		RL1_Login rl12 = new RL1_Login();
//		RL1_Login rl13 = new RL1_Login("A");
//		
//		PageFactory.initElements(driver, RL1_Login.class);
//
////		PageFactory.initElements(driver, RL1_Login.class);
//		RL1VIS_Login();
////		driver.findElement(By.id("username")).sendKeys("vis");
////		driver.findElement(By.id("password")).sendKeys("PasswordU2");
////		Thread.sleep(2000);
////		driver.findElement(By.xpath("//div//input[@type='submit']")).click();
//		rl13.RL1_Login1("vis", "PasswordU2");
//	}

}
