package com.swaglabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.qa.base.TestBase;

public class LoginPage extends TestBase{
	

	
	@FindBy(xpath="//input[@name='user-name']")
	WebElement userName;
	
	@FindBy(xpath=" //input[@id='password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@name='login-button']")
	WebElement loginButton;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateTitle() {
		return driver.getTitle();
		
	}

	
	public HomePage Login(String un ,String pas)
	{
		userName.sendKeys(un);
		password.sendKeys(pas);
		loginButton.click();
		
		return new HomePage();
	}
	

}
