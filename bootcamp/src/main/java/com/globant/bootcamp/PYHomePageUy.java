package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PYHomePageUy {

	WebDriver driver;
	
	@FindBy(how = How.NAME, using = "address")
	WebElement txtAdress;

	@FindBy(how = How.NAME, using = "optional")
	WebElement txtOpcionalComida;
	
	@FindBy(how = How.ID, using = "search")
	WebElement BtnSearch;
	
	public PYHomePageUy(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);	
		
		if((SeleniumUtils.isPresentByPresenceOfElement(txtAdress, driver)!= null) && (!SeleniumUtils.isPresent(By.name("optional"), driver)) && (!SeleniumUtils.isPresent(By.id("search"), driver))){
			throw new IllegalStateException("Page did not load.");
		}
		
		
	}
		

	
	
	public PYSugerenciasPage IngresarDatos() {
		
		txtAdress.sendKeys("Nicaragua 1666");
		txtOpcionalComida.sendKeys("Milanesa");
		BtnSearch.click();
		
		return new PYSugerenciasPage(driver);
	}
	
	
	
	
}
