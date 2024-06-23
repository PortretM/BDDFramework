package SaucePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class LoginPage  extends TestBase{
	
	@FindBy(xpath = "//div[text()='Swag Labs']")
	@CacheLookup
	WebElement swagLabsLogo;
	
	@FindBy(xpath = "//p[text()='Log in']")
	WebElement loginText;
	
	@FindBy(id = "user-name")
	WebElement usernameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "login-button")
	WebElement loginButton;

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}


	public void verifySwagLabsLogo(int timeinSec){
		waitforElementVisible(swagLabsLogo, timeinSec);
		
	}
	
	public void enterCredentials(String username,String passcode){
		usernameField.sendKeys(username);
		passwordField.sendKeys(passcode);
		
	}
	
	public Homepage clickLogin(){
		
		Assert.assertTrue(loginButton.isEnabled());
		waitforElementClickable(loginButton);
		loginButton.click();
		return new Homepage();
		
	}
	
	public Homepage dologin(String username,String passcode){
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(passcode);
		Assert.assertTrue(loginButton.isEnabled());
		waitforElementClickable(loginButton);
		loginButton.click();
		return new Homepage();
		
	}
}
