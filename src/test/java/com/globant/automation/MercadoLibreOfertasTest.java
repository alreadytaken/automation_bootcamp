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
import pageObjects.MercadoLibreHomeSlideOne;
import pageObjects.MercadoLibreHomeSlideThree;
import pageObjects.MercadoLibreHomeSlideTwo;
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
		driver.manage().window().maximize();
		MercadoLibreHome homePage = new MercadoLibreHome(driver);
		homePage.saveDeals();
		MercadoLibreHome homePageSlideOne = new MercadoLibreHomeSlideOne(driver,1); //PRIMER SLIDE
		homePageSlideOne.saveDeals();
		MercadoLibreHome homePageSlideTwo = new MercadoLibreHomeSlideTwo(driver,1,1); //SEGUNDO SLIDE
		homePageSlideTwo.saveDeals();
		MercadoLibreHome homePageSlideThree = new MercadoLibreHomeSlideThree(driver,1,1,1); //SEGUNDO SLIDE
		homePageSlideThree.saveDeals();

		for(int i = 0;i<5;i++) {
			LOG.info(homePage.getDeal(i));	
			driver.get(homePage.linkText.get(i));
			MercadoLibreOferta dealPage = new MercadoLibreOferta(driver);
			LOG.info(dealPage.getDeal());
		
			Assert.assertEquals(dealPage.getDeal(),homePage.getDeal(i));
		}
				
		for(int i = 5;i<10;i++) {
			LOG.info(homePageSlideOne.getDeal(i));	
			driver.get(homePageSlideOne.linkText.get(i));
			MercadoLibreOferta dealPage = new MercadoLibreOferta(driver);
			LOG.info(dealPage.getDeal());
		
			Assert.assertEquals(dealPage.getDeal(),homePageSlideOne.getDeal(i));
		}
		


		for(int i = 10;i<15;i++) {
			LOG.info(homePageSlideTwo.getDeal(i));	
			driver.get(homePageSlideTwo.linkText.get(i));
			MercadoLibreOferta dealPage = new MercadoLibreOferta(driver);
			LOG.info(dealPage.getDeal());
		
			Assert.assertEquals(dealPage.getDeal(),homePageSlideTwo.getDeal(i));
		}
		
		for(int i = 15;i<19;i++) {
			LOG.info(homePageSlideThree.getDeal(i));	
			driver.get(homePageSlideThree.linkText.get(i));
			MercadoLibreOferta dealPage = new MercadoLibreOferta(driver);
			LOG.info(dealPage.getDeal());
		
			Assert.assertEquals(dealPage.getDeal(),homePageSlideThree.getDeal(i));
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
