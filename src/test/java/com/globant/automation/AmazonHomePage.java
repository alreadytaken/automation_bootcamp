package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.util.SeleniumUtils;

public class AmazonHomePage extends PageObject {
	
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement searchbar;
	
	public AmazonHomePage (WebDriver driver) {
	    super(driver);
}
	
	public void inputintosearchbar (String input) {
		WebElement searchbar = SeleniumUtils.waitUntilClickable(By.id("twotabsearchtextbox"), driver);
		searchbar.sendKeys(input);
		searchbar.sendKeys(Keys.ENTER);
}
	
	

}
