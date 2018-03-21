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
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"confirm\"]")
	WebElement btnConfirmarUbicacion;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mapContainer\"]")
	WebElement mapContainer;
	
	WebDriver driver;
	
	
	public PopUpConfirmarUbicacion(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);	
		
		if (SeleniumUtils.waitUntilClickeable(mapContainer, driver)!= null){
			throw new IllegalStateException("Pop up did not load.");
		}
		
	}
	
	public PYSugerenciasPage ConfirmarUbicacionPopUp() {
		LOG.info("BOTON CONFIRMAR //// "+btnConfirmarUbicacion);
		btnConfirmarUbicacion.click();
		LOG.info("CLICKEO BOTON CONFIRMAR UBICACION ////");
		return new PYSugerenciasPage(driver);
		
	}

}//class
