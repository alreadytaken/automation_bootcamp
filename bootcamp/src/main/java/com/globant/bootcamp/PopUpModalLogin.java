package com.globant.bootcamp;

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

	public PopUpModalLogin(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!((SeleniumUtils.waitUntilClickeable(txtEmail, driver)) != null)) {
			throw new IllegalStateException("The login page did not load.");
		}

	}

	public ConfirmarPedidoPage sendDataToLogin() {

		txtEmail.sendKeys("camilasilvalopez@gmail.com");
		txtPass.sendKeys("algoalgo123");
		btnIngresar.click();

		driver.switchTo().defaultContent();
		return new ConfirmarPedidoPage(driver);

	}

}
