package com.globant.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.MercadoLibreHome;
import pageObjects.MercadoLibreOferta;

public class MercadoLibreOfertasTest {
	public MercadoLibreOfertasTest() {
	}

	private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(MercadoLibreOfertasTest.class);
	}
	
	protected static WebDriver driver;
	
    
	@Test
	public void ofertasTest(){
		driver.get("https://www.mercadolibre.com.uy");
		MercadoLibreHome homePage = new MercadoLibreHome(driver);
		homePage.saveDeals();
//		for(int i = 0;i<10;i++)
//			LOG.info(homePage.getDeal(i));

		for(int i = 0;i<5;i++) {
			LOG.info(homePage.getDeal(i));	
			driver.get(homePage.linkText.get(i));
			MercadoLibreOferta dealPage = new MercadoLibreOferta(driver);
			LOG.info(dealPage.getDeal());
		
			Assert.assertEquals(dealPage.getDeal(),homePage.getDeal(i));
		}

		
		
	}
	@BeforeClass
	public void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeMethod
	public void prepareTest() {
		driver = new ChromeDriver();
	}
	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
