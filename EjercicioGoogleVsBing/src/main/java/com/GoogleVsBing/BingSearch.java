package com.GoogleVsBing;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearch extends BingHome {

	WebDriver driver;
	public BingSearch(WebDriver driver) {
		super(driver);
		this.driver=driver;
		

		
	}
	
	
	public static Logger LOG=LogManager.getLogger(GoogleSearch.class);
	
	@FindBy(xpath="//li[@class='b_algo']/h2/a")
	List <WebElement> linksBing;
	
	
	public void enterValues2(String text) {
		
		this.buscador.click();
		this.buscador.sendKeys(text);
		this.buscador.sendKeys(Keys.ENTER);
	}

	     public List<WebElement> getSelectsBing() {
	        return linksBing;
	  }  
}
