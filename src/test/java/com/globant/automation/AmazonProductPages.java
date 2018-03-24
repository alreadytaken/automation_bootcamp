package com.globant.automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonProductPages {
	protected WebDriver driver;

	public AmazonProductPages(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(producto, driver);

	}
	
	
	

	@FindBy(xpath = "//li[@class='s-result-item s-result-card-for-container a-declarative celwidget  ']//span[contains(@class,'sx-price-whole')]")
	WebElement producto;

	
	public void clickProducto() {
		SeleniumUtils.waitUntilClickable(producto, driver);
				producto.click();
		
		
	}
}
