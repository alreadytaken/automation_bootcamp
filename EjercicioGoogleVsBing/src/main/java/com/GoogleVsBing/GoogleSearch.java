package com.GoogleVsBing;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearch extends GoogleHome {
	WebDriver driver;
	public GoogleSearch(WebDriver driver) {
		super(driver);
		this.driver=driver;
		

		
	}
	
	
	public static Logger LOG=LogManager.getLogger(GoogleSearch.class);
	
	@FindBy(xpath="//div[@class='rc']/h3/a")
	List <WebElement> linksGoogle;
	
	public void enterValues(String text) {
		
		this.buscador.click();
		this.buscador.sendKeys(text);
		this.buscador.sendKeys(Keys.ENTER);
	}

	     public List<WebElement> getSelects() {
	        return linksGoogle;
	  }  
}
