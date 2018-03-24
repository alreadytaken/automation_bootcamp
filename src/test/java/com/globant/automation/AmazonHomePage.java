package com.globant.automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonHomePage {

	protected WebDriver driver;

	public AmazonHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(buscador, driver);

	}
	
	
	

	@FindBy(id = "twotabsearchtextbox")
	WebElement buscador;

	
	public void sendData(String text) {
		buscador.click();
		buscador.sendKeys(text);
		buscador.sendKeys(Keys.ENTER);
		
	}
}
