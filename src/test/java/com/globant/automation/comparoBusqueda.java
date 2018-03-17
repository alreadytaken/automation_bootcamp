package com.globant.automation;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class comparoBusqueda {
	
	 public comparoBusqueda() {

	    }

	    private static final Logger LOG;
	    private WebDriver driver;

	    static {
	        LOG = LogManager.getLogger(GoogleTest.class);
	    }

	    @Test
	    public void searchTest() throws InterruptedException {
	        LOG.info("Search test");
	       // driver.get("http://newtours.demoaut.com/");
	    }
	    
	    @BeforeMethod
	    public void prepareTest() throws MalformedURLException {
	    	

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

    @DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		LOG.info("Creamos la matriz");
		return new Object[][] {{"Pistachos"}
								};
	
	}
	@Test(dataProvider = "Authentication")
	public void comparoBusquedas(String a) {
		 driver.get("http://google.com.uy");
		 WebElement txtBusqueda= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda.sendKeys(a);
		 txtBusqueda.submit();
		 List<WebElement> resultadosGoogle = driver.findElements(By.xpath("//h3[@class='r']/a"));	
	     List<String> auxG = new ArrayList<>();
	     for(int i=0; i<5; i++) {
	    	 auxG.add(resultadosGoogle.get(i).getAttribute("innerHTML"));
	    	 LOG.info("Busqueda Google " + auxG.get(i));
	     }
		 //driver.close();
		 
		 driver.get("https://www.bing.com/");
		 WebElement txtBusqueda2= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda2.sendKeys(a);
		 txtBusqueda2.submit();
		 List<WebElement> resultadosBing = driver.findElements(By.xpath("//h2/a"));
		 List<String> auxB = new ArrayList<String>();
		 for(int i=0; i<5; i++) {
	    	 auxB.add(resultadosBing.get(i).getText());
	    	 LOG.info("Busqueda Bing " + auxB.get(i));
	     }
		 
		 for(int i=0; i<5; i++) {
			 Assert.assertNotEquals(auxB.get(i), auxG.get(i), "Comparo Resultados");
			 
		 }
	}

}
