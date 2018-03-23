package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class popUpDireccion {

	WebDriver driver;

	public popUpDireccion(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("confirm"), driver); {
		PageFactory.initElements(driver, this);			
		}	
	}
	@FindBy(how= How.ID,using = "confirm")
	private WebElement btnConfirm;
	
	public restaurantes irATodosLosRestaurantesApretandoBoton() {
		btnConfirm.click();
		return new restaurantes(driver);
	}
}
