package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonSelected {
	
	private WebDriver driver;

	public AmazonSelected(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.xpath("//a[@id='dp-summary-see-all-reviews']"), driver)) {
			throw new IllegalStateException("Page did not load");
		}		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='dp-summary-see-all-reviews']")
	private WebElement seeReviews;
	
	
	public AmazonReviews viewReview() {
		this.seeReviews.click();
		return new AmazonReviews(driver);
	}

}
