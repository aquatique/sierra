package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	static WebDriver driver;
	static ExtentReports report;
	protected static ExtentTest  logger;
	/*
	 * Name: InitializaDriver
	 * Description:Driver initialization.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 30 March 2019
	 *  LAst Modified Date: 30 March 2019
	 * */
	public static void InitializeDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		System.setProperty("webdriver.gecko.driver",  "C:\\Data\\Selenium\\geckodriver.exe");

		driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		String browserName = "chrome";
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*
	 * Name: Launch
	 * Description: launching the page.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 30 March 2019
	 *  LAst Modified Date: 30 March 2019
	 * */

	public static void Launch(String url, String name) {
		// open chrome browser with this url
		driver.get(url);
		driver.manage().window().maximize();
		logger = report.startTest(name);
	}
	/*
	 * Name: ReportGenerate
	 * Description: Report generating.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 30 March 2019
	 *  LAst Modified Date: 30 March 2019
	 * */
	public static void ReportGenerate(String reporturl)
	{
		System.setProperty("selenium.root", "/Users/surajitpaul/Documents/Selenium");
		String root = System.getProperty("selenium.root");
		//Initialize Extent Report
		String path = root + reporturl;
		report = new ExtentReports(path);
	}
}
