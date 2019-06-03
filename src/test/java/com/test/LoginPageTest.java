package com.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import properties.ExcelPropertyLoader;
import base.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	Map<String, String> properties = new HashMap<String, String>();
	public LoginPageTest(){
		super();
		ExcelPropertyLoader loader = new ExcelPropertyLoader();
		this.properties = loader.loadProperty("chrome", "TC1");
	}
	
	@BeforeClass
	public void cleanUp(){
		String path = "test-output/extent_report.html";
		File reportFile = new File(path);
		if(reportFile.exists()){
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

	@Test(priority = 1, enabled = true)
	public void LogoImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
		if(flag){
			logger.log(LogStatus.PASS,  "Image found on the page.");
		}
		else
		{
			logger.log(LogStatus.FAIL,  "Image not found on the page.");
		}
			
		
	}

	@Test(priority = 2, enabled = true)
	public void loginTest() throws InterruptedException {
		loginPage.loginTest();
	}

	@Test(priority = 3, enabled = true)
	public void verifyWrongPasswordMessage() {
		String passmsg = loginPage.verifyWrongPasswordMessage();
		Assert.assertEquals(passmsg, "Your email or password is incorrect");
	}

	@Test(priority = 4, enabled = true)
	public void verifyWrongEmailMessage() throws InterruptedException {
		String passmsg = loginPage.verifyWrongEmailMessage();
		Assert.assertEquals(passmsg, "Your email or password is incorrect");
	}

	@Test(priority = 5, enabled = false)
	public void forgotPasswordTest() {
		loginPage.forgotPasswordTest();
	}

	@AfterMethod
	public void teardown() {
		EndReport();
	}

}
