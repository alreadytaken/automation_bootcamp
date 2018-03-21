package com.globant.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpConfirmarUbicacion {
	
	
private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(TestValidarDatosPedido.class);
	}
	
	
	@FindBy(how = How.ID, using = "confirm")
	WebElement btnConfirmarUbicacion;
	
	WebDriver driver;
	
	
	public PopUpConfirmarUbicacion(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);	
		
		if (SeleniumUtils.isPresentByPresenceOfElement(btnConfirmarUbicacion, driver)!= null){
			throw new IllegalStateException("Page did not load.");
		}
		
	}
	
	public PYSugerenciasPage ConfirmarUbicacionPopUp() {
		
		btnConfirmarUbicacion.click();
		LOG.info("CLICKEO BOTON CONFIRMAR UBICACION ////");
		return new PYSugerenciasPage(driver);
		
	}

}//class
