package com.hepsiburada.base;

import java.io.File;
import java.io.IOException;

import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SeleniumAbstractTest extends AbstractTest {

	public static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}


	@BeforeSuite
	public void StartSuite (ITestContext ctx)  {
		super.StartSuite(ctx);
		}

	@SuppressWarnings ("deprecation")
	public static WebDriver setUpBrowser(String browser) {
		if (browser.contains("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			//String currentDir = System.getProperty("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver.exe");

			//Creating an object of ChromeDriver
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");

			//Creating an object of ChromeDriver
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}

	@AfterMethod

	public void FailedTestCaseScreenShot(ITestResult result) throws IOException {

		 if(ITestResult.FAILURE==result.getStatus()) {
			 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			 FileUtils.copyFile(srcFile, new File("C:\\screenshoot.png"));
			 driver.close();
		  }
		 }
   @AfterSuite
	public void closeDriver(){
		driver.close();
	}

}