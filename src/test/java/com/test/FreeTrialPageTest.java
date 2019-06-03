package com.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FreeTrialPage;
import properties.ExcelPropertyLoader;
import base.TestBase;

public class FreeTrialPageTest extends TestBase {
	FreeTrialPage freeTrial = new FreeTrialPage();
	Map<String, String> properties = new HashMap<String, String>();

	public FreeTrialPageTest() {
		super();
		ExcelPropertyLoader loader = new ExcelPropertyLoader();
		this.properties = loader.loadProperty("chrome", "TC2");
	}

	@BeforeClass
	public void cleanUp() {
		String path = "test-output/extent_report.html";
		File reportFile = new File(path);
		if (reportFile.exists()) {
			reportFile.delete();
		}
	}

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		String reportUrl = "test-output/extent_report.html";
		reportGenerate(reportUrl);
		launch(String.valueOf(properties.get("url")), "LoginPage");
	}

	@Test(priority = 6, enabled = true)
	public void createNewContact() throws InterruptedException {
		freeTrial.createNewContact();
	}

	@Test(priority = 7, enabled = true)
	public void verifyErrorMessage() throws InterruptedException {
		List<String> errors = freeTrial.verifyAllErrorlMessage();

		String error1 = errors.get(0);
		String error2 = errors.get(1);
		String error3 = errors.get(2);
		String error4 = errors.get(3);
		Assert.assertEquals(error1, "First name can't be empty");
		Assert.assertEquals(error2, "Last name can't be empty");
		Assert.assertEquals(error3, "Email address can't be empty");
		Assert.assertEquals(error4, "Phone number can't be empty");
	}

	@Test(priority = 8, enabled =true )
	public void verifyWrongEmailMessage() throws InterruptedException {
		String emailErrorMsg = freeTrial.verifyWrongEmailMessage();
		Assert.assertEquals(emailErrorMsg, "Email address is invalid");
	}

	@Test(priority = 9, enabled = true)
	public void termsPageTitleTest() throws InterruptedException {
		freeTrial.validateTermsPageTitle();
	}

	@Test(priority = 10, enabled = true)
	public void privacyPageTitleTest() throws InterruptedException {
		freeTrial.validatePrivacyPageTitle();
	}

	@Test(priority = 11, enabled = true)
	public void fullOfferPageTitleTest() throws InterruptedException {
		freeTrial.validateFullOfferPageTitle();
	}

	@Test(priority = 12, enabled = true)
	public void accountsAndBookkeeperPageTitleTest()throws InterruptedException {
		String title = freeTrial.validateAccountAndBookeeperPageTitle();
		Assert.assertEquals(title,"Sign up for the Xero Partner Program | Xero US");
	}

	@AfterMethod
	public void teardown() {
		EndReport();
	}
}
