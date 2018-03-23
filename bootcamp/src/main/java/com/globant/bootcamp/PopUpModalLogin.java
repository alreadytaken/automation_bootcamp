package com.globant.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpModalLogin {

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPass;

	@FindBy(how = How.NAME, using = "email")
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "login")
	WebElement btnIngresar;

	WebDriver driver;

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(RestaurantPage.class);
	}

	public PopUpModalLogin(WebDriver driver) {
		LOG.info("ENTRO AL POPUP DE LOGIN");
		this.driver = driver;
		LOG.info("NO ES EL DRIVER");
		PageFactory.initElements(driver, this);

		if (!SeleniumUtils.isPresentByPresenceOfElement(txtEmail, driver)) {
			throw new IllegalStateException("The login page did not load.");
		}
		LOG.info("SALIO DE LA ESPERA YEYYY");

	
	}

	public ConfirmarPedidoPage sendDataToLogin() {
		LOG.info("ENTRO A CONFIRMAR PEDIDO PAGEEEEEEEE");
		txtEmail.sendKeys("camilasilvalopez@gmail.com");
		txtPass.sendKeys("algoalgo123");
		btnIngresar.click();
		LOG.info("INGRESO LOS DATOS Y CLICKEO Y AHORA VA A HACER EL SWITCH DENUEVO OJO ANOTÁ");
		driver.switchTo().defaultContent();
		return new ConfirmarPedidoPage(driver);

	}

}
