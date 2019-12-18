package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseWithoutFramework {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mchahal\\Documents\\myData\\Sel\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://ui.cogmento.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("chahalmamta06@gmail.com");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Noida@06");
	    driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).submit();
	    
	    Thread.sleep(5000);
	    
	    driver.quit();
	}

}
