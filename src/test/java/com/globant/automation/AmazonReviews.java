package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonReviews {
	private WebDriver driver;
	
	@FindBy (how = How.ID, using = "dp-summary-see-all-review")
	WebElement productReviews;
	
	public AmazonReviews (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilClickable(By.id("dp-summary-see-all-reviews"), driver);
		PageFactory.initElements(driver, this);
	}
	public TopReviews getReviews() {
		productReviews.click();
		return new TopReviews(driver);
	}
}
