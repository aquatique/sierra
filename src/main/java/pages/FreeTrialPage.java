package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import properties.ExcelPropertyLoader;
import base.TestBase;

public class FreeTrialPage extends TestBase {

	Map<String, String> properties = new HashMap<String, String>();

	public FreeTrialPage() {
		super();
		ExcelPropertyLoader loader = new ExcelPropertyLoader();
		this.properties = loader.loadProperty("chrome", "TC2");
		System.out.println("Input: " + properties.toString());
	}

	public void createNewContact() throws InterruptedException {
		WebElement freeTrialIcon = findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement firstName = findElement(By.name("FirstName"), "First Name");
		Thread.sleep(3000);
		enterText(firstName, "First Name",
				String.valueOf(properties.get("first_name")));
		WebElement lastName = findElement(
				By.xpath("//input[@name='LastName']"), "Last Name");
		Thread.sleep(3000);
		enterText(lastName, "Last Name",
				String.valueOf(properties.get("last_name")));
		WebElement emailAdress = findElement(
				By.xpath("//input[@name='EmailAddress']"), "Email Address");
		enterText(emailAdress, "Email Address",
				String.valueOf(properties.get("email_address")));
		WebElement phoneNumber = findElement(
				By.xpath("//input[@name='PhoneNumber']"), "Phone Number");
		enterText(phoneNumber, "Phone Number",
				String.valueOf(properties.get("phone_number")));
		Thread.sleep(3000);
		Select dropdown = new Select(driver.findElement(By
				.xpath("//select[@name='LocationCode']")));
		dropdown.selectByVisibleText("United States");
		Thread.sleep(3000);
		WebElement chechBox = findElement(By.xpath("//input[@value='true']"),
				"Agreement");
		selectCheckBox(chechBox, "Agreement Terms");
		WebElement getStartedsubmitBtn = findElement(
				By.xpath("//span[@class='g-recaptcha-submit']"),
				"Get Started Button");
		clickButton(getStartedsubmitBtn, "Get Started Button");
	}

	public List<String> verifyAllErrorlMessage() throws InterruptedException {
		WebElement freeTrialIcon = findElement(
				By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),
				"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		Thread.sleep(3000);
		WebElement getStartedsubmitBtn = findElement(
				By.xpath("//span[@class='g-recaptcha-submit']"),
				"Get Started Button");
		clickButton(getStartedsubmitBtn, "Get Started Button");
		WebElement fnErrorMsg = findElement(
				By.xpath("//span[@id='signup-form-error-message-1']"),
				"First Name");
		String fnError = fnErrorMsg.getText();
		WebElement lnErrorMsg = findElement(
				By.xpath("//span[@id='signup-form-error-message-2']"),
				"Last Name");
		String lnError = lnErrorMsg.getText();
		WebElement emailErrorMsg = findElement(
				By.xpath("//span[@id='signup-form-error-message-3']"),
				"Email Address");
		String emailError = emailErrorMsg.getText();
		WebElement phErrorMsg = findElement(
				By.xpath("//span[@id='signup-form-error-message-4']"),
				"Phone Number");
		String phError = phErrorMsg.getText();
		List<String> arrString = new ArrayList<String>();
		arrString.add(fnError);
		arrString.add(lnError);
		arrString.add(emailError);
		arrString.add(phError);
		return arrString;
	}

	public String verifyWrongEmailMessage() throws InterruptedException {
		WebElement freeTrialIcon = findElement(
				By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),
				"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement firstName = findElement(
				By.xpath("//input[@name='FirstName']"), "First Name");
		enterText(firstName, "First Name",
				String.valueOf(properties.get("first_name")));
		WebElement lastName = findElement(
				By.xpath("//input[@name='LastName']"), "Last Name");
		enterText(lastName, "Last Name",
				String.valueOf(properties.get("last_name")));
		WebElement emailAdress = findElement(
				By.xpath("//input[@name='EmailAddress']"), "Email Address");
		enterText(emailAdress, "Email Address",
				String.valueOf(properties.get("wrong_email")));
		WebElement phoneNumber = findElement(
				By.xpath("//input[@name='PhoneNumber']"), "Phone Number");
		enterText(phoneNumber, "Phone Number",
				String.valueOf(properties.get("phone_number")));

		Select dropdown = new Select(driver.findElement(By
				.xpath("//select[@name='LocationCode']")));
		dropdown.selectByVisibleText("United States");
		WebElement chechBox = findElement(By.xpath("//input[@value='true']"),
				"Agreement");
		selectCheckBox(chechBox, "Agreement Terms");
		WebElement getStartedsubmitBtn = findElement(
				By.xpath("//span[@class='g-recaptcha-submit']"),
				"Get Started Button");
		clickButton(getStartedsubmitBtn, "Get Started Button");
		WebElement wrongEmailErrorMsg = findElement(
				By.id("signup-form-error-message-1"), "WrongEmail");
		System.out.println("hi:" + wrongEmailErrorMsg.getText());
		return wrongEmailErrorMsg.getText();
	}

	public void validateTermsPageTitle() throws InterruptedException {

		WebElement freeTrialIcon = findElement(
				By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),
				"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement termsOfUse = findElement(
				By.xpath("//a[contains(text(),'terms of use')]"),
				"Terms Of Use");
		clickButton(termsOfUse, "Terms Of Use Button");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		// This will return the number of windows opened by Webdriver and will
		// return Set of St//rings
		Set<String> s1 = driver.getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			// Here we will compare if parent window is not equal to child
			// window then we will close
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window)
						.getTitle());
				String name = driver.switchTo().window(child_window).getTitle();
				// System.out.println(name);
				Assert.assertEquals(name, "Terms of Use | Xero US");
				driver.close();
			}

		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);

	}

	public void validatePrivacyPageTitle() throws InterruptedException {
		WebElement freeTrialIcon = findElement(
				By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),
				"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement privacyPolicy = findElement(
				By.xpath("//a[contains(text(),'privacy notice')]"),
				"Privacy Policy");
		clickButton(privacyPolicy, "Privacy Policy Button");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		// This will return the number of windows opened by Webdriver and will
		// return Set of St//rings
		Set<String> s1 = driver.getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			// Here we will compare if parent window is not equal to child
			// window then we will close
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window)
						.getTitle());
				String name = driver.switchTo().window(child_window).getTitle();
				// System.out.println(name);
				Assert.assertEquals(name, "Privacy Notice | Xero US");
				driver.close();
			}

		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);
	}

	public void validateFullOfferPageTitle() throws InterruptedException {
		WebElement freeTrialIcon = findElement(
				By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),
				"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement offerLink = findElement(
				By.xpath("//a[contains(text(),'offer details')]"), "Offer Link");
		clickButton(offerLink, "Full Offer Button");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		// This will return the number of windows opened by Webdriver and will
		// return Set of St//rings
		Set<String> s1 = driver.getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			// Here we will compare if parent window is not equal to child
			// window then we will close
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window)
						.getTitle());
				String name = driver.switchTo().window(child_window).getTitle();
				// System.out.println(name);
				Assert.assertEquals(name, "Offer details | Xero US");
				driver.close();
			}

		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);
	}

	public String validateAccountAndBookeeperPageTitle()
			throws InterruptedException {
		WebElement freeTrialIcon = findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"Free Trial ");
		clickButton(freeTrialIcon, "Free Trial Button");
		WebElement accountantBookkeeper = findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"),"Accountant & Bookkeeper");
		clickButton(accountantBookkeeper, "Accounts And Bookkeeper");
		Thread.sleep(3000);
		return driver.getTitle();
	}

}
