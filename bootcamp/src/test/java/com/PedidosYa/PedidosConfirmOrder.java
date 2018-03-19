package com.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosConfirmOrder {


	protected WebDriver driver;
	public PedidosConfirmOrder(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy()
	WebElement selectOption;
	
	@FindBy()
	WebElement buttonAddOrder;
	
	@FindBy()
	WebElement continueButton;
	
	public void selectOpt() {
		
	}
	
    public void clickAddOrder() {
		buttonAddOrder.click();
	}
    
    public void clickContinueButton() {
		continueButton.click();
	}

	
	
	
	
	
	
	
	
}
