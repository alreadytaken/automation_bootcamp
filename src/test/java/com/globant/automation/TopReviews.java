package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TopReviews {
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div//div[@class='a-row view-point']//h4")
	WebElement positiveReview;
	@FindBy (how = How.XPATH, using = "//div//div[@class='a-row view-point']//h4")
	WebElement negativeReview;
	
	public TopReviews (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilVisibility(By.id("//div//div[@class='a-row view-point']//h4"), driver);
		PageFactory.initElements(driver, this);
	}
	public String getPositiveReview() {
		String positive = positiveReview.getText();
		return positive;
	}
	public String getNegativeReview() {
		String negative = negativeReview.getText();
		return negative;
	}
}
