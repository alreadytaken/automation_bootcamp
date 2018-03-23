package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class popUpRegistro {
	
	WebDriver driver;

	public popUpRegistro(WebDriver driver) {
		this.driver = driver;
		if(!SeleniumUtils.isPresent(By.id("login"), driver)) {
			throw new IllegalStateException("Button did not load.");
		}
		PageFactory.initElements(driver, this);		
	}

	@FindBy(how= How.ID,using = "login")
	private WebElement btnLogin;
}
