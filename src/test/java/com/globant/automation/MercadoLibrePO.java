package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercadoLibrePO {

	//private final WebDriver driver;
	
	private WebDriver driver;

	public MercadoLibrePO(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[1]/section[13]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/span[1]/span[2]")
		private WebElement homePrice;
		
		@FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[1]/section[13]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/span[2]")
		private WebElement homeDiscount;
		
		@FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[1]/section[13]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/p[1]")
		private WebElement homeName;
		
		//metodo de extracción del home
	   public List<String> getHomePrice() {
		   
		      
		   List<String> priceHome = new ArrayList();
		   priceHome.add(homePrice.getText());
		   priceHome.add(homeDiscount.getText());
		   priceHome.add(homeName.getText());
		   	 
	       return priceHome;
	    }
	   /*
	   
	   public GoogleBingTestPO submitGoogleSearch() {
	        this.buttonGoogleLocator.click();
	        return new GoogleBingTestPO(driver);
	    }
	   
	   public List<WebElement> resultGoogleSearch(List<WebElement> result) {
		   result = driver.findElements(By.xpath("//h3[@class='r']/a"));
		   return result;
	   }
	  
	   public void typeBingSearch(String search) {
		   	this.searchBingLocator.clear();
		   	this.searchBingLocator.sendKeys(search);
	   }
	   
	   public GoogleBingTestPO submitBingSearch() {
	       	this.buttonBingLocator.click();
	       	return new GoogleBingTestPO(driver);
	   }
	   
	   public List<WebElement> resultBingSearch(List<WebElement> result) {
		   result = driver.findElements(By.xpath("//h2/a"));
		   return result;
	   }
	   
		*/
		//PageFactory.initElements(driver, this);
	
	
		
}
