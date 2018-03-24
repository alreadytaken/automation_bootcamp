package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonReviewPage {

	
	protected WebDriver driver;

	public AmazonReviewPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(By.xpath("//div[contains(@class,'a-row a-spacing-top-mini')]/span[contains(@class,'a-size-base')]"), driver);

	}

	@FindBy(xpath=("//div[contains(@class,'a-row a-spacing-top-mini')]/span[contains(@class,'a-size-base')]"))
	List <WebElement> Reviews;

	
	List<WebElement> Criticas;

	public List<WebElement> getReviews() {

		return Reviews;
	}

	

}

