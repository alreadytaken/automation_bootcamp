package com.globant.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends AmazonHomePage{
	

	@FindBy(how = How.XPATH, using = "//*[@id='customer_review-R5EI4C8P5MRZI']/div[4]/span/div/div[1]")
	private WebElement review;
	
	public ProductPage (WebDriver driver) {
	    super(driver);
}
	
	

}
