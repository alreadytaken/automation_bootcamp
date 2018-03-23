package com.globant.bootcamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpRegistro {

	@FindBy(how = How.ID, using = "signup")
	WebElement btnSignUp;

	WebDriver driver;

	public PopUpRegistro(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!SeleniumUtils.isPresentByPresenceOfElement(btnSignUp, driver)) {
			throw new IllegalStateException("Page did not load.");

		}

	}

}
