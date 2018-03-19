package com.globant.automation.MercadoLibre;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globant.automation.GoogleTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ValidarDatosTestCase {

	WebDriver driver;
	private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}
	
	//@FindBy(how = How.XPATH, using = "WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(localizador));")
	//WebElement name;
	
	@Test
	public void ValidarInfo() throws MalformedURLException{
		LOG.info("--test--");
		
		
		
		driver.get("https://www.mercadolibre.com.uy/");
				
		//MercadoLibreHomePage MLPage = PageFactory.initElements(driver, MercadoLibreHomePage.class);
		LOG.info("INICIALIZANDO LOS STRING CON LOS XPATHS");
		
		/**WebElement ofertasSemana = driver.findElement(By.xpath("//h1[text()='Ofertas de la semana']/preceding::div[@class='carousel-container']//div[@class='slick-list']//div[contains(@class, 'slick-slide')]"));
		WebElement ofertaSemanaPrimero = ofertasSemana.findElement(By.xpath(""));*/
		
			WebElement oferta1 = driver.findElement(By.xpath("//h1[text()=\"Ofertas de la semana\"]//parent::div/../div[@class=\"carousel-container\"]/div/div/div/div[1]"));
	     //tomo el primero de los productos
			String link = oferta1.findElement(By.xpath("./div/a")).getAttribute("href"); 
			//guardo el link del producto
		  String nombre = oferta1.findElement(By.xpath("./div//p[@class='ui-item__title']")).getAttribute("innerHTML");
		  //guardo el nombre
		  String precio = oferta1.findElement(By.xpath(".//div//span[@class='price-tag-fraction']")).getAttribute("innerHTML");
		  //guardo el precio
		  String descuento = oferta1.findElement(By.xpath(".//div//span[@class =\"ui-item__discount-text\"]")).getAttribute("innerHTML");
		  
		  LOG.info("link: " +link);
		  LOG.info("nombre: "+nombre);
		  LOG.info("precio:" +precio);
		
		 driver.get(link);
		 
		 String nombreP = driver.findElement(By.xpath("//*[@id=\"short-desc\"]/div/header/h1")).getAttribute("innerHTML");
		 String precioP = driver.findElement(By.xpath("//*[@id=\"productInfo\"]/fieldset[1]/span[2]/span[2]")).getAttribute("innerHTML");
		 String descuentoP = driver.findElement(By.xpath("//*[@id=\"productInfo\"]/fieldset[1]/div/p")).getAttribute("innerHTML");
		 
		 Assert.assertEquals(nombre, nombreP);
		 Assert.assertEquals(precio, precioP);
		 Assert.assertEquals(descuento, descuentoP);
		
	}
		
	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("----Prepare test----");		
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
}//Class
