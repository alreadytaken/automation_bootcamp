package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class credentialsPassword {
private WebDriver driver;
	
	@FindBy (how = How.ID, using = "i0118")
	WebElement mailInputBox;
	
	@FindBy (how = How.ID, using = "idSIButton9")
	WebElement nextBoxButton;
	
	public credentialsPassword(WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilClickable(By.id("i0118"), driver);
		SeleniumUtils.WaitUntilClickable(By.id("idSIButton9"), driver);
		PageFactory.initElements(driver, this);
	}
	public void passInputBox(String passWord){
		mailInputBox.sendKeys(passWord);
	}
	public CorreoMain nextBox(){
		nextBoxButton.click();
		return new CorreoMain (driver);
	}
}
