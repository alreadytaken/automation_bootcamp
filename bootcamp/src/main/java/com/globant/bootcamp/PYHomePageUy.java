package com.globant.bootcamp;

import org.openqa.selenium.WebDriver;

public class PYHomePageUy {

	WebDriver driver;
	
	
	public PYHomePageUy(WebDriver driver) {
		this.driver = driver;
	}

	
	
	public void IngresarDatos() {
		
		
	}
	
	public PYSugerenciasPage ClickContinuar() {
		
		
		
		return new PYSugerenciasPage(driver);
	}
	
	
	
}
