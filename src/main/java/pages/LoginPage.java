package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import properties.ExcelPropertyLoader;
import base.TestBase;

public class LoginPage extends TestBase {

	Map<String, String> properties = new HashMap<String, String>();
	
	public LoginPage(){
		super();
		ExcelPropertyLoader loader = new ExcelPropertyLoader();
		this.properties = loader.loadProperty("chrome", "TC1");
	}
	
	
	public boolean validateImage(){
		WebElement logo = findElement(By.xpath("//a[@class='logo']"), "logo");
		return logo.isDisplayed();
	}
	
	public void loginTest() {
		WebElement un = findElement(By.id("email"), "username");
		WebElement pass = findElement(By.id("password"), "password");
		WebElement login = findElement(By.id("submitButton"), "Login");
		enterText(un, "User Name", String.valueOf(properties.get("user_name")));
		enterText(pass, "Password", String.valueOf(properties.get("password1")));
		clickButton(login, "Login");
	}
	
	public String verifyWrongPasswordMessage(){
		WebElement un = findElement(By.id("email"), "username");
		WebElement pass = findElement(By.id("password"), "password");
		WebElement login = findElement(By.id("submitButton"), "Login");
		enterText(un, "User Name", String.valueOf(properties.get("user_name")));
		enterText(pass, "Password", String.valueOf(properties.get("password2")));
		clickButton(login, "Login");
		WebElement wrongPass = findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "logo");
		System.out.println(wrongPass.getText());
		return wrongPass.getText();
	}
	
	public String verifyWrongEmailMessage() throws InterruptedException{
		WebElement un = findElement(By.id("email"), "username");
		WebElement pass = findElement(By.id("password"), "password");
		WebElement login = findElement(By.id("submitButton"), "Login");
		System.out.println("User Name 2 - " + properties.get("user_name_2"));
		enterText(un, "User Name", String.valueOf(properties.get("user_name_2")));
		enterText(pass, "Password", String.valueOf(properties.get("password")));
		clickButton(login, "Login");
		WebElement wrongEmail = findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "logo");
		System.out.println(wrongEmail.getText());
		return wrongEmail.getText();
	}
	
	public void forgotPasswordTest() {

		WebElement forgotPassword =findElement(By.xpath("//a[@class='forgot-password-advert']"),"User Name");
		clickButton(forgotPassword, "Forgot Password Button");
		WebElement userName =findElement(By.xpath("//input[@id='UserName']"), "User Name");
		enterText(userName, "User Name", String.valueOf(properties.get("user_name")));
		WebElement sendLinkBtn = findElement(By.xpath("//span[contains(@class,'text')]"), "Send Link Button");
		clickButton(sendLinkBtn, "Send Link Button");
	}
}
