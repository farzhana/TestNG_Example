package test1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class LoginTest {
	
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		report = new ExtentReports("ExtentReport.html");
		
	}
	
	@Parameters({"username" , "password"})
	@Test
	public void Login(String uname , String pass) {
		
		test = report.startTest("Login Test Case");
		
					
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		test.log(LogStatus.PASS,"Succesfully clicked on login button");
		
		WebElement Username = driver.findElement(By.name("user_login"));
		
		Username.sendKeys(uname);
		
		test.log(LogStatus.PASS,"Succesfully entered user name");
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		
		password.sendKeys(pass);
		
		test.log(LogStatus.PASS,"Succesfully entered password");

		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		
		RememberMe.click();

		WebElement Login = driver.findElement(By.name("btn_login"));
		
		Login.click();
		
		test.log(LogStatus.PASS,"Succesfully clicked on login link");
		
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActMsg = Error.getText();		
		String ExpMsg = "The email or password you have entered is invalid.";
		
				
		Assert.assertTrue(Error.isDisplayed());
		
		soft.assertEquals(ActMsg,  ExpMsg);
		
		System.out.println("After soft assertion");
		
	
	/*	try {
			Assert.assertEquals(ActMsg , ExpMsg);
			test.log(LogStatus.PASS,"Actual message And Expected Message matches");
		}
		catch(Throwable e) {
			test.log(LogStatus.FAIL,"Actual message And Expected Message does not matches");
		}
		*/
	}
		
		
		@AfterMethod
		public void teardown() {
								
			report.endTest(test);
			report.flush();
			
			driver.quit();
			
			soft.assertAll();
		}
		
	

}
