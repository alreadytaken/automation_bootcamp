package com.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosInitPage {

	
	protected WebDriver driver;
	public PedidosInitPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="linkUy")
	WebElement BanderaUruguay;
	
	public void clickBanderaUruguay() {
		BanderaUruguay.click();
	}
	
	
	
}
