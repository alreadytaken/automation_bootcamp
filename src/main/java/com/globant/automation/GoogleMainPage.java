package com.globant.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
	protected WebDriver driver;

	public GoogleMainPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "lst-ib")
	private WebElement txtBusqueda;

	public GoogleSearchPage buscar(String busqueda) {
		txtBusqueda.sendKeys(busqueda);
		txtBusqueda.submit();
		return new GoogleSearchPage(driver);
	}
}
