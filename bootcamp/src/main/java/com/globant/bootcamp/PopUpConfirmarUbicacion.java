package com.globant.bootcamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpConfirmarUbicacion {

	@FindBy(how = How.XPATH, using = "//*[@id='confirm']")
	WebElement btnConfirmarUbicacion;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mapContainer\"]")
	WebElement mapContainer;

	WebDriver driver;

	public PopUpConfirmarUbicacion(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!(SeleniumUtils.waitUntilClickeable(btnConfirmarUbicacion, driver) != null)) {
			throw new IllegalStateException("Pop up did not load.");
		}

	}

	public PYSugerenciasPage ConfirmarUbicacionPopUp() {

		btnConfirmarUbicacion.click();

		return new PYSugerenciasPage(driver);

	}

}// class
