package test.mercado.libre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;

public class TestVerificarProductosEnSlideActive {

	private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(TestVerificarProductosEnSlideActive.class);
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
    public void verifySlideActiveProducts() throws InterruptedException {
    	
    	driver.navigate().to("http://mercadolibre.com.uy");
    	//get("http://mercadolibre.com.uy");
    	MercadoLibreHomePage mercadoLibreHome = new MercadoLibreHomePage(driver);
    	String session = driver.getWindowHandle();
    	for(int i=0;i<5; i++) {
      	
    		String priceBeforeClicking = mercadoLibreHome.getPreciosSemanales(i);       	
        	String discountBeforeClicking = mercadoLibreHome.getDescuentosSemanales(i); 	
        	String nameBeforeClicking = mercadoLibreHome.getNombreProducto(i);
  	   		
        	MercadoLibreProductoEnOfertaSemanal productPage = mercadoLibreHome.seleccionarProducto(i);
        	
        	String nameAfterClicking = productPage.getNombreProducto();
        	String priceAfterClicking = productPage.getPrecioProducto();
        	String discountAfterClicking = productPage.getDescuentoProducto();
        	
        	Assert.assertEquals(nameBeforeClicking, nameAfterClicking);
        	Assert.assertEquals(priceBeforeClicking, priceAfterClicking);
        	Assert.assertEquals(discountBeforeClicking, discountAfterClicking);
          	mercadoLibreHome = productPage.goHome();
          	

    	}
    }
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
