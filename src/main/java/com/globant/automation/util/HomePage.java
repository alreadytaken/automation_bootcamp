package com.globant.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement txtSearch;

	@FindBy(how = How.XPATH, using = "//input[@class=\"nav-input\"]")
	WebElement btnSearch;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
		System.out.println("INICIALIZO LAS COSAS");
		/**
		 * if (!SeleniumUtils.isPresentByPresenceOfElement(txtSearch, driver)){ throw
		 * new IllegalStateException("Home page did not load."); }
		 */
	}

	public ResultadosPage ingresarDatosBusqueda(String data) {
		System.out.println("ENTRO A INGRESAR DATOS");
		txtSearch.sendKeys(data);
		btnSearch.click();
		return new ResultadosPage(driver);
	}

}// class
