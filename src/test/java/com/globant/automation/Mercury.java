package com.globant.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mercury {

    public Mercury() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(Mercury.class);
    }
    
    @DataProvider(name="Search")
    public static Object[][] toSearch() {
        return new Object[][] { { "bicicletas" }};
  }
               
    @Test(dataProvider = "Search")
    public void searchTest4(String sSend)  {
        LOG.info("Test Mercury");
        driver.get("http://newtours.demoaut.com/.com");
        WebElement sBuscador = driver.findElement(By.name("q"));
        
        //Declaro mis listas
        List<WebElement> sResultg = null;
        List<WebElement> sResultb = null;
        List<String> sGoogle = new ArrayList<>();
        List<String> sBing = new ArrayList<>();
        
        sBuscadorg.sendKeys(sSend);
        sBuscadorg.sendKeys(Keys.ENTER);
              
        //Dejo en sResult todos los resultados de busqueda
        sResultg = driver.findElements(By.xpath("//h3[@class='r']/a"));
        
        //Recorro los resultados del 1 al 5 y ingreso los textos en la lista correspondiente
        for (int i=0; i<5; i++) {
        	sGoogle.add(sResultg.get(i).getText());
        }
        
        LOG.info("Test Bing");
        driver.get("https://bing.com");
        WebElement sBuscadorb = driver.findElement(By.name("q"));
        
        sBuscadorb.sendKeys(sSend);
        sBuscadorb.sendKeys(Keys.ENTER);
 
        //Dejo en sResult todos los resultados de busqueda
        sResultb = driver.findElements(By.xpath("//h2/a"));
        //Recorro los resultados del 1 al 5 y ingreso los textos en la lista correspondiente
        for (int i=0; i<5; i++) {
        	sBing.add(sResultb.get(i).getText());
        }
        
        for (int i=0; i<5; i++) {
        	//Assert.assertEquals(sGoogle.get(i), sBing.get(i));
        	LOG.info("Google");
        	LOG.info(sGoogle.get(i));
        	LOG.info("Bing");
        	LOG.info(sBing.get(i));
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
