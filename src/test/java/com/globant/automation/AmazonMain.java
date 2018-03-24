package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonMain {

	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
	WebElement searchInputBox;
	
	public AmazonMain (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div/div[@class='a-carousel-row-inner']"), driver);
		PageFactory.initElements(driver, this);
	}
	public AmazonInItem ingresarTerminoBusqueda (String searchTerm) {
		searchInputBox.sendKeys(searchTerm);
		searchInputBox.sendKeys(Keys.ENTER);
		return new AmazonInItem(driver);
	}
}
