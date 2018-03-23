package com.EjMail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PedidosYa.SeleniumUtils;

public class GmailHomePage {

	
	protected WebDriver driver;
	public GmailHomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);

		
	}
	
	@FindBy(name="identifier")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pass;
	
	public void putEmail(String text) {
		SeleniumUtils.waitUntilClickable(email, driver);
		email.click();
		email.sendKeys(text);
		email.sendKeys(Keys.ENTER);
	}
	
      public void putPassword(String text) {
    	  SeleniumUtils.waitUntilClickable(pass, driver);
  		pass.click();
  		pass.sendKeys(text);
  		pass.sendKeys(Keys.ENTER);
	}
	
	
	
	
}
