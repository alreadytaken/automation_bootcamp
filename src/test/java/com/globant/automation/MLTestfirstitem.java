package com.globant.automation;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MLTestfirstitem {
	
    private static final Logger LOG;
    private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }
    
    
    @Test
    public void testML() {
    	driver.get("http://www.mercadolibre.com.uy");
    	MercadoLibreMain Homepage=new MercadoLibreMain(driver);
    	String precioPrimerItem= Homepage.getPriceInfo();
    	String dtoPrimerItem=Homepage.getDtoInfo();
    	String textoPrimerItem=Homepage.getTxtInfo();
    	ItemPage InItemPage= Homepage.goToItem();
    	String precioInItem = InItemPage.getInItemPriceInfo();
    	String dtoInItem = InItemPage.getInItemDtoInfo();
    	String textoInItem = InItemPage.getInItemTxtInfo();
    	assertEquals(precioPrimerItem,precioInItem,"Verifico que el precio dentro y fuera sea el mismo");
    	assertEquals(dtoPrimerItem,dtoInItem,"Verifico que el descuento dentro y fuera sea el mismo");
    	assertEquals(textoPrimerItem,textoInItem,"Verifico que el título dentro y fuera sea el mismo");
    }
    
   	@BeforeMethod
   	public void prepareTest() {
   	    LOG.info("Prepare test");
   	    driver = new ChromeDriver();
   	}
   	@BeforeClass
   	private void prepareClass() {
   	    LOG.info("Prepare class");
   	    WebDriverManager.chromedriver().setup();
   	}
}
