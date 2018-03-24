package com.globant.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends AmazonHomePage{
	

	@FindBy(how = How.ID, using = "")
	private WebElement review;
	
	public ProductPage (WebDriver driver) {
	    super(driver);
}

}
