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
		SeleniumUtils.waitUntilClickable(Reviews2, driver);

	}

	@FindBy(xpath="//span[contains(@id,'acrCustomerReviewText')]")
	WebElement Reviews2h;
	
	@FindBy(xpath="//div[contains(@class,'a-row a-spacing-mini')]")
	WebElement Reviews2;

	

	public void clickReview() {
		
		SeleniumUtils.waitUntilClickable(Reviews2, driver);
		Reviews2.click();
		
		
		
	}
	public void clickReview2h() {
		SeleniumUtils.waitUntilClickable(Reviews2, driver);

		SeleniumUtils.waitUntilClickable(Reviews2h, driver);
		Reviews2h.click();
		
		
		
	}

	

}