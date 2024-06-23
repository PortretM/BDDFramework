package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import SaucePages.Homepage;
import SaucePages.LoginPage;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition  extends TestBase  {

	LoginPage loginPage;
	Homepage homepage;
	@Given("User on login Page {string}")
	public void user_on_login_page(String url) {
		// Write code here that turns the phrase above into concrete actions
		driver=new ChromeDriver();
		driver.get(url);
		loginPage = new LoginPage();
		loginPage.verifySwagLabsLogo(5);

	}

	@When("User has valid {string} and {string}")
	public void user_has_valid_username_and_password(String username,String passcode) {
		loginPage.enterCredentials(username, passcode);


	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		homepage=loginPage.clickLogin();
	}

	@Then("User navigates to home page")
	public void user_navigates_to_home_page() throws InterruptedException {

		homepage.verifySwagLabsLogo(30);
		
		}
	
	@Then("Select Sorting criteria by {string}")
	public void select_sorting_criteria_by(String sortType) throws InterruptedException {
		homepage.selectSortingType(sortType);
		Thread.sleep(10000);
		Assert.assertEquals(homepage.verifyCorrectSortingType(sortType), sortType);
	
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
	@And("User clicks on cart")
	public void user_clicks_on_cart() {
		homepage.clickCheckoutButton();
	}

	@Then("User goes to cart Page and see no items are added by default")
	public void user_goes_to_cart_page_and_see_no_items_are_added_by_default() {
		Assert.assertFalse(homepage.cartItemsisDisplayed());

	}
	
}
