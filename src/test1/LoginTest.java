package test1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import Pages.LoginPage;

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
	public void LoginTst(String uname , String pass) {
		
		LoginPage loginobj = new LoginPage(driver);
		
		loginobj.Login(uname, pass);
		
		
		
					
	}		
		@AfterMethod
		public void teardown() {
								
			report.endTest(test);
			report.flush();
			
			driver.quit();
			
			soft.assertAll();
		}
		
	

}
