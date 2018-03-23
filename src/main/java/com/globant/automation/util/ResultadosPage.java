package com.globant.automation.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultadosPage {

	@FindBy(how = How.XPATH, using = "")
	WebElement primerElemento;

	WebDriver driver;

	public ResultadosPage (WebDriver driver){
		
		this.driver = driver;
		
		
		PageFactory.initElements(driver, this);	
		
		if (!SeleniumUtils.isPresentByPresenceOfElement(primerElemento, driver)){
			throw new IllegalStateException("Page did not load.");
		}
		
		
		
		
	}
	
	public void lista() {
		List<WebElement> listaWE;
		listaWE = driver.findElements(By.xpath("//li[@class=\"s-result-item s-result-card-for-container a-declarative celwidget  \"]/div[@class=\"s-item-container\"]"));
		WebElement primerelmento = listaWE.get(0);
		
		
	}
	
	public PrimerResultado seleccionarPrimerElemento() {
		primerElemento.click();
		
		return new PrimerResultado(driver);
	}

}
