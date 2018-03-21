package com.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosCheckOut {

	protected WebDriver driver;
	public PedidosCheckOut(WebDriver driver) {
		
		
	        this.driver=driver;
		PageFactory.initElements(driver,this);
		SeleniumUtils.waitUntilPresence(By.xpath("//div[contains(@class,'cart-subtitle')]/a"), driver);
		
		
	}
	
	@FindBy(xpath="//div[contains(@class,'cart-subtitle')]/a")
	WebElement modPedido;
	
	public void clickModPedido() {
		modPedido.click();
		
	}
	
	
}
