package com.globant.automation;



import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public GoogleTest() {

	}

	private static final Logger LOG;
	private WebDriver driver;
	//@FindBy(name="q")
	//private WebElement txtsearch;
	
	//@FindBy(name="userName")
	//private WebElement userMT;
	
	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}
	
	@DataProvider(name="searchdp")
	public Object[][] searchData() {
		
		return new Object[][] {
			{"celulares"}, {"computadores"}
		};
	}
	

	@Test(dataProvider="searchdp")
	public void searchTest(String search) throws InterruptedException {
		LOG.info("Search test");
		
		driver.get("http://newtours.demoaut.com");
		
		WebElement txtsearch = driver.findElement(By.name("q"));
		
		
		WebElement gmail = driver.findElement(By.className("gb_P"));
		
		/**Glorioso Mercury tours**/
		WebElement userMT = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name("userName")));
		userMT.sendKeys("Camila");
	
		
		
	//	driver.get("http://google.com");
	//	WebElement txtsearch = SeleniumUtils.waitUntilClickeable(By.name("q"), driver);
	//	txtsearch.sendKeys(search);
	//	txtsearch.submit();
		

		
	
				
	}//metodo

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		//DesiredCapabilities caps = DesiredCapabilities.firefox();
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("Prepare class");
		WebDriverManager.chromedriver().setup();
	}
	
	
	
	
}	
