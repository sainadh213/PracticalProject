package com.Tutorialsninja.Base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {

	public static WebDriver driver;
	FileUtil fu = new FileUtil();

	@BeforeMethod
	public void launchApp() throws Throwable {
		String browser = fu.readDataFromPropertiesFile("browser");
		// System.out.println("Browser Name=" + browser);
		 ChromeOptions cp = new ChromeOptions();
		 cp.addArguments("--headless=new");
		if (browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver(cp);
			//driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitTime));
		driver.get(fu.readDataFromPropertiesFile("url"));

	}

	public static void captureScreenshot(String testName) throws Throwable {
		JavaUtil ju = new JavaUtil();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		// File dest = new File(Constants.screenshotPath + testName + ".png");
		// File dest = new File(Constants.screenshotPath + testName +".png");

		File dest = new File(Constants.screenshotPath + testName + ju.getTimestamp() + ".png");
		FileHandler.copy(src, dest);
		// Files.copy(src, dest);

	}

    //This method for closing browser
	@AfterMethod(enabled = true)
	public void closeApp() {
		driver.quit();
	}
//
}
