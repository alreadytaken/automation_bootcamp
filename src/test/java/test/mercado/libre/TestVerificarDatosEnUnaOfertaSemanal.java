package test.mercado.libre;

import java.net.MalformedURLException;
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
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestVerificarDatosEnUnaOfertaSemanal {
	
	private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(TestVerificarDatosEnUnaOfertaSemanal.class);
    }
    
    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
        driver = new ChromeDriver();
        
    }
    
    @Test
    public void verificarDatosEnOferta() {
    	
    	driver.get("http://mercadolibre.com.uy");
    	MercadoLibreHomePage mercadoLibreHome = new MercadoLibreHomePage(driver);
    
    	String priceBeforeClicking = mercadoLibreHome.getPreciosSemanales(0);       	
    	String discountBeforeClicking = mercadoLibreHome.getDescuentosSemanales(0); 	
    	String nameBeforeClicking = mercadoLibreHome.getNombreProducto(0);
    	   	
    	MercadoLibreProductoEnOfertaSemanal productPage = mercadoLibreHome.seleccionarProducto(0);
    
    	String nameAfterClicking = productPage.getNombreProducto();
    	String priceAfterClicking = productPage.getPrecioProducto();
    	String discountAfterClicking = productPage.getDescuentoProducto();
  
    	Assert.assertEquals(nameBeforeClicking, nameAfterClicking);
    	Assert.assertEquals(priceBeforeClicking, priceAfterClicking);
    	Assert.assertEquals(discountBeforeClicking, discountAfterClicking);
   
    	
   }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}

  