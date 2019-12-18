package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginCRM extends BaseClass {

 @Test
 public void loginApp() {
	 
	 test = extent.createTest("LoginCRM");
	 
	 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	 
	 test.info("Starting Application");
	 
	 loginPage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));	 
	 
	 test.pass("Login Success");

	 
 }
 
 
}
