package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest {

    public GoogleTest() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }
    
    @DataProvider(name = "q")
    public Object[][] provider()
    {
    	return new Object [][] {{"Smash"}, {"Link"},{"Samus"},{"Kirby"},{"Mario"}};
    }
    

    @Test (dataProvider = "q")
    public void searchTest(String q) throws InterruptedException {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement gelement = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
    	gelement.sendKeys(q);
    	gelement.sendKeys(Keys.ENTER);
        List<WebElement> GoogleElements = driver.findElements(By.xpath("//*[@class='rc']/h3/a"));
    	List<String> google = new ArrayList<>();
        for (int i=0; i<5;i++)
    	{
        	google.add(GoogleElements.get(i).getText());
    	}
        
     
        
        driver.get("https://bing.com");
        WebElement belement = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
    	belement.sendKeys(q);
    	belement.sendKeys(Keys.ENTER);
        List<WebElement> BingElements = driver.findElements(By.xpath("//*[@class='b_algo']/h2/a"));
        List<String> bing = new ArrayList<>();
        for (int i=0; i<5;i++)
    	{
        	bing.add(BingElements.get(i).getText());
    	}
        
        for (int i=0; i<5;i++)
        {
        	Assert.assertTrue(google.get(i) != bing.get(i), "estoy comparando1");
        }
        
        
        
        
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
