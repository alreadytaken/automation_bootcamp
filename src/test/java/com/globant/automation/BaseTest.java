package com.globant.automation;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	  WebDriver driver;
	    
	    @BeforeClass
	    public void Chrome() {
	    	WebDriverManager.chromedriver().setup();
	    }
	
	    @BeforeMethod
	    public void setUp() {
	        ChromeOptions opts = new ChromeOptions();
	        opts.addArguments("--incognito");
	        opts.addArguments("--test-type");
	        opts.addArguments("--no-sandbox");
	        driver = new ChromeDriver(opts);
	    }
	       
		@AfterMethod
		public void quitarPrueba() {
	    driver.quit();
		  }
		
}