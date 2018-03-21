package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaUruguayMain {

	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div[@class='content-input-location open']//input[@name='address']")
	WebElement addressInputBox;
	
	@FindBy (how = How.XPATH, using = "//div[@class='content-input-location open']//input[@name='optional']")
	WebElement foodInputBox;
	@FindBy (how = How.XPATH, using = "//div[@class='content-input-location open']//button[@id='search']")
	WebElement searchButton;
	
	
	public PedidosYaUruguayMain (WebDriver driver){
		this.driver=driver;
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div[@class='content-input-location open']//input[@name='address']"), driver);
		PageFactory.initElements(driver, this);
	}

	public void ingresarDireccion (String direccion) {
		addressInputBox.sendKeys(direccion);
	}
	public void ingresarComidaRestaurante (String comidaRestaurante) {
		foodInputBox.sendKeys(comidaRestaurante);
	}
	public ConfirmPopUp clickEnBuscar(){
	searchButton.click();
	return new ConfirmPopUp(driver);
	}
}
