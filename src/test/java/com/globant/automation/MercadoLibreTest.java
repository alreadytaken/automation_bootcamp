package com.globant.automation;

import java.net.MalformedURLException;

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

public class MercadoLibreTest {
	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(MercadoLibreTest.class);
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Iniciando test");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void test() {
		driver.get("https://www.mercadolibre.com.uy/");
		MercadoLibreMainPage m = new MercadoLibreMainPage(driver);
		String [] datos = m.obtenerDatosOferta();
		LOG.info(datos[0]);
		LOG.info(datos[1]);
		LOG.info(datos[2]);
		MercadoLibreItemPage pag = m.clickOferta();
		String [] datos2 = pag.obtenerDatos();
		LOG.info(datos2[0]);
		LOG.info(datos2[1]);
		LOG.info(datos2[2]);
		Assert.assertEquals(datos, datos2);
	}
}
