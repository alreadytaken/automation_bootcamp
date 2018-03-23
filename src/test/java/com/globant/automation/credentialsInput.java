package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class credentialsInput {

	private WebDriver driver;
	
	@FindBy (how = How.ID, using = "i0116")
	WebElement mailInputBox;
	
	@FindBy (how = How.ID, using = "idSIButton9")
	WebElement nextBoxButton;
	
	public credentialsInput(WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilClickable(By.id("i0116"), driver);
		SeleniumUtils.WaitUntilClickable(By.id("idSIButton9"), driver);
		PageFactory.initElements(driver, this);
	}
	public void mailInputBox(String mail){
		mailInputBox.sendKeys(mail);
	}
	public credentialsPassword nextBox(){
		nextBoxButton.click();
		return new credentialsPassword(driver);
	}
}
