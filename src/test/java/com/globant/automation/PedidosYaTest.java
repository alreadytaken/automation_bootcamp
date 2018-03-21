package com.globant.automation;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PedidosYaTest {
    
	private static final Logger LOG;
    private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }
    
    @Test
    public void testPedidosYa() {
    	driver.get("http://www.pedidosya.com");
    	PedidosYaCountrySel CountrySel=new PedidosYaCountrySel(driver);
    	PedidosYaUruguayMain UruguayMain = CountrySel.clickOnUruguay();
    	UruguayMain.ingresarDireccion("Nicaragua 1666");
    	UruguayMain.ingresarComidaRestaurante("Milanesa");
    	ConfirmPopUp ConfirmPage=UruguayMain.clickEnBuscar();
    	ConfirmPage.confirmarUbicacion();
    }
	
   	@BeforeMethod
   	public void prepareTest() {
   	    LOG.info("Prepare test");
   	    driver = new FirefoxDriver();
   	}
   	@BeforeClass
   	private void prepareClass() {
   	    LOG.info("Prepare class");
   	    WebDriverManager.firefoxdriver().setup();
   	}
}
