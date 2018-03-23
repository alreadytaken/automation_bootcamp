package com.globant.bootcamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopUpModalLogin {

	@FindBy(how = How.XPATH, using = "//a[@href=\"/signup?lite=true&go=%2Fcheckout\"]")
	WebElement hrefRegistrate;

	WebDriver driver;

	public PopUpModalLogin(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!SeleniumUtils.isPresentByPresenceOfElement(hrefRegistrate, driver)) {
			throw new IllegalStateException("Page did not load.");
		}
	}

	public PopUpRegistro clickRegistrar() {
		hrefRegistrate.click();

		return new PopUpRegistro(driver);
	}

}
