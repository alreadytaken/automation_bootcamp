package com.globant.automation;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleVsBingTest {
	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleVsBingTest.class);
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


	@DataProvider(name = "Busqueda")
	public Object[][] provider() {
		return new Object[][] { { "Casas" }, { "Autos" }, { "Pepe" }, { "Barcos" }, { "Celulares" } };
	}

	@Test(dataProvider = "Busqueda")
	public void testGoogleVsBing(String busqueda) {
		int cantidadResultados = 5;
		LOG.info("Se van a comparar los primeros " + cantidadResultados + " resultados");
		LOG.info("Entrando a Google");
		driver.get("https://www.google.com/");
		GoogleMainPage mainPageGoogle = new GoogleMainPage(driver);
		GoogleSearchPage searchPageGoogle = mainPageGoogle.buscar(busqueda);
		List<String> resultadosGoogle = searchPageGoogle.obtenerResultados(cantidadResultados);

		LOG.info("Entrando a Bing");
		driver.get("https://www.bing.com/");
		BingMainPage mainPageBing = new BingMainPage(driver);
		BingSearchPage searchPageBing = mainPageBing.buscar(busqueda);
		List<String> resultadosBing = searchPageBing.obtenerResultados(cantidadResultados);

		// Muestro los resultados y comparo
		LOG.info("Resultado de la búsqueda \n");
		for (int i = 0; i < cantidadResultados; i++) {
			LOG.info("Resultado " + i + ": " + resultadosGoogle.get(i));
			LOG.info("Resultado " + i + ": " + resultadosBing.get(i));
			if (resultadosGoogle.get(i).equals(resultadosBing.get(i))) {
				LOG.info("Los resultados son iguales \n");
			} else {
				LOG.info("Los resultados son diferentes \n");
			}
		}

		Assert.assertArrayEquals(resultadosBing.toArray(), resultadosGoogle.toArray());

	}
}
