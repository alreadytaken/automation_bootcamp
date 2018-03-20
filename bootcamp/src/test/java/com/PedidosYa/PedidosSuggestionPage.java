package com.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosSuggestionPage {

	protected WebDriver driver;
	public PedidosSuggestionPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//div[contains(@class,'content_info')]/span[text()='Milanesa completa al pan con papas fritas']")
	WebElement foodSuggestion;
	
	@FindBy(xpath="//div[contains(@class,'content_info')]/span[text()='Milanesa completa al pan con papas fritas']/following::span[contains(@class,'after_price')]")
	WebElement priceSuggestion;
	
	String PrecSuggestion;
	
	public void clickSuggestion() {
		SeleniumUtils.waitUntilClickable(foodSuggestion, driver);
		foodSuggestion.click();
		
	}
	public String getPrecSuggestion() {
        PrecSuggestion = priceSuggestion.getText();
		return PrecSuggestion;
	}



}
