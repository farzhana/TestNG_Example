package test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class TestCase1 {
	
	@BeforeTest
	public void BeforeTest () {
		
		System.out.println("Inside Before Test Method");
	}
	
	
	@BeforeMethod
	public void Setup () {
		
		System.out.println("Inside Before Method");
	}
	
	
	@Test(groups= {"Sanity"})
	public void LoginTest() {
		
		System.out.println("Inside Login Test");
		
	}
	
	
	@Test(groups= {"Regression"})
	public void SignUpTest() {
		
		System.out.println("Inside SignUp Test");
		
	}
	
	
	@Test(groups= {"Regression"})
	public void RandomName() {
		
		System.out.println("Inside Random name");
		
	}
	
	@AfterMethod
	public void AfterMethod () {
		
		System.out.println("Inside After Method");
	}
	
	@AfterTest
	public void AfterTest () {
		
		System.out.println("Inside after Test Method");
	}
	
	
	
}
