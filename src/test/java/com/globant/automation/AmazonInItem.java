package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonInItem {
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div//div[@class='s-item-container']")
	WebElement firstProduct;
	
	public AmazonInItem (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div/*//*[contains(text(),'FREE Shipping')]"), driver);
		PageFactory.initElements(driver, this);
	}
	public AmazonReviews clickFirstItem() {
		firstProduct.click();
		return new AmazonReviews(driver);
	}
}
