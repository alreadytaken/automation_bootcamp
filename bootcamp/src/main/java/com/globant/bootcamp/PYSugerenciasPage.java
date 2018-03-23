package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PYSugerenciasPage {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//span[@class=\"promo\" and contains(text(), \"Milanesa completa al pan con papas fritas\")]")
	WebElement WEsugerenciaComida;
	
	@FindBy(how= How.XPATH, using = "//a[@class = \"peyaCard js-fp-card\"][@data-id=\"27865\"]")
	WebElement WEContainer;
	
	public PYSugerenciasPage(WebDriver driver) {
			this.driver = driver;
		
		
			PageFactory.initElements(driver, this);	
			
			if (!SeleniumUtils.isPresentByPresenceOfElement(WEsugerenciaComida, driver)){
				throw new IllegalStateException("Page did not load.");
			}
			
	}
	
	public String tomarPrecio() {
	String precioSugerencia = driver.findElement(By.xpath("//span[@class=\"promo\" and contains(text(), \"Milanesa completa al pan con papas fritas\")]/..//span[@class=\"after_price\"]")).getAttribute("innerHTML");
	System.out.println("EL PRECIO DE LA SUGERENCIA ES: " +precioSugerencia);
	return precioSugerencia;
	}
	
	
	
	public PopUpAgregarPedido ClickearPedido() {
		
		WEContainer.click();
		System.out.println("CLICKEO EL PEDIDO");
		
		
		return new PopUpAgregarPedido(driver);
	}
	
}//class
