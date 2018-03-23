package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class restaurantes {

	WebDriver driver;

	public restaurantes(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.xpath("//a[@class=\"peyaCard js-fp-card\"][@data-id=\"27865\"]"), driver);
		{
			PageFactory.initElements(driver, this);
		}
	}
	@FindBy(how= How.ID,using = "//a[@class=\"peyaCard js-fp-card\"][@data-id=\"27865\"]")
	private WebElement imgMilanga;
	
	public popUpComida selecionarComida() {
		imgMilanga.click();
		return new popUpComida(driver);
	}

}
