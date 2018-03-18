package com.globant.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectsGoogleBing.BingHome;
import pageObjectsGoogleBing.BingResults;
import pageObjectsGoogleBing.GoogleHome;
import pageObjectsGoogleBing.GoogleResults;

public class PomGoogleBingCompare {
	public PomGoogleBingCompare(){
		
	}
    private static final Logger LOG;
    
    static {
        LOG = LogManager.getLogger(PomGoogleBingCompare.class);
    }
    
    protected static WebDriver driver;
    
    @DataProvider(name = "Search")
	public Object[][] provider() {
		return new Object[][] { { "Pink Floyd" },{ "Led Zeppelin" },{ "The Beatles" },{ "Tame Impala"},{"Pond"}};
	}
    
    @Test(dataProvider = "Search")
    public void searchTest(String search) throws InterruptedException {
    		//Google Search
    		driver.get("https://www.google.com");
    		GoogleHome homePageG = new GoogleHome(driver);
    		GoogleResults resultsPageG = homePageG.searchQuery(search);
    		List <String> googleResults = resultsPageG.getResults(5);
     	LOG.info("GOOGLE" + resultsPageG.getResults(5));
    		
    		//Bing Search
    		driver.get("https://www.bing.com");
    		BingHome homePageB = new BingHome(driver);
    		BingResults resultsPageB = homePageB.searchQuery(search);
    		List <String> bingResults = resultsPageB.getResults(5);
    		LOG.info("BING" + resultsPageB.getResults(5));
    	
    		
    		Assert.assertEquals(googleResults, bingResults);


  
    }
    
    @BeforeClass
    private void prepareClass() {
    		WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    private void prepareTest() {
    		driver = new ChromeDriver();
    }
    
    @AfterMethod
    private void cleanup() {
    		driver.close();
    }
    
    
}
