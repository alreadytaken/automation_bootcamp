package com.globant.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class amazonHome {

	

	WebDriver driver;

	public amazonHome(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("twotabsearchtextbox"), driver);
		{
			PageFactory.initElements(driver, this);
		}
	}
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement lblBUsqueda;
	
	@FindBy(how = How.XPATH, using = "//div[@class='nav-search-submit nav-sprite']")
	private WebElement btnBuscar;

	public lentes buscarProductoLentes() {
		lblBUsqueda.sendKeys("Ray Ban aviator sunglasses");
		btnBuscar.click();
		return new lentes(driver);
	}

}
