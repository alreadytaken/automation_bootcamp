package com.globant.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpAgregarPedido {

	@FindBy(how = How.XPATH, using = "//a[@class = \"button\"]")
	WebElement btnConfirmarPedido;

	WebDriver driver;

	public PopUpAgregarPedido(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!SeleniumUtils.isPresentByPresenceOfElement(btnConfirmarPedido, driver)) {
			throw new IllegalStateException("Page did not load.");
		}

	}

	public RestaurantPage ConfirmarPedido() {
		
		btnConfirmarPedido.click();
		
		return new RestaurantPage(driver);
	}

}
