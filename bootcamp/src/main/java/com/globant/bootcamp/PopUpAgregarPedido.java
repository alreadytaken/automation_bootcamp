package com.globant.bootcamp;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpAgregarPedido {

	@FindBy(how = How.XPATH, using = "//a[@class = \"button\"]")
	WebElement btnConfirmarPedido;
	
	WebDriver driver;
	
private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(PopUpAgregarPedido.class);
	}
	
	
	public PopUpAgregarPedido(WebDriver driver){
		
		this.driver = driver;
		
		
		PageFactory.initElements(driver, this);	
		
		if (!SeleniumUtils.isPresentByPresenceOfElement(btnConfirmarPedido, driver)){
			throw new IllegalStateException("Page did not load.");
		}
		
}

		
		public RestaurantPage ConfirmarPedido() {
		LOG.info("ENTRO A CLICKEAR CONFIRMAR PEDIDO");
		btnConfirmarPedido.click();
		LOG.info("CLICKEO CONFIRMAR PEDIDO");
		
		return new RestaurantPage(driver);
	}
	
	
	
	
	
}
