package com.globant.automation;

import java.net.MalformedURLException;
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

public class GoogleVBing {

	

	public GoogleVBing() {

	}

	private static final Logger LOG;
	private WebDriver driver;
		
	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}
	
	@DataProvider(name="searchdp")
	public Object[][] searchData() {
		
		return new Object[][] {
			{"celulares"}, {"computadoras"}
		};
	}
	

	@Test(dataProvider="searchdp")
	public void searchTest(String search) throws InterruptedException {
		LOG.info("Search test");
		
				
		driver.get("http://google.com");
		WebElement txtsearch = SeleniumUtils.waitUntilClickeable(By.name("q"), driver);
		txtsearch.sendKeys(search);
		txtsearch.submit();
		
		List <WebElement> res = driver.findElements(By.xpath("//div[@class='rc']/h3/a"));
		List <String> resultadosGoogle = new ArrayList<>();
		List <String> resultadosBing = new ArrayList<>();
		
		for (int i=0; i<5; i++){
			resultadosGoogle.add(res.get(i).getText());
					
			//LOG.info(res.toString());
		}
		
		driver.get("https://www.bing.com/?setlang=es");
		WebElement txtsearchB = SeleniumUtils.waitUntilClickeable(By.name("q"), driver);
		txtsearchB.sendKeys(search);
		
		txtsearchB.submit();
		
		res = driver.findElements(By.xpath("//li[@class='b_algo']/h2/a"));
		
		for(int i= 0; i<5; i++ ) {
			
			resultadosBing.add(res.get(i).getText());
		}
				
		for (int i=0; i < 5; i++) {
			
			Assert.assertEquals(resultadosGoogle.get(i), resultadosBing.get(i));
		}
				
	}//metodo

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
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
	
	
	
	
	
	
	
	
	
	
	
	
}//class
