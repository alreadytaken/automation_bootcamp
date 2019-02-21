package com.globant.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	       
//
//	    @AfterMethod
//	    public void tearDown() {
//	        driver.quit();
	    }


	



