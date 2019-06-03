package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import properties.ExcelPropertyLoader;
import base.TestBase;

public class HomePage extends TestBase {
	Map<String, String> properties = new HashMap<String, String>();

	public HomePage() {
		super();
		ExcelPropertyLoader loader = new ExcelPropertyLoader();
		this.properties = loader.loadProperty("chrome", "TC3");
		System.out.println("Input: " + properties.toString());
	}

	public boolean verifyDashboardPage() throws InterruptedException{
		boolean logoFound = false;
		WebElement dashboard = findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"), "Dashboard");
		clickButton(dashboard, "Dashboard");
		Thread.sleep(3000);
		WebElement logo = findElement(By.xpath("//img[@class='xdash-setupwidget__setup--welcome-wave___1QMzU']"), "logo"); 
		if(logo != null){
			logoFound = logo.isDisplayed();
		}
		return logoFound;
	}

	public void accounting(){
		WebElement accounting = findElement(By.xpath("//button[contains(text(),'Accounting')]"), "Accounting");
		clickButton(accounting, "Accounting");
		findElement(By.xpath("//a[contains(text(),'Reports')]"), "Reports").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Bank accounts')]"), "Bank Account").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Advanced')]"), "Advanced").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Account Transactions')]"), "Account Transactions").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Aged Receivables Summary')]"), "Aged Receivables Summary").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Balance Sheet')]"), "Balance Sheet").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Income Statement')]"), "Income Statement").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Sales Tax Report')]"), "Sales Tax Report").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Chart of accounts')]"), "Chart of accounts'").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Fixed assets')]"), "Fixed assets").isDisplayed();
	}

	public void contacts(){
		WebElement contacts = findElement(By.xpath("//button[contains(text(),'Contacts')]"), "Contacts");
		clickButton(contacts, "Contacts");
		WebElement allContacts = findElement(By.xpath("//a[contains(text(),'All contacts')]"), "All contacts");
		WebElement customers = findElement(By.xpath("//a[contains(text(),'Customers')]"), "Customers");
		WebElement suppliers = findElement(By.xpath("//a[contains(text(),'Suppliers')]"), "Suppliers");
	}

	public void business(){
		WebElement business = findElement(By.xpath("//button[contains(text(),'Business')]"), "Business");
		clickButton(business, "Business");
		WebElement invoices = findElement(By.xpath("//a[contains(text(),'Invoices')]"), "Invoices");
		WebElement quotes = findElement(By.xpath("//a[contains(text(),'Quotes')]"), "Quotes");
		WebElement salesOverview = findElement(By.xpath("//a[contains(text(),'Sales overview')]"), "Sales overview");
		WebElement billstopay = findElement(By.xpath("//a[contains(text(),'Bills to pay')]"), "Bills to pay");
		WebElement purchaseOrders = findElement(By.xpath("//a[contains(text(),'Purchase orders')]"), "Purchase orders");
		WebElement purchasesOverview = findElement(By.xpath("//a[contains(text(),'Purchases overview')]"), "Purchases overview");
		WebElement expenseclaims = findElement(By.xpath("//a[contains(text(),'Expense claims')]"), "Expense claims");
		WebElement productsandservices = findElement(By.xpath("//a[contains(text(),'Products and services')]"), "Products and services");
		WebElement checks = findElement(By.xpath("//a[contains(text(),'Checks')]"), "Checks");

	}
	public String settings() throws InterruptedException{
		WebElement company = findElement(By.xpath("//span[@class='xrh-appbutton--text']"), "Company");
		clickButton(company, "Company");
		Thread.sleep(3000);
		WebElement settings = findElement(By.xpath("//a[contains(text(),'Settings')]"), "Settings");
		clickButton(settings, "Settings");
		System.out.println("settings"+ driver.getTitle());
		return driver.getTitle();

	}
	public void newSymbol(){
		WebElement newBtn = findElement(By.xpath("//button[@title='Create new']"), "New");
		clickButton(newBtn, "New Button");
		WebElement invoice = findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Invoice')]"), "Invoice");
		WebElement bill = findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Bill')]"), "Bill");
		WebElement contact = findElement(By.xpath("//a[contains(text(),'Contact')]"), "Contact");
		WebElement quote = findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Quote')]"), "Quote");
		WebElement purchaseOrder = findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Purchase order')]"), "Purchase Order");
		WebElement spendMoney = findElement(By.xpath("//a[contains(text(),'Spend money')]"), "Spend Money");
		WebElement receiveMoney = findElement(By.xpath("//a[contains(text(),'Receive money')]"), "Receive Money");
		WebElement transferMoney = findElement(By.xpath("//a[contains(text(),'Transfer money')]"), "Transfer Money");
	}

	public String files() throws InterruptedException{
		WebElement company = findElement(By.xpath("//span[@class='xrh-appbutton--text']"), "Company");
		clickButton(company, "Company");	
		Thread.sleep(3000);
		WebElement files = findElement(By.xpath("//a[contains(text(),'Files')]"), "Files");
		clickButton(files, "Files");
		System.out.println("file: "+ driver.getTitle());
		return driver.getTitle();
	}

	public void notification(){
		WebElement notification = findElement(By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"), "Notification");
		clickButton(notification, "Notification");
	}

	public void search(){
		WebElement search = findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"), "Search");
		clickButton(search, "Search");
		//WebElement searchBox = findElement(By.xpath("//input[@id='queryInput']"), "Search Box");
	}

	public void help(){
		WebElement help = findElement(By.xpath("//button[@title='Help']//*[@class='xrh-icon xrh-icon-svg']"), "Help");
		clickButton(help, "help");
		WebElement helpTab = findElement(By.xpath("//h3[contains(text(),'Help')]"), "Help Tab");
	}

	public void logOut(){
		WebElement logout1 = findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-7']"), "LogOut1");
		clickButton(logout1, "LogOutFirst Button");	
		WebElement logout = findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]"), "Log Out");
		clickButton(logout, "Logout");
		//WebElement userName = findElement(By.xpath("//input[@id='email']"), "UserName");
		//String userNameText = userName.getText();
		//System.out.println("email: "+ userNameText);
		//return userNameText;
	}

	public void uploadImage() throws InterruptedException{
//
//		WebElement profileStart = findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-7']"), "Profile Start");
//		clickButton(profileStart, "Profile Start");
//		WebElement profile = findElement(By.xpath("//span[@class='xrh-verticalmenuitem--subheading']"), "Profile");
//		clickButton(profile, "Profile");	
//		WebElement uploadImage = findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"), "Upload Image");
//		enterText(uploadImage, "uploadImage","pic.jpg");
		//uploadImage.sendKeys("/⁨Users⁩/surajitpaul⁩/⁨Documents⁩/Selenium⁩/IMG_2590.JPG");
	//WebElement browse = findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"), "Browse Image");
	//clickButton(browse, "browse");
	//WebElement browse = findElement(By.xpath("//input[@name='file']"), "Profile Start");
	
//WebElement uploadBtn = findElement(By.xpath("//div[@id='button-1178']"), "Upload Button");
//clickButton(uploadBtn, "Upload Image");



WebElement editprofile=findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"),"editprofile");
clickButton(editprofile,"editprofilebtn");
//upload image
WebElement upload=driver.findElement(By.xpath("//div[@id='button-1043']"));
clickButton(upload, "Upload Image");

WebElement browse=driver.findElement(By.xpath("//input[@name='file']"));
enterText(browse, "uploadImage","pic.jpg");
//browse.sendKeys("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\picture.jpg");
//waitstatement();
Thread.sleep(3000);
WebElement Upload1=findElement(By.xpath("//div[@class='x-btn blue x-exclude x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"),"editprofile");
//WebElement Upload1=driver.findElement(By.xpath("//div[@class='x-btn blue x-exclude x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
clickButton(Upload1, "Upload1 Image");
Upload1.click();


if(Upload1.isDisplayed())
{
	 //Logger.log(LogStatus.PASS,"Profile Picture Updated Successfully");
	System.out.println("Success");
}
else
{
	 //Logger.log(LogStatus.FAIL,"Profile Picture not Updated Successfully");
	System.out.println("not success");
}




}



	

	public String addOrganization() throws InterruptedException{
		WebElement company = findElement(By.xpath("//span[@class='xrh-appbutton--text']"), "Company");
		clickButton(company, "Company");	
		WebElement company1 = findElement(By.xpath("//button[contains(text(),'Change organization')]"), "Company1");
		clickButton(company1, "Company");
		Thread.sleep(3000);
		WebElement newOrganization = findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"), "New Organization");
		clickButton(newOrganization, "New Organization");
		Thread.sleep(3000);
		WebElement organisationName = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "Organisation Name");
		enterText(organisationName, "organisation Name",String.valueOf(properties.get("organisation_name")));
		Thread.sleep(3000);
		WebElement country = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "Country");
		enterText(country, "Country",String.valueOf(properties.get("country")));
		WebElement timeSelect = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "Country");
		enterText(timeSelect, "Time",String.valueOf(properties.get("time_zone")));
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "Country");
		enterText(industry, "industry",String.valueOf(properties.get("industry")));
		WebElement startBtn = findElement(By.xpath("//a[@id='simplebutton-1035']"), "Start Button");
		clickButton(startBtn, "Start Button");
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public String buyNow() throws InterruptedException{
		WebElement company = findElement(By.xpath("//span[@class='xrh-appbutton--text']"), "Company");
		clickButton(company, "Company");	
		WebElement company1 = findElement(By.xpath("//button[contains(text(),'Change organization')]"), "Company1");
		clickButton(company1, "Company");
		Thread.sleep(3000);
		WebElement newOrganization = findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"), "New Organization");
		clickButton(newOrganization, "New Organization");
		Thread.sleep(3000);
		WebElement organisationName = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "Organisation Name");
		enterText(organisationName, "organisation Name",String.valueOf(properties.get("organisation_name")));
		Thread.sleep(3000);
		WebElement country = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "Country");
		enterText(country, "Country",String.valueOf(properties.get("country")));
		WebElement timeSelect = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "Country");
		enterText(timeSelect, "Time",String.valueOf(properties.get("time_zone")));
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "Country");
		enterText(industry, "industry",String.valueOf(properties.get("industry")));
		WebElement buyNow = findElement(By.xpath("//a[@id='simplebutton-1036']"), "buyNow Button");
		clickButton(buyNow, "Buy Now");
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void buyNow8c() throws InterruptedException{
		WebElement company = findElement(By.xpath("//span[@class='xrh-appbutton--text']"), "Company");
		clickButton(company, "Company");	
		WebElement company1 = findElement(By.xpath("//button[contains(text(),'Change organization')]"), "Company1");
		clickButton(company1, "Company");
		Thread.sleep(3000);
		WebElement newOrganization = findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"), "New Organization");
		clickButton(newOrganization, "New Organization");
		Thread.sleep(3000);
		WebElement organisationName = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "Organisation Name");
		enterText(organisationName, "organisation Name",String.valueOf(properties.get("organisation_name")));
		Thread.sleep(3000);
		WebElement country = findElement(By.xpath("//input[@name='CountryCode']"), "Country");
		enterText(country, "Country",String.valueOf(properties.get("country")));
		Thread.sleep(3000);
		WebElement timeSelect = findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']"), "Time");
		enterText(timeSelect, "Time",String.valueOf(properties.get("time_zone")));
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "Country");
		enterText(industry, "industry",String.valueOf(properties.get("industry")));
		WebElement buyNow = findElement(By.xpath("//a[@id='simplebutton-1036']"), "BuyNow Button");
		clickButton(buyNow, "BuyNow");
		Thread.sleep(3000);
		WebElement Early = findElement(By.xpath("//section[@id='Early']//div[@class='xui-padding-top xui-padding-left']"),"Radio Button");
		clickButton(Early, "Early");
		Thread.sleep(3000);
		WebElement continueBtn = findElement(By.xpath("//button[@id='continueButton']"), "continueBtncontinueBtn Button");
		clickButton(continueBtn, "Continue");
		Thread.sleep(3000);
		WebElement contactAddress = findElement(By.name("contactAddress"), "contactAddress");
		enterText(contactAddress, "contactAddress",String.valueOf(properties.get("contact_address")));
		WebElement contactCity = findElement(By.name("contactCity"), "contactCity");
		enterText(contactCity, "contactCity",String.valueOf(properties.get("contact_city")));
		WebElement postal = findElement(By.xpath("//div[@id='postalAddress']//button[@type='button']"), "postal");
		clickButton(postal, "postal");
		WebElement postalselect = findElement(By.xpath("//li[@id='California']//button[@type='button']"), "postalselect");
		postalselect.click();
		WebElement contactPostalCode = findElement(By.id("contactPostalCode"), "contactPostalCode");
		enterText(contactPostalCode,"contactPostalCode", String.valueOf(properties.get("postal")));
		WebElement continueButton1 = findElement(By.xpath("//button[contains(text(),'Continue to Review & Pay')]"), "continueButton1");
		clickButton(continueButton1, "continueButton1");
		Thread.sleep(3000);
		WebElement frame=findElement(By.xpath("//*[@id=\"stripe-card-number\"]/div/iframe"),"card number iframe");
		driver.switchTo().frame(frame);
		System.out.println("Switched to frame"+ frame);
		WebElement cardnumber = findElement(By.name("cardnumber"), "cardnumber");
		enterText(cardnumber, "cardnumber",String.valueOf(properties.get("cardNumber")));
		driver.switchTo().defaultContent();
		WebElement frame1=findElement(By.xpath("//*[@id=\"stripe-card-expiry\"]/div/iframe"),"card expiry iframe");
		driver.switchTo().frame(frame1);
		WebElement cardexpiry = findElement(By.name("exp-date"), "cardexpiry");
		enterText(cardexpiry, "cardexpiry",String.valueOf(properties.get("expiry")));
		driver.switchTo().defaultContent();
		WebElement frame2=findElement(By.xpath("//*[@id=\"stripe-card-cvc\"]/div/iframe"),"card cvc iframe");
		driver.switchTo().frame(frame2);
		WebElement cardcvc = findElement(By.name("cvc"), "cardcvc");
		enterText(cardcvc, "cardcvc",String.valueOf(properties.get("cvc")));
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement cardholdername = findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"), "card holder name");
		enterText(cardholdername, "cardholdername",String.valueOf(properties.get("name")));
		WebElement continueButton2 = findElement(By.id("continueButton"), "Confirm Purchase");
		clickButton(continueButton2, "Confirm Purchase");
	}

}

