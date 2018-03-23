package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class HomePagePedidosYa {

	public WebDriver driver;

	@FindBy(how = How.ID, using = "linkUy")
	WebElement link;
		
	public HomePagePedidosYa(WebDriver driver) {
		this.driver = driver;
		
		if(!SeleniumUtils.isPresent(By.id("linkUy"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		
		PageFactory.initElements(driver, this);	
	}
		

	
	public PYHomePageUy ClickearUruguay() {
		/**String linkuy = driver.findElement(By.xpath("//*[@id=\"linkUy\"]")).getAttribute("href"); 
		driver.get(linkuy);*/
		link.click();
		
		return new PYHomePageUy(driver);
	}
	
	
	
}//class
