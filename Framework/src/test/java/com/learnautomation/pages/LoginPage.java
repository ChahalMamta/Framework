package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
      
	//Create public variable for driver
	WebDriver driver;
     
	
	//Constructor of class Loginpage to initialize driver instance passed by user
	public LoginPage(WebDriver ldriver) {
	    this.driver=ldriver;
	}
	
	
	//Locators of webelement present on page
	@FindBy(xpath = "//input[@name='email']") WebElement uname;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']") WebElement loginButton;

	
	//Method to login to application
	public void loginToCRM(String AppUsername, String AppPassword) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(AppUsername);
		password.sendKeys(AppUsername);
		loginButton.click();
	}
}
