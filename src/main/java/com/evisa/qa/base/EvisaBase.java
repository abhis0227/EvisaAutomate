package com.evisa.qa.base;

//Abhishek
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.evisa.qa.util.TestUtil;

public class EvisaBase {

	public static Properties Prop;
	public static WebDriver driver;

//	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
//	public static WebDriver getDriver() {
//		return driver.get();
//	}

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

	public static void initialization(String browserName) {

		// String browserName = Prop.getProperty("browser_public");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver 102\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			// driver.set(new ChromeDriver());
		}

		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver();
			// driver.set(new FirefoxDriver());
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(cap);
			driver = new InternetExplorerDriver();
			// driver.set(new InternetExplorerDriver());
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url"));

	}

	public static void initialization_dgpr(String browserName) {

		// String browserName = Prop.getProperty("browser_public");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver 102\\chromedriver.exe");
			// DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
			// handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			// WebDriver driver = new ChromeDriver (handlSSLErr);
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			// driver.set(new ChromeDriver());
		}

//		else if (browserName.equals("FF")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
//			FirefoxOptions options = new FirefoxOptions();
//			options.setAcceptInsecureCerts(true);
//			driver = new FirefoxDriver();
//			// driver.set(new FirefoxDriver());
//		} else if (browserName.equals("IE")) {
//			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			InternetExplorerOptions options = new InternetExplorerOptions();
//			options.merge(cap);
//			driver = new InternetExplorerDriver();
//			// driver.set(new InternetExplorerDriver());
//		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url_dgpr"));

	}

};
