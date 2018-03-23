package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CorreoLogInit {
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div//div[@class='buttonLargeBlue']")
	WebElement logInit;
	
	public CorreoLogInit(WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilClickable(By.xpath("//div//div[@class='buttonLargeBlue']"), driver);
		PageFactory.initElements(driver, this);
	}
	public credentialsInput logInitClick(){
		logInit.click();
		return new credentialsInput(driver);
	}
	
}
