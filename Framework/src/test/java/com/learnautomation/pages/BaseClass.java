package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up Suite",true);
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./Reports/LoginToCRM"+Helper.getCurrentDateTime()+".html"));
		    extent = new ExtentReports();
			extent.attachReporter(reporter);
	}
	
	@Parameters({"Browser","appUrl"})
	@BeforeClass
	 public void setUp(String Browser, String appUrl) {
		
		//1.To start app by fetching env variables from config file
		// driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		
		
		//2.To pass parameters from maven
		driver = BrowserFactory.startApplication(driver, Browser, appUrl);
	 }
	
	@AfterClass
	 public void tearDown() {
		 BrowserFactory.quitBrowser(driver);
	 }
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()== ITestResult.FAILURE) {
			
			//To capture screenshot if test fails
			//Helper.captureScreenshot(driver, result.getName());
			
			//To capture screenshot if test fails and to attach it to report(Single step)
			test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
			}else if(result.getStatus()==ITestResult.SUCCESS) {
				test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
				
			}
		extent.flush();
		    
	}
	
}
