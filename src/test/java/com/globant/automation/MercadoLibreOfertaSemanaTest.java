package com.globant.automation;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.MercadoLibreHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercadoLibreOfertaSemanaTest {

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		driver = new EdgeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("Prepare class");
		WebDriverManager.edgedriver().setup();
	}

	@Test 
	public void testOfertaSemana(){
		driver.get("https://www.mercadolibre.com");
	MercadoLibreHomePage firstPrice = new MercadoLibreHomePage(driver);
	LOG.info(firstPrice);
	}
}
