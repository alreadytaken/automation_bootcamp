package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.util.SeleniumUtils;

public class AmazonSearchResults extends AmazonHomePage {
	
	@FindBy(how = How.ID, using = "result_4")
	private WebElement producto;
	
	public AmazonSearchResults (WebDriver driver) {
	    super(driver);
}
	
	public ProductPage click() {
		WebElement producto = SeleniumUtils.waitUntilClickable(By.id("result_4"), driver);
		producto.click();
		return new ProductPage(driver);
	}

}
