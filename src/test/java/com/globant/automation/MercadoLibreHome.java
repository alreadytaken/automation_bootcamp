package com.globant.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.MethodCall.ArgumentLoader.ForMethodParameterArray.ForInstrumentedMethod;

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


public class MercadoLibreHome {
	
    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(MercadoLibreHome.class);
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

       
    @Test
    public void compareData() {
    	    	
    	//Listas con los links
    	List<WebElement> priceHome = null;
    	List<WebElement> priceProduct = null;
    	
    	//listas con los textos de los links
    	List<String> pHome = new ArrayList<>();
    	List<String> pProduct = new ArrayList<>();
    	
    	//voy a google
    	driver.get("http://www.mercadolibre.com.uy");
    	
    	//inicializo e instancio la PO
    	MercadoLibrePO test1 = new MercadoLibrePO(driver);
    
    	//uso la PO para ingrear datos y dar en submit
    	pHome = test1.getHomePrice();
    	LOG.info(pHome.get(1), pHome.get(2), pHome.get(3));
    	
    	
    	//pProduct = test1.getProductPrice();
    	/*
    	//uso la PO para guardar los links en la lista
    	resultGoogle = test1.resultGoogleSearch(resultGoogle);
    	
    	for (int i = 0; i < 5; i++) {
    		sGoogle.add(resultGoogle.get(i).getText());
		}
    	
    	//idem para bing
    	driver.get("http://www.bing.com");
    	
    	test1.typeBingSearch(data);
    	test1.submitBingSearch();
    	
    	resultBing = test1.resultBingSearch(resultBing);
    	
    	for (int i = 0; i < 5; i++) {
    		sBing.add(resultBing.get(i).getText());			
		}
    	
    	for (int i = 0; i<5;i++) {
    		LOG.info("Google");
        	LOG.info(sGoogle.get(i));
        	LOG.info("Bing");
        	LOG.info(sBing.get(i));
    	}
    	
    	*/
    	
    }
}