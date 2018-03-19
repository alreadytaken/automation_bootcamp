package com.globant.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingMainPage {
	protected WebDriver driver;

	public BingMainPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "sb_form_q")
	private WebElement txtBusqueda;

	public BingSearchPage buscar(String busqueda) {
		txtBusqueda.sendKeys(busqueda);
		txtBusqueda.submit();
		return new BingSearchPage(driver);
	}
}
