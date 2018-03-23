package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPopUp {
	private WebDriver driver;

	@FindBy(how = How.NAME, using = "email")
	WebElement loginUsernameBox;
	@FindBy(how = How.NAME, using = "password")
	WebElement loginPasswordBox;
	@FindBy(how = How.XPATH, using = "//div[@id='loginDiv']//input[@type='submit']")
	WebElement submitButton;

	public LogInPopUp(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.WaitUntilVisibility(By.name("email"), driver);
		PageFactory.initElements(driver, this);
	}

	public void ingresarUsuario(String Usuario) {
		loginUsernameBox.sendKeys(Usuario);
	}

	public void ingresarPassword(String Password) {

		loginPasswordBox.sendKeys(Password);
	}

	public deliveryCheckoutPage clickLoginButton() {

		submitButton.click();
		driver.switchTo().defaultContent();
		return new deliveryCheckoutPage(driver);
	}
}
