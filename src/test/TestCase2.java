package test;

import org.testng.annotations.Test;

public class TestCase2 {

	@Test(priority = 0 , description ="Verify that Homepage functionality is working fine" , groups = "Regression")
	public void Homepage() {
		
		System.out.println("Inside Homepage");
		
	}
	
	@Test(priority = 2 )
	public void Homepage1() {
		
		System.out.println("Inside Homepage");
		
	}
	
	@Test(priority = 1)
	public void Homepage2() {
		
		System.out.println("Inside Homepage");
		
	}
}
