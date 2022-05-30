package com.evisa.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.evisa.qa.pages.HomePage;
import com.evisa.qa.pages.LoginPage;
import com.evisa.qa.util.TestUtil;

public class EvisaBase {

	public static Properties Prop;
	public static WebDriver driver;

	public EvisaBase() {

		Prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Abhishek Sharma\\eclipse-workspace\\EVisaAutomate\\src\\main\\java\\com\\evisa\\qa\\config\\config.properties");
			Prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = Prop.getProperty("browser_public");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver 102\\chromedriver.exe");
			// ChromeOptions options = new ChromeOptions();
			// options.setAcc
			driver = new ChromeDriver();
		} 
		
		/*
		 * else if (browserName.equals("FF")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe"); capabilities =
		 * DesiredCapabilities.firefox(); FirefoxOptions option = new FirefoxOptions();
		 * capabilities.merge(option); driver = new FirefoxDriver(); } else if
		 * (browserName.equals("IE")) { System.setProperty("webdriver.ie.driver",
		 * "C:\\Selenium\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe"); capabilities
		 * = DesiredCapabilities.internetExplorer();
		 * capabilities.setAcceptInsecureCerts(true); driver = new
		 * InternetExplorerDriver();
		 * 
		 * } else if (browserName.equals("Edge")) {
		 * System.setProperty("webdriver.edge.driver",
		 * "C:\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe"); capabilities =
		 * DesiredCapabilities.edge(); capabilities.setAcceptInsecureCerts(true); driver
		 * = new EdgeDriver(); }
		 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url"));

	}

	public static void initialization_dgpr() {

		String browserName = Prop.getProperty("browser_dgpr");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} /*
			 * else if (browserName.equals("FF")) {
			 * System.setProperty("webdriver.gecko.driver",
			 * "C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe"); driver = new
			 * FirefoxDriver(); } else if (browserName.equals("IE")) {
			 * System.setProperty("webdriver.ie.driver",
			 * "C:\\Selenium\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe"); capabilities
			 * = DesiredCapabilities.internetExplorer();
			 * capabilities.setAcceptInsecureCerts(true); driver = new
			 * InternetExplorerDriver(); }
			 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url_dgpr"));

	}

	public static void RL1VIS_Login() throws InterruptedException {

		String browserName = Prop.getProperty("browser_RL1");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} /*
			 * else if (browserName.equals("FF")) {
			 * System.setProperty("webdriver.gecko.driver",
			 * "C:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe"); driver = new
			 * FirefoxDriver(); } else if (browserName.equals("IE")) {
			 * System.setProperty("webdriver.ie.driver",
			 * "C:\\Selenium\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe"); capabilities
			 * = DesiredCapabilities.internetExplorer();
			 * capabilities.setAcceptInsecureCerts(true); driver = new
			 * InternetExplorerDriver();
			 * 
			 * } else if (browserName.equals("Edge")) {
			 * System.setProperty("webdriver.edge.driver",
			 * "C:\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe"); capabilities =
			 * DesiredCapabilities.edge(); capabilities.setAcceptInsecureCerts(true); driver
			 * = new EdgeDriver(); }
			 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("vis_url"));
//		driver.findElement(By.id("username")).sendKeys("vis");
//		driver.findElement(By.id("password")).sendKeys("PasswordU2");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div//input[@type='submit']")).click();

	}

};
