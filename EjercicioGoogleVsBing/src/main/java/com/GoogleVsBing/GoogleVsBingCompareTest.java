package com.GoogleVsBing;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class GoogleVsBingCompareTest {

	
	public static WebDriver driver;
	public static Logger LOG=LogManager.getLogger(GoogleVsBingCompareTest.class);
	
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
	
	    
	    
	@DataProvider(name="5values")
		public Object [][] provider() {
		 return new Object [][] {{"primero"},{"Segundo"},{"Tercero"},{"Cuarto"},{"Quinto"}};
	}
	
	    
	@Test(dataProvider="5values")
	public void buscar(String enviar){
		LOG.info("GoogleVsBingComparacion");
		driver.get("http://www.google.com");
		GoogleSearch googleSearch = new GoogleSearch(driver);
		googleSearch.enterValues(enviar);
		
		List <WebElement> resultados = googleSearch.getSelects();
	    List <String> google=new ArrayList<>();
        for(int i=0;i<5;i++) {
        String texto = resultados.get(i).getText();
        google.add(texto);
        google.get(i);
        }
        
        
        
        driver.get("https://www.bing.com");
        BingSearch bingSearch = new BingSearch(driver);
        bingSearch.enterValues2(enviar);
        List <WebElement> resultados2= bingSearch.getSelectsBing(); 
        List <String> bing=new ArrayList<>();
        for(int i=0;i<5;i++) {
        String texto2 = resultados2.get(i).getText();
        bing.add(texto2);
        bing.get(i);
        
        
        }
        
       for(int i =0;i<5;i++) {
    	   
    	   Assert.assertEquals(google.get(i), bing.get(i));
    	   
       }
	
	}
}
