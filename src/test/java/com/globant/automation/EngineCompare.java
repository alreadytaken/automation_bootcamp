package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EngineCompare {

    public EngineCompare() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(EngineCompare.class);
    }

	@DataProvider(name = "Search")
	public Object[][] provider() {
		return new Object[][] { { "Pink Floyd" },{ "Led Zeppelin" },{ "The Beatles" },{ "Tame Impala" },{ "Pond" }};
	}
	
    @Test(dataProvider = "Search")
    public void searchTest(String search) throws InterruptedException {
        LOG.info("Search test with Google");
        //Defino las listas para almacenar los resultados
        List<WebElement> tresultsG; //Lista temporal google
        List<WebElement> tresultsB; //Lista temporal bing
        List<String> googleResults = new ArrayList<>();
        List<String> bingResults = new ArrayList<>();
        
        //Busqueda en Google
        driver.get("https://google.com");
        WebElement gsearchBar = driver.findElement(By.name("q"));
        gsearchBar.sendKeys(search);
        gsearchBar.submit();
        SeleniumUtils.waitUntilClickable(By.id("gsri_ok0"), driver);
        tresultsG =driver.findElements(By.xpath("//h3[@class='r']/a"));
        

        for (int i=0;i<5;i++) {
        	
        	//Agrego uno a uno el componente de texto de cada WebElement de la lista results
        	googleResults.add(tresultsG.get(i).getText());
            LOG.info("Google Results - " + googleResults.get(i));
        }

        //Busqueda en Bing
        driver.get("https://www.bing.com");
        WebElement bsearchBar = driver.findElement(By.name("q"));
        bsearchBar.sendKeys(search);
        bsearchBar.submit();
        SeleniumUtils.waitUntilClickable(By.id("sb_form_go"), driver);  
        tresultsB = driver.findElements(By.xpath("//li[@class='b_algo']/h2/a"));
        
        for (int i=0;i<5;i++) {
        	
           	bingResults.add(tresultsB.get(i).getText());
            LOG.info("Bing Results - "+bingResults.get(i));
        }
        
        for (int i=0;i<5;i++) {
        	
        	Assert.assertEquals(googleResults.get(i), bingResults.get(i));
           	
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
