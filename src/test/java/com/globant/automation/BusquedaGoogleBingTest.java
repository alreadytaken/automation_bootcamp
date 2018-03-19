package com.globant.automation;

import java.util.ArrayList;
import java.util.List;
import com.globant.automation.BusquedaGoogleBingPO;
import org.apache.commons.codec.language.bm.Lang;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BusquedaGoogleBingTest {
	
		
	    private static final Logger LOG;
	    private WebDriver driver;

	    static {
	        LOG = LogManager.getLogger(BusquedaGoogleBingTest.class);
	    }
	    
	    @BeforeMethod
	    public void prepareTest() {
	        LOG.info("Preparo test");
	        driver = new ChromeDriver();
	    }
	   
	    @AfterMethod
	    public void close() {
	        driver.quit();
	    }

	    @BeforeClass
	    private void prepareClass() {
	        LOG.info("Preparo clase");
	        WebDriverManager.chromedriver().setup();
	    }

	    
	    @DataProvider(name="Search")
	    public Object[][] provider() {
	        return new Object[][] { { "felipe" },{ "pepe" },{ "manolo" },{ "jose" }};
	    }
	    
	    @Test(dataProvider = "Search")
	    public void searchGoogleBing(String Search) {
	    	    	
	    	List<WebElement> resultGoogle = null;
	    	List<WebElement> resultBing = null;
	    	List<String> sGoogle = new ArrayList<>();
	    	List<String> sBing = new ArrayList<>();
	    	driver.get("http://www.google.com");
	    	BusquedaGoogleBingTest test1 = new BusquedaGoogleBingTest();
	    	test1.GoogleSearch(Search);
	    	resultGoogle = test1.resultGoogle(resultGoogle);
	    	for (int i = 0; i < 5; i++) {
	    		sGoogle.add(resultGoogle.get(i).getText());
			}
	    	driver.get("http://www.bing.com");
	    	test1.BingSearch(Search);
	    	resultBing = test1.resultBing(resultBing);
	    	for (int i = 0; i < 5; i++) {
	    		sBing.add(resultBing.get(i).getText());			
			}
	    	
	    	
	    	//MUESTRO RESULTADOS
	    	for (int i = 0; i<5;i++) {
	    		LOG.info("Google results");
	        	LOG.info(sGoogle.get(i));
	        	LOG.info("Bing results");
	        	LOG.info(sBing.get(i));
	    	}
	    	
	    	
	    	
	    }

	}
}
