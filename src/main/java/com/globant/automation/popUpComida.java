package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class popUpComida {

	WebDriver driver;

	public popUpComida(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='footerOpen']/a") , driver);
		{
			PageFactory.initElements(driver, this);
		}
	}
	@FindBy(how= How.XPATH ,using = "//div[@class='footerOpen']/a")
	private WebElement btnAgregarPedido;
	
	public restoQueVoyAPedir agregarAMiPedido() {
		btnAgregarPedido.click();
		return new restoQueVoyAPedir(driver);
	}
}
