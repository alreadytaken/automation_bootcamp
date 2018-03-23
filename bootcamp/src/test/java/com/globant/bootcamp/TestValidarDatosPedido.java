package com.globant.bootcamp;

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

public class TestValidarDatosPedido {
	WebDriver driver;

	public TestValidarDatosPedido() {

	}

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(TestValidarDatosPedido.class);
	}

	@Test
	public void ValidarDatos() {

		driver.get("http://www.pedidosya.com");
		HomePagePedidosYa PYhome = new HomePagePedidosYa(driver);
		PYhome.ClickearUruguay();

		LOG.info("ENTRA a PO PY Uy");

		PYHomePageUy pyUy = new PYHomePageUy(driver);
		LOG.info("ENTRA a ingresar datos");
		PopUpConfirmarUbicacion PopUpUbicacion = pyUy.IngresarDatos();

		LOG.info("ENTRA a confirmar");
		PYSugerenciasPage sugerencias_page = PopUpUbicacion.ConfirmarUbicacionPopUp();
		LOG.info("ENTRA A TOMAR PRECIO");
		String precioEnSugerencias = sugerencias_page.tomarPrecio();

		LOG.info("ENTRA A CLICKEAR PEDIDO Y CREAE PO");
		PopUpAgregarPedido addPedido_page = sugerencias_page.ClickearPedido(); // Clickeo el pedido en las sugerencias
		LOG.info("SALE de clickear pedido"); // y creo el PO del PopUp de agregar el pedido

		RestaurantPage restaurant_page = addPedido_page.ConfirmarPedido(); //
		LOG.info("CONFIRMÓ PEDIDO");

		/** VALIDO LA DIRECCION Y EL PRECIO **/

		Assert.assertEquals(restaurant_page.tomarPrecio(), precioEnSugerencias);
		Assert.assertEquals(restaurant_page.tomarDireccion(), "Nicaragua 1600");

		PopUpModalLogin popup_login = restaurant_page.confirmarPedido();

		PopUpRegistro popup_registro = popup_login.clickRegistrar();

	}

	@BeforeMethod
	public void prepareTest() {

		LOG.info("Preparing");
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("-----Prepare class-----");

		WebDriverManager.chromedriver().setup();

	}

}// class
