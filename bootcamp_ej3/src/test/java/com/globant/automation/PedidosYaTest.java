package com.globant.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PedidosYaCountrySelectionPage;
import pages.PedidosYaFoodPopUp;
import pages.PedidosYaFoodSelectionPage;
import pages.PedidosYaMainPage;
import pages.PedidosYaPopUpLogIn;
import pages.PedidosYaPopUpMapa;
import pages.PedidosYaPostLogInPage;
import pages.PedidosYaRestaurantSelectionPage;

public class PedidosYaTest {
	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(PedidosYaTest.class);
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Iniciando test");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}

	// Direccion : Nicaragua 1666
	// Opcional: Milanesa
	// Codigo temporal
	@DataProvider(name = "Busqueda")
	public Object[][] provider() {
		return new Object[][] { { "1" }, { "2" }, { "3" }, { "4" }, { "5" } };
	}

	// Hasta ac�
	@Test(dataProvider = "Busqueda") // DataProvider no necesario
	public void testPedidosYa(String temporal) {
		LOG.info("Test No: " + temporal);
		driver.get("https://www.pedidosya.com/");
		PedidosYaCountrySelectionPage pedidosYaCSP = new PedidosYaCountrySelectionPage(driver);
		PedidosYaMainPage pedidosYaMP = pedidosYaCSP.seleccionarUruguay();
		PedidosYaPopUpMapa pedidosYaPUM = pedidosYaMP.buscarDireccion("Nicaragua 1666", "Milanesa");
		PedidosYaRestaurantSelectionPage pedidosYaRSP = pedidosYaPUM.confirmarUbicacion();
		PedidosYaFoodPopUp pedidosYaFPU = pedidosYaRSP.clickPromo();
		String precioPre = pedidosYaFPU.obtenerPrecio();
		LOG.info(precioPre);
		PedidosYaFoodSelectionPage pedidosYaFSP = pedidosYaFPU.agregarPedido();
		String[] datos = pedidosYaFSP.obtenerDatos();
		String[] temp = datos[0].split(" ");
		datos[0] = temp[2] + " " + temp[3];
		LOG.info("Direccion: " + datos[0] + "\n" + "Precio: " + datos[1]);
		assertEquals(precioPre, datos[1]);
		LOG.info("Los precios coinciden");
		assertEquals(datos[0], "Nicaragua 1666");
		LOG.info("La direcci�n coincide");
		PedidosYaPopUpLogIn pedidosYaPULI = pedidosYaFSP.clickLogIn();
		PedidosYaPostLogInPage pedidosYaPLIP = pedidosYaPULI.ingresarDatos("gonzalolombardi@hotmail.com", "g4914861");
		assertTrue(pedidosYaPLIP.isLogged("Gonzalo"));
		LOG.info("El usuario es correcto");
	}

}
