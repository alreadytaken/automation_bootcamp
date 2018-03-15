package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    
    @DataProvider(name="Buscar")
    public Object[][] provider(){
    	return new Object [][] {{ "uno" },{"dos"},{"tres"}};
    }
    	
    
    
    @Test (dataProvider="Buscar")
    public void searchTest(String enviar)  {
        LOG.info("Search test");
        driver.get("https://google.com");
        WebElement buscador =driver.findElement(By.name("q"));
        buscador.click();
        buscador.sendKeys(enviar);
        buscador.sendKeys(Keys.ENTER);
        WebElement wait = SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='rc']/h3[@class='r']/a"), driver) ;
        wait.click();
        
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
