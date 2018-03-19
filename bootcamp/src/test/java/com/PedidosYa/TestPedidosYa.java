package com.PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPedidosYa {

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
	    @DataProvider(name="direccion")
		public Object [][] provider() {
		 return new Object [][] {{"Nicaragua 1666"}};
	}
	
	    
	    @Test(dataProvider="direccion")
	    public void makeOrder(String text) {
	    	driver.get("http://www.pedidosya.com");
	    	driver.manage().window().maximize();
	    	PedidosInitPage pedidosInitPage = new PedidosInitPage(driver);
	    	PedidosHomePage pedidosHomePage =new PedidosHomePage(driver);
	    	//PedidosSuggestionPage pedidosSuggestionPage = new PedidosSuggestionPage(driver);
	    	
	    	pedidosInitPage.clickBanderaUruguay();
	    	pedidosHomePage.submitDireccion(text);
	    	
	    	pedidosHomePage.clickConf();
	    	//pedidosSuggestionPage.clickSuggestion();
	    	
	    	//Comida: Milanesa
	    	//Producto:Milanesa Completa con papas
	    	
	    	
	    	
	    	
	    }
	
	
	
	
	
	
	
	
}
