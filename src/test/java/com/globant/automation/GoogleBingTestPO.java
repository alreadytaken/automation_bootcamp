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

public class GoogleBingTestPO {

	//private final WebDriver driver;
	
	private WebDriver driver;

	public GoogleBingTestPO(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
		
		//Google stuff
		@FindBy(id="lst-ib")
		private WebElement searchGoogleLocator;
		@FindBy(name="btnK")
		private WebElement buttonGoogleLocator;
		
		//Bing stuff
		@FindBy (id="sb_form_q")
		private WebElement searchBingLocator;
		@FindBy (id="sb_form_go")
		private WebElement buttonBingLocator;
		
		/*
		By searchGLocator = By.id("lst-ib");
		By searchButtonGLocator = By.name("btnK");
		
	
		By searchBLocator = By.id("sb_form_q");
		By searchButtonBLocator = By.id("sb_form_go");
		*/
		
		// metodo para ingresar el texto a buscar
	   public void typeGoogleSearch(String search) {
	       this.searchGoogleLocator.clear();
	       this.searchGoogleLocator.sendKeys(search);
	    }
	   
	   
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
	   
		
		//PageFactory.initElements(driver, this);
	
	
		
}
