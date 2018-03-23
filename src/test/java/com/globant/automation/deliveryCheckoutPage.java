package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class deliveryCheckoutPage {
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//section[@id='deliveryAddress']//label[@for='address_0']/b")
	WebElement userLoggedName;
	
	
	public deliveryCheckoutPage (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilVisibilityList(By.xpath("//section[@id='deliveryAddress']//label[@for='address_0']/b"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getUserLoggedName() {
		String NombreDelUsuario=userLoggedName.getText();
		return NombreDelUsuario;
	}
}
