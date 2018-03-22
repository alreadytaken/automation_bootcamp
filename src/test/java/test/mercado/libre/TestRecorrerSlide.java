package test.mercado.libre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.List;

public class TestRecorrerSlide {
	
	private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(TestRecorrerSlide.class);
    }
    
    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
   }
    
    @Test
    public void recorrerSlide() throws InterruptedException, AWTException {
    	
    	driver.get("http://mercadolibre.com.uy");
    	MercadoLibreHomePage mercadoLibreHome = new MercadoLibreHomePage(driver);
    	mercadoLibreHome.irAlSiguiente();
    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
