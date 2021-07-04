package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void Login(String uname, String pass) {
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		
		
		WebElement Username = driver.findElement(By.name("user_login"));
		
		Username.sendKeys(uname);
		
		
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		
		password.sendKeys(pass);
		
		

		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		
		RememberMe.click();

		WebElement Login = driver.findElement(By.name("btn_login"));
		
		Login.click();
		
		
		
		//WebElement Error = driver.findElement(By.id("msg_box"));
		
		//String ActMsg = Error.getText();		
		//String ExpMsg = "The email or password you have entered is invalid.";
		
				
		//Assert.assertTrue(Error.isDisplayed());
		
		//soft.assertEquals(ActMsg,  ExpMsg);
		
		//System.out.println("After soft assertion");
		
	
	/*	try {
			Assert.assertEquals(ActMsg , ExpMsg);
			test.log(LogStatus.PASS,"Actual message And Expected Message matches");
		}
		catch(Throwable e) {
			test.log(LogStatus.FAIL,"Actual message And Expected Message does not matches");
		}
		*/
	}
		

	}

