package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//public class MercuryHomePage extends BasePage;
public class MercuryHomePage {
	
	public MercuryHomePage(WebDriver driver) {
		SeleniumUtils.waitUntilClickable(By.name("login"), driver);
	}
	@FindBy(how = How.NAME, using ="userName")
	private WebElement userInput; 
	
	@FindBy(how = How.NAME, using ="password")
	private WebElement passwordInput;
	
	@FindBy(how = How.NAME, using ="login")
	private WebElement signInButtont;

	
	
	public void logIn(String user, String pass) {
		userInput.sendKeys(user);		
		passwordInput.sendKeys(user);
		
		//return new UserInPage(driver)
	}
}



/*
	public StudentPage
	WebElement std = SeleniumUtils.getElement("//table//tr[text()="name"],30);
	std.click();
	
	
*/
 */