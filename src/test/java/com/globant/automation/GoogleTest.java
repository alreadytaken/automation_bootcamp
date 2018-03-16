package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
/*
    @Test
    public void searchTest() throws InterruptedException {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement sBuscador = driver.findElement(By.name("q"));
        WebElement sSearch = driver.findElement(By.name("btnK"));
        sBuscador.sendKeys("perritos imagenes");
        sSearch.submit();
    }

    @Test
    public void searchTest2() throws InterruptedException {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement sBuscador = driver.findElement(By.name("q"));
        WebElement sSearch = driver.findElement(By.name("btnK"));
        sBuscador.sendKeys("tchoukball imagenes");
        sSearch.submit();
    }
    
    @Test
    public void searchTest3() throws InterruptedException {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement sBuscador = driver.findElement(By.name("q"));
        WebElement sSearch = driver.findElement(By.name("btnK"));
        sBuscador.sendKeys("bicicletas imagenes");
        sSearch.submit();
    }*/
    
    @DataProvider(name="Search")
    public static Object[][] credentials() {
        return new Object[][] { { "perritos" }, { "tchoukball" }, {"bicicletas"}};
  }
       
        
    @Test(dataProvider = "Search")
    public void searchTest4(String sSend)  {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement sBuscador = driver.findElement(By.name("q"));
        //WebElement sSearch = driver.findElement(By.name("btnK"));
        
        sBuscador.sendKeys(sSend);
        sBuscador.sendKeys(Keys.ENTER);
        WebElement sWait = SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='rc'/h3[@class='r']/a")), driver);
        //WebElement sWait2 = 
        sWait.click();
        
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
