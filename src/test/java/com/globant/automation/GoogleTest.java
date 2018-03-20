package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends FunctionalTest {


	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@DataProvider(name = "q")
	public Object[][] provider() {
		return new Object[][] { { "Smash" }, { "Link" }, { "Samus" }, { "Kirby" }, { "Mario" } };
	}

	@Test(dataProvider = "q")
	public void searchTest(String q) throws InterruptedException {
		LOG.info("Search test");
		driver.get("https://google.com");
		GoogleHomePage a = new GoogleHomePage(driver);
		a.inputsearchbar(q);
		GoogleSearchResultPage c = new GoogleSearchResultPage(driver);
		List<String> google = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			google.add(c.GoogleElements().get(i).getText());
		}

		driver.get("https://bing.com");
		BingHomePage b = new BingHomePage(driver);
		BingSearchResultsPage d = new BingSearchResultsPage(driver);
		b.inputsearchbar(q);
		List<String> bing = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			bing.add(d.BingElements().get(i).getText());
		}

		for (int i = 0; i < 5; i++) {
			Assert.assertTrue(google.get(i) != bing.get(i), "estoy comparando1");
		}

	}

	
	  @BeforeMethod public void prepareTest() { LOG.info("Prepare test");
	  driver = new ChromeDriver(); }
	 
	 @AfterMethod public void cleanup() { driver.quit(); }
	 

}
