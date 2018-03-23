package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPopUp {
	private WebDriver driver;
	@FindBy (how = How.XPATH, using = "//div[@id='mapContainer']//a[@id='confirm']")
	WebElement confirmButton;
	
	public ConfirmPopUp (WebDriver driver) {
		this.driver=driver;
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div[@id='searchMap']//div[@class='gmnoprint']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public PedidosYaAgregarAlPedido confirmarUbicacion(){
		confirmButton.click();
		return new PedidosYaAgregarAlPedido(driver);
	}

}
