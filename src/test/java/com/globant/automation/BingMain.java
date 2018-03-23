package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingMain {
	
	private WebDriver driver;
	
	@FindBy (how = How.NAME, using = "q")
	WebElement searchBoxBing;
	
	public BingMain(WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilClickable(By.name("q"), driver);
		PageFactory.initElements(driver, this);
	}
	public BingSearchResult bingSearch (String termino) {
		searchBoxBing.sendKeys(termino);
		searchBoxBing.sendKeys(Keys.ENTER);
		return new BingSearchResult(driver);
	}
}