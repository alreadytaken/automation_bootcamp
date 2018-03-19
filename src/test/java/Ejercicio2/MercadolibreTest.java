package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.automation.BingHomePage;
import com.globant.automation.BingSearchResultsPage;
import com.globant.automation.FunctionalTest;
import com.globant.automation.GoogleHomePage;
import com.globant.automation.GoogleSearchResultPage;
import com.globant.automation.GoogleTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercadolibreTest extends FunctionalTest{

	
    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(MercadolibreTest.class);
    }
      
    @Test
    public void PublicacionTest() throws  ElementNotVisibleException{
        LOG.info("Search test");
        driver.get("https://Mercadolibre.com.uy");
        MercadolibreHomePage a = new MercadolibreHomePage(driver);
        String nombrep1 = a.getnombreproducto().getText();
        String preciop1 = a.getprecioproducto().getText();
        String descp1 = a.getdescuentoproducto().getText();
        a.click();
     
        
        PaginaProducto b = new PaginaProducto(driver);
        String nombrep2 = b.getnombreproducto().getText();
        String preciop2 = b.getprecioproducto().getText();
        String descp2 = b.getdescuentoproducto().getText();
        
        System.out.println(nombrep1);
        System.out.println(nombrep2);
        System.out.println(preciop1);
        System.out.println(preciop2);
        System.out.println(descp1);
        System.out.println(descp2);
        
        Assert.assertEquals(nombrep1, nombrep2, "estoy comparando 1");
        Assert.assertEquals(preciop1, preciop2, "estoy comparando 2");
        Assert.assertEquals(descp1, descp2, "estoy comparando 3");
        
        
        
        
        
    }

    @BeforeMethod
    public void prepareTest() {
        LOG.info("Prepare test");
        
        driver = new ChromeDriver(); 
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
}
