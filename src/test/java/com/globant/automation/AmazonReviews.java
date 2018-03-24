package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonReviews {

	private WebDriver driver;

	public AmazonReviews(WebDriver driver) {

		this.driver = driver;

		if (!SeleniumUtils.isPresent(By.xpath("//div[contains(@class,'positive-review')]"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
	}
}
