package com.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FreeTrialPage;
import pages.HomePage;
import pages.LoginPage;
import properties.ExcelPropertyLoader;
import base.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	Map<String, String> properties = new HashMap<String, String>();
	
public HomePageTest(){
	super();
	ExcelPropertyLoader loader = new ExcelPropertyLoader();
	this.properties = loader.loadProperty("chrome", "TC3");
	this.homePage = new HomePage();
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
		loginPage.loginTest();
	}
	
	@Test(priority = 13, enabled = false)
	public void LogoImageTest() throws InterruptedException {
		boolean flag = homePage.verifyDashboardPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 14, enabled = true)
	public void verifyContacts() {
		homePage.contacts();
	}
	
	@Test(priority = 15, enabled = true)
	public void verifybusiness() {
		homePage.business();
	}
	
	@Test(priority = 16, enabled = true)
	public void verifyAccounting() {
		homePage.accounting();
	}
	
	@Test(priority = 17, enabled = true)
	public void verifyNewButton() {
		homePage.newSymbol();
	}
	
	@Test(priority = 18, enabled = true)
	public void verifySettings() throws InterruptedException {
		String title = homePage.settings();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "Xero | | Teckarch");
	}
	
	@Test(priority = 19, enabled = true)
	public void verifyFiles() throws InterruptedException {
		String title=homePage.files();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "Xero | Files | Teckarch");
	}
	
	@Test(priority = 20, enabled = true)
	public void verifyNotifications() {
		homePage.notification();
	}
	
	@Test(priority = 21, enabled = true)
	public void verifyHelp() {
		homePage.help();
	}
	
	@Test(priority = 22, enabled = true)
	public void verifySearch() {
		homePage.search();
	}
	
	@Test(priority = 23, enabled = true)
	public void verifyLogOut() {
		 homePage.logOut();
		//Assert.assertEquals(title, "gopala.anumanchipalli@gmail.com");
	}
	
	@Test(priority = 24, enabled = false)
	public void uploadImage() throws InterruptedException {
		homePage.uploadImage();	
	}
	
	@Test(priority = 25, enabled = false)
	public void addOrg() throws InterruptedException {
		String label =homePage.addOrganization();
		System.out.println("Label: " + label);
		Assert.assertEquals(label, "Xero | Dashboard | self");
	}
	
	@Test(priority = 26, enabled = true)
	public void verifyBuy() throws InterruptedException {
		String label =homePage.buyNow();
		Assert.assertEquals(label, "My Xero | Add your organization");
	}
	
	@Test(priority = 27, enabled = false)
	public void buyTC8c() throws InterruptedException {
		homePage.buyNow8c();	
	}
	
	@AfterMethod
	public void teardown() {
		EndReport();
	}
}
