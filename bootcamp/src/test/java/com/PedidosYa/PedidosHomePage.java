package com.PedidosYa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosHomePage {

	
	protected WebDriver driver;
	public PedidosHomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	@FindBy(name="address")
	WebElement BarraDireccion;
	
	@FindBy(id="confirm")
	WebElement buttonConf;
	
	
	
	
	public void submitDireccion(String text) {
		BarraDireccion.click();
		BarraDireccion.sendKeys(text);
		BarraDireccion.sendKeys(Keys.ENTER);
		
	}
	
	public void clickConf() {
		SeleniumUtils.waitUntilClickable(buttonConf, driver);
		buttonConf.click();
	}
	
	
	
}
