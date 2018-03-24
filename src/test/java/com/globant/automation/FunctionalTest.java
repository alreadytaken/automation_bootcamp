package com.globant.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTest {
	protected static WebDriver driver;

	@BeforeClass
	public static void setUp(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--incognito");
        opts.addArguments("--test-type");
        opts.addArguments("--no-sandbox");
		driver = new ChromeDriver(opts);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }
	
	@AfterClass
    public static void tearDown(){
		 driver.close();
    }   
}