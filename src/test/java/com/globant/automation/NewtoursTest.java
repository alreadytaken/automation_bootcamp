package com.globant.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewtoursTest {
	
	public NewtoursTest() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(NewtoursTest.class);
    }

	@DataProvider(name = "NtRegister")
	public Object[][] provider() {
		return new Object[][] { { "Pink Floyd" } };
	}
	
    @Test(dataProvider = "NtRegister")
    public void searchTest(String search) throws InterruptedException {
    	//List <WebElement> navigation;
    	
    	
        LOG.info("Newtours Test Started");
        driver.get("http://newtours.demoaut.com/");
       // navigation =driver.findElements(By.cssSelector("td[class='mouseOut'] a"));
        //SeleniumUtils.waitUntilClickable(By.id("gsri_ok0"), driver);
        
    }

    @BeforeMethod
    public void prepareTest() {
        LOG.info("Prepare test");
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



