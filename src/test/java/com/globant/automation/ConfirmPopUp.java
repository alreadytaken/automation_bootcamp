package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPopUp {

	@FindBy (how = How.XPATH, using = "//div[@id='mapContainer']//a[@id='confirm']")
	WebElement confirmButton;
	
	public ConfirmPopUp (WebDriver driver) {
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div[@id='mapContainer']//a[@id='confirm']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public void confirmarUbicacion(){
		confirmButton.click();
	}
	
}
