package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class HomePagePedidosYa {

	public WebDriver driver;

		
	public HomePagePedidosYa(WebDriver driver) {
		this.driver = driver;
		
		if(!SeleniumUtils.isPresent(By.xpath("//*[@id=\\\"linkUy\\\"]"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		
		PageFactory.initElements(driver, this);	
	}
		

	
	public PYHomePageUy ClickearUruguay() {
		String linkuy = driver.findElement(By.xpath("//*[@id=\"linkUy\"]")).getAttribute("href"); 
		driver.get(linkuy);
		return new PYHomePageUy(driver);
	}
	
	
	
}//class
