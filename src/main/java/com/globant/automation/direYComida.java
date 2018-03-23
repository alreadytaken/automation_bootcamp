package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class direYComida {
	
	WebDriver driver;

	
	public direYComida(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("search"), driver); {
		PageFactory.initElements(driver, this);			
		}	
	}	
	
	@FindBy(how= How.ID,using = "adress")
	private WebElement adress;
	
	@FindBy(how= How.ID,using = "optional")
	private WebElement food;
	
	@FindBy(how= How.ID,using = "search")
	private WebElement btnSearch;
	
	public popUpDireccion irAMapaApretandoElBoton() {
		adress.sendKeys("Nicaragua 1666");
		food.sendKeys("milanesa");
		btnSearch.click();
		return new popUpDireccion(driver);
	}
}
