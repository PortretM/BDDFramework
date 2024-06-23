package base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {
	public static WebDriver driver;
	WebDriverWait wait;
	private JavascriptExecutor js = (JavascriptExecutor) driver;

	public static int TIME_FOR_SLEEP = 3;

	public static void initialization(String browser, String url) {


		if (browser.equals("chrome")) {
			driver = new ChromeDriver();


		} else if (browser.equals("firefox")) {
			
			driver = new FirefoxDriver();

		}
		else if (browser.equals("edge")) {
			
			driver = new EdgeDriver();

		}
		implicitWait(20);
		driver.manage().window().maximize();
		driver.get(url);

	}


	public static void implicitWait(int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
	}
	
	public void refresh(int timeInSecond) {
		sleep(timeInSecond);
		driver.getCurrentUrl();
		driver.navigate().refresh();
	}

	public void waitforElementClickable(WebElement webelement) {
		
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}
	public void waitforElementVisible(WebElement webelement,int timeinSec) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeinSec));
		List<WebElement> ab=	wait.until(ExpectedConditions.visibilityOfAllElements(webelement));
		Assert.assertEquals(ab.size(), 1);
		
	}
	public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

public   static String getCurrentDate() {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  
	System.out.println(dtf.format(now));  
	return dtf.format(now);
}
	public void sleep(int timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void QuitDriver(){
		driver.quit();
	}
}
