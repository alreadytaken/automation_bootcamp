package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class restoQueVoyAPedir {
	
	WebDriver driver;

	public restoQueVoyAPedir(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("order") , driver);
		{
			PageFactory.initElements(driver, this);
		}
	}
	@FindBy(how= How.ID,using = "order")
	private WebElement btnPedir;

	public popUpRegistro agregarAMiPedido() {
		btnPedir.click();
		return new popUpRegistro(driver);
	}
}
