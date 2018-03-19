package com.MercadoMl;

import java.util.List;

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


public class MercadoCompareElements {
	public static WebDriver driver;
	public static Logger LOG=LogManager.getLogger(MercadoCompareElements.class);
	
	
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
	    
	    @Test
	    public void mercado() throws InterruptedException  {
	    	
	    		
	    		  driver.get("http://www.mercadolibre.com.uy");
	    		driver.manage().window().maximize();	
	    	
MercadoProductPage mercadoProductPage= new MercadoProductPage(driver);
			
			
			mercadoProductPage.leerDatos();
			
			
			
	    }
	    	
}
