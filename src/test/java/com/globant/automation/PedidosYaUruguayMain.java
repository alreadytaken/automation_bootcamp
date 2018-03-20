package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaUruguayMain {

	@FindBy (how = How.XPATH, using = "//div[@class='content-input-location open']//input[@name='address']")
	WebElement addressInputBox;
	
	public PedidosYaUruguayMain (WebDriver driver){
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div[@class='content-input-location open']//input[@name='address']"), driver);
		PageFactory.initElements(driver, this);
	}

	public void ingresarDireccion (String direccion) {
		addressInputBox.sendKeys(direccion);
	}
}
