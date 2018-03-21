package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Items.Bandera;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.PedidosYaCountryPage;

public class PedidosYaBanderasTest {
	public PedidosYaBanderasTest() {
		
	}
	protected static WebDriver driver;
	
	private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(PedidosYaBanderasTest.class);
	}
	
	@Test
	private void banderasTest() {
		List<Bandera> banderasList = new ArrayList<>();
		
		driver.get("http://www.pedidosya.com/");
		driver.manage().window().maximize();
		PedidosYaCountryPage countryPage = new PedidosYaCountryPage(driver);
		for(int i = 0;i<7; i++) {
			banderasList.add(countryPage.getBandera(i));
			LOG.info(banderasList.get(i).nombre);
		}
		
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
	private void cleanUp() {
		driver.close();
	}
}
