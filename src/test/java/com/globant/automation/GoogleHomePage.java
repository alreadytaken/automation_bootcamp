package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends PageObject {
	@FindBy(how = How.ID, using = "lst-ib")
	private WebElement searchbar;
	
	public GoogleHomePage(WebDriver driver) {
        super(driver);
	}
	
	public  void inputsearchbar(String q) {
		WebElement searchbar = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		searchbar.sendKeys(q);
		searchbar.sendKeys(Keys.ENTER);
	}

}

