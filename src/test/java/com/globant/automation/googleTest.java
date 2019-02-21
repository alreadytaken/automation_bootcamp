package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class googleTest extends BaseTest {
	
		    @Test
		    public void googleTest() {
		    	
		    driver.get("https://www.google.com");
	        WebElement searchElement = driver.findElement(By.name("q"));
	        searchElement.sendKeys("Youtube" + Keys.ENTER);
//	        WebElement button = driver.findElement(By.className("btnK"));
//		    button.click();
		    
		    
	}
}

