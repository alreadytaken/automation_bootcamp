package com.globant.bootcamp;

import org.openqa.selenium.WebDriver;

public class HomePagePedidosYa {

	public WebDriver driver;

	public HomePagePedidosYa(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public PYHomePageUy ClickearUbicacion() {
	
		
		return new PYHomePageUy(driver);
	}
	
	
	
}//class
