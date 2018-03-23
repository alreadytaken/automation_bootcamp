package com.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpLogin {

	protected WebDriver driver;

	public PopUpLogin(WebDriver driver) {

		this.driver = driver;
		SeleniumUtils.waitUntilPresence(By.xpath("//div/iframe"), driver);
		WebElement iframe = driver.findElement(By.xpath("//div/iframe"));
		driver.switchTo().frame(iframe);
		SeleniumUtils.waitUntilClickable(By.name("login"), driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login")
	WebElement logInButton;

	public void logIn(String text) {
		SeleniumUtils.waitUntilClickable(email, driver);
		email.click();
		email.sendKeys(text);

	}

	public void logIn2(String text) {
		SeleniumUtils.waitUntilClickable(password, driver);

		password.click();
		password.sendKeys(text);
		password.sendKeys(Keys.ENTER);

	}

	public void clickLogButton() {
		logInButton.click();
	}

}
