package com.globant.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestValidarDatosPedido {
	WebDriver driver;
	
	
	
	public TestValidarDatosPedido(){
		
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
		pyUy.IngresarDatos();
		
		LOG.info("ENTRA a confirmar");
		
		PopUpConfirmarUbicacion PopUpUbicacion = new PopUpConfirmarUbicacion(driver);
		PopUpUbicacion.ConfirmarUbicacionPopUp();
		
		LOG.info("salio de confirmar");
		
		PYSugerenciasPage sugerencias_page = new PYSugerenciasPage(driver);
		sugerencias_page.tomarPrecio();
		
		
		
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
			
	
	
	
	
	
	
	
}//class
