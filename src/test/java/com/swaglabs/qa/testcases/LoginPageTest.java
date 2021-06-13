package com.swaglabs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabs.qa.base.TestBase;
import com.swaglabs.qa.pages.HomePage;
import com.swaglabs.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
 LoginPage loginpage;
 HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		Intializatiion();
		
		 loginpage=new LoginPage();
	}
	
	@Test (priority=1)
	public void verifyTitle()
	{
		String title=loginpage.validateTitle();
		
	    System.out.println(title);
		Assert.assertEquals(title, "Swag Labs");
		
		
	}
	
	
	 @ Test (priority=2)
	 public void login () {
		homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
	 
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
}
