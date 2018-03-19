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

public class BingHomePage extends PageObject {
	@FindBy(how = How.ID, using = "lst-ib")
	private WebElement searchbar;
	
	public BingHomePage(WebDriver driver) {
        super(driver);
	}
	
	public  void inputsearchbar(String q) {
		WebElement searchbar = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		searchbar.sendKeys(q);
		searchbar.sendKeys(Keys.ENTER);
	}
	
	public  List<WebElement> BingElements(){
		List<WebElement> BingElements = driver.findElements(By.xpath("//*[@class='rc']/h2/a"));
		return BingElements;
	}
}