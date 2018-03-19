package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage{

	@FindBy(how = How.NAME, using = "q")
	public static WebElement txtsearchG;
	
	List <WebElement> resG;
	WebDriver driver;
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		
		if(!SeleniumUtils.isPresent(By.name("q"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		PageFactory.initElements(driver, this);		
	}

	
	
	//WebElement txtsearchG = driver.findElement(By.name("q"));
	
	public void sendDataGoogle(String dataG) {
		txtsearchG.sendKeys(dataG);
	}
	
	public void listaResultados() {
	resG = driver.findElements(By.xpath("//div[@class='rc']/h3/a"));
	}
	
	
	
}//class
