package ShoppingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCart {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		report = new ExtentReports("ExtentReport.html");
		
	}
	
	@Parameters({"username" , "password"})
	@Test
	public void Login(String uname , String pass) {
		
		test = report.startTest("Login Test Case");
						
				
		WebElement Username = driver.findElement(By.name("user-name"));
		
		Username.sendKeys(uname);
		
		test.log(LogStatus.PASS,"Succesfully entered user name");
		
		WebElement password = driver.findElement(By.name("password"));
		
		password.sendKeys(pass);
		
		test.log(LogStatus.PASS,"Succesfully entered password");

		WebElement Login = driver.findElement(By.name("login-button"));
		
		Login.click();
		
		test.log(LogStatus.PASS,"Succesfully clicked on login link");
	}
	
		@Test(dependsOnMethods = "Login")
		public void AddCart() {
			
									
			WebElement addtocart = driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
			addtocart.click();
			
		}
		
		
		@AfterMethod
		public void teardown() {
			
										
			report.endTest(test);
			report.flush();
						
			driver.quit();
		}
			
			
		

}
