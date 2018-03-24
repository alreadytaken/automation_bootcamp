package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonSearch {
	private WebDriver driver;

	public AmazonSearch(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.xpath("//input[@type=\"submit\"]"), driver)) {
			throw new IllegalStateException("Page did not load");
		}		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h2[contains(@class,'a-text-normal')]")
	private WebElement item;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	public void typeSearch(String data) {
		this.search.sendKeys(data);
	}
	
	public AmazonSelected selectItem() {
		this.item.click();
		return new AmazonSelected(driver);
	}
	
}
