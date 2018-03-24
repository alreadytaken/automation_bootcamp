package com.globant.automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonProductPage {

	protected WebDriver driver;

	public AmazonProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(Reviews, driver);

	}

	@FindBy(xpath="//div[contains(@class,'a-row a-spacing-mini')]")
	WebElement Reviews;

	

	public void clickReview() {
		Reviews.click();
		
		
		
	}

	

}