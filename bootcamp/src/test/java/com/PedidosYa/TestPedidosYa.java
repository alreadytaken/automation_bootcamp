package com.PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	    public void makeOrder(String direccion) throws InterruptedException {
	    	driver.get("http://www.pedidosya.com");
	    	driver.manage().window().maximize();
	    	PedidosInitPage pedidosInitPage = new PedidosInitPage(driver);
	    	PedidosHomePage pedidosHomePage =new PedidosHomePage(driver);
	    	PedidosSuggestionPage pedidosSuggestionPage = new PedidosSuggestionPage(driver);
	    	PedidosConfirmOrder pedidosConfirmOrder = new PedidosConfirmOrder(driver);
	    	
	    	pedidosInitPage.clickBanderaUruguay();
	    	
	    	pedidosHomePage.submitDireccion(direccion);
	    	pedidosHomePage.clickConf();
	    	
	    	
	    	String precSuggestion = pedidosSuggestionPage.getPrecSuggestion();
	    	pedidosSuggestionPage.clickSuggestion();
	    	
	    	pedidosConfirmOrder.clickAddOrder();
	    	
	    	String dirFinal = pedidosConfirmOrder.getDirConf();
	    	
	    	LOG.info("La direccion ingresada es:"+direccion);
	    	LOG.info("La direccion final es:"+dirFinal);
	    	
	    	//Compara direccion ingresada con direccion final del pedido
	    	Assert.assertEquals(direccion,dirFinal);
	    	
	    	
	    	
	    	String precFinal = pedidosConfirmOrder.getPrecConf();
	    	
	    	LOG.info("El precio sugerido es:"+precSuggestion);
	    	LOG.info("El precio final es:"+precFinal);
	    	
	    	//Compara el precio que nos sugirio al precio final que nos cobra en el pedido
	    	Assert.assertEquals(precSuggestion, precFinal);
	    	
	    	pedidosConfirmOrder.getPrecConf();
	    	pedidosConfirmOrder.clickContinueButton();
	    	
 
            //new PopUpLogin(driver);
	    	
	    	
	    	
	    }
	
	
	
	
	
	
	
	
}
