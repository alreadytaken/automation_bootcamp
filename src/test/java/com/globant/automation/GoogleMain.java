package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleMain{
	
	private WebDriver driver;
	
	@FindBy (how = How.NAME, using = "q")
	WebElement searchBox;
	
	@FindBy (how = How.CSS, using = "input[value='Buscar con Google']")
	WebElement searchButton;
	
	public GoogleMain(WebDriver driver) {
		this.driver=driver;
		SeleniumUtils.WaitUntilClickable(By.name("q"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public GoogleSearchResult search(String termino) {	
	searchBox.sendKeys(termino);
	searchButton.click();
	return new GoogleSearchResult(driver);

	}
}
	


/*	

return resultadosgoogletext;*/