package com.globant.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class googleTest extends BaseTest {
	
		@DataProvider (name = "busquedas")
		
		 public static Object[][] busquedas() {
			 
	        return new Object[][] { { "twitter", "Youtube", "Twitch" }};
	 
	  }
				
		    @Test (dataProvider = "busquedas")
		    public void googleTest(String busqueda1, String busqueda2, String busqueda3) {
		    	
		    driver.get("http://www.google.com.uy");
	        driver.findElement(By.name("q")).sendKeys(busqueda1 + Keys.ENTER);
	        driver.findElement(By.name("q")).clear();
	        driver.findElement(By.name("q")).sendKeys(busqueda2 + Keys.ENTER);
	        driver.findElement(By.name("q")).clear();
	        driver.findElement(By.name("q")).sendKeys(busqueda3 + Keys.ENTER);
	        	         
	}
		  
}
