package SaucePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Homepage extends TestBase {
	@FindBy(xpath = "//div[@class='shopping_cart_container']//preceding-sibling::div//div[text()='Swag Labs']")
	@CacheLookup
	WebElement swagLabsLogo;
	
	@FindBy(xpath = "//span[text()='Products']")
	@CacheLookup
	WebElement productsLogo;
	
	@FindBy(id="react-burger-menu-btn")
	@CacheLookup
	WebElement menuBtn;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	@CacheLookup
	WebElement checkoutButton;
	
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	@CacheLookup
	WebElement shoppingCartitems;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	@CacheLookup
	WebElement sortingCriteria;
	
	@FindBy(xpath="//span[@class='active_option']")
	@CacheLookup
	WebElement active_SortingOption;
	
	
	
//	@CacheLookup
//	By productsLogo=By.xpath("//span[text()='Products']");

	public Homepage() {
		PageFactory.initElements(driver, this);
	}


	public void verifySwagLabsLogo(int timeinSec){
		waitforElementVisible(swagLabsLogo, timeinSec);
		waitforElementVisible(productsLogo, timeinSec);
		
	}
	public void clickCheckoutButton(){
		checkoutButton.click();
		
	}
	
	public String countCartItems() {
		
		return shoppingCartitems.getText();
		
	}

	public boolean cartItemsisDisplayed() {
		
		return isElementDisplayed(shoppingCartitems);
		
	}
	
	
	public  void selectSortingType(String  sortCriteria) {
	      Select drop = new Select(sortingCriteria);
	      drop.selectByVisibleText(sortCriteria);  
	      
	}
	
	public  String  verifyCorrectSortingType(String  sortCriteria) {
		return active_SortingOption.getText();
		
	      
	      
	}

}
