package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaCountrySel {
	
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div/section/ul[@class='flags']//div[@class='flag-sprite uruguay']")
	WebElement countryButtonUruguay;
	
	public PedidosYaCountrySel (WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div/section/ul[@class='flags']//div[@class='flag-sprite uruguay']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public PedidosYaUruguayMain clickOnUruguay() {
		countryButtonUruguay.click();
		return new PedidosYaUruguayMain(driver);
	}
}
