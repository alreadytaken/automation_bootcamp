package com.globant.automation;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PedidosYaCountrySelectionPage;
import pages.PedidosYaFoodPopUp;
import pages.PedidosYaFoodSelectionPage;
import pages.PedidosYaMainPage;
import pages.PedidosYaPopUpMapa;
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
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	//Direccion : Nicaragua 1666
	//Opcional: Milanesa

	@Test
	public void testPedidosYa() {
		driver.get("https://staging.pedidosya.com/");
		PedidosYaCountrySelectionPage pedidosYaCSP = new PedidosYaCountrySelectionPage(driver);
		PedidosYaMainPage pedidosYaMP = pedidosYaCSP.seleccionarUruguay();
		PedidosYaPopUpMapa pedidosYaPUM = pedidosYaMP.buscarDireccion("Nicaragua 1666", "Milanesa");
		PedidosYaRestaurantSelectionPage pedidosYaRSP = pedidosYaPUM.confirmarUbicacion();
		PedidosYaFoodPopUp pedidosYaFPU = pedidosYaRSP.clickPromo();
		//PedidosYaFoodSelectionPage pedidosYaFSP = 
		LOG.info(pedidosYaFPU.obtenerPrecio());
	}

}
