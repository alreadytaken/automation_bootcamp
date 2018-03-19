package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusquedaGoogleBingPO {
	private WebDriver driver;



	// GOOGLE OBJECTS
	@FindBy(id = "lst-ib")
	private WebElement googleLocator;
	@FindBy(id = "btnK")
	private WebElement buttonGoogleLocator;

	// BING OBJECTS
	@FindBy(id = "sb_form_q")
	private WebElement bingLocator;
	@FindBy(id = "sb_form_go")
	private WebElement buttonBingLocator;

	public void GoogleSearch(String search) {
		this.googleLocator.sendKeys(search);
	}

	public List<WebElement> resultGoogle(List<WebElement> result) {
		result = driver.findElements(By.xpath("//h3[@class='r']/a"));
		return result;
	}

	public void BingSearch(String search) {
		this.bingLocator.sendKeys(search);
	}

	public List<WebElement> resultBing(List<WebElement> result) {
		result = driver.findElements(By.xpath("//h2/a"));
		return result;
	}
	
	public BusquedaGoogleBingPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}