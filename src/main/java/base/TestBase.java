package base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import properties.ExcelPropertyLoader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static WebDriver driver;
	static ExtentReports report;
	protected static ExtentTest logger;
	
	
	/*
	 * Name: InitializaDriver Description:Driver initialization.
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */
	public void initializeDriver() {
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		//driver = new ChromeDriver();
		String browserName = "Chrome";
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	/*
	 * Name: Launch Description: launching the page.
	 * 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */

	public static void launch(String url, String name) {
		// open chrome browser with this url
		driver.get(url);
		driver.manage().window().maximize();
		logger = report.startTest(name);
	}

	/*
	 * Name: ReportGenerate Description: Report generating. 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */
	public static void reportGenerate(String reporturl) {
		//System.setProperty("selenium.root",
		//		"/Users/surajitpaul/Documents/Selenium");
		//String root = System.getProperty("selenium.root");
		// Initialize Extent Report
		//String path = root + reporturl;
		report = new ExtentReports(reporturl, false);
	}

	/*
	 * Name: findElement Description: finding webelement. Arguments: ObjectName
	 * : Name of the object textValue: Value to be entered
	 * 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */

	public static WebElement findElement(By location, String objName) {
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			logger.log(LogStatus.PASS, objName + "found on the page.");
			System.out.println("Pass: " + objName + " found on the page.");
		} catch (NoSuchElementException errMessage) {
			logger.log(LogStatus.FAIL, objName + " could not be found");
			System.out.println("Fail: " + objName
					+ " cound not be found on the page.");
		}
		return obj;
	}

	/*
	 * Name: enterText Description: Enter the text value in to theText object on
	 * the page.
	 * 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 *30 March 2019
	 */
	public static void enterText(WebElement obj, String objName,
			String textValue) {
		if (obj == null){
			System.out.println("null");
			return;
		}
		if (obj.isDisplayed()) {
			obj.sendKeys(textValue);
			logger.log(LogStatus.PASS, objName + "entered sucessfully");
			System.out.println("Pass: " + textValue + " entered in " + objName);
		} else {
			logger.log(LogStatus.FAIL, objName + " does not exit");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}

	/*
	 * Name: clickButton Description: clicking button.
	 * 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */
	public static void clickButton(WebElement obj, String objName) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			obj.click();

			logger.log(LogStatus.PASS, objName + "is clicked");
			System.out.println("Pass: Button " + objName + " is clicked");
		} else {
			logger.log(LogStatus.FAIL, objName + " could not be found");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}

	/*
	 * Name: selectCheckBox Description: selecting checkbox.
	 * 
	 * Created By: Madhushree Creation Date: 30 March 2019 LAst Modified Date:
	 * 30 March 2019
	 */

	public static void selectCheckBox(WebElement obj, String objName) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			if (!obj.isSelected()) {
				obj.click();
			}
			logger.log(LogStatus.PASS, objName + "is selected");
			System.out.println("Pass: checkbox " + objName + " is selected");
		} else {
			logger.log(LogStatus.FAIL, objName + " could not be found");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}

	public static void EndReport() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}

}
