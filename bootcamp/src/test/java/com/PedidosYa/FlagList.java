package com.PedidosYa;

import java.util.ArrayList;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlagList {
	
	public static WebDriver driver;
	public static Logger LOG=LogManager.getLogger(TestPedidosYa.class);
	
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
	    public void flagList() {
	    	
	    	driver.get("http://www.pedidosya.com");
	    	driver.manage().window().maximize();

	    	PedidosInitPage pedidosInitPage = new PedidosInitPage(driver);

			List <WebElement> resultados = pedidosInitPage.getFlags();
			
			List <Object> banderas=new ArrayList<>();
	        for(int i=0;i<resultados.size();i++) {
	        String flagName = resultados.get(i).getText();
	        banderas.add(flagName);
	        banderas.get(i);
	        
	        }
	        
	        
	        
	        
	       LOG.info(banderas);
			
	       
	      
	      
	    	
	    	
	    }

}
