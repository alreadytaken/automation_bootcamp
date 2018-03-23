package com.globant.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	WebElement txtSearch;
	
	@FindBy(how = How.ID, using = "//input[@class=\"nav-input\"]")
	WebElement btnSearch;

	public HomePage (WebDriver driver){
		
		this.driver = driver;
		
		
		PageFactory.initElements(driver, this);	
		
		if (!SeleniumUtils.isPresentByPresenceOfElement(txtSearch, driver)){
			throw new IllegalStateException("Home page did not load.");
		}
	}

public ResultadosPage ingresarDatosBusqueda(String data) {
	
	txtSearch.sendKeys();
	btnSearch.click();
		return new ResultadosPage(driver);
}
	
	
	
	
	
	
}//class
