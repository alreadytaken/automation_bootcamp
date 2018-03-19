package com.globant.automation;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class BingPage{

	WebDriver driver;
	
	public BingPage(WebDriver driver) {
		this.driver = driver;
		
		if(!SeleniumUtils.isPresent(By.name("q"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		PageFactory.initElements(driver, this);		
	}

	List <WebElement> resB;

	@FindBy(how = How.NAME, using ="q")
	public static WebElement txtsearchB;
	

	
	public ResultadosBing SendDataBing(String dataB) {
		txtsearchB.sendKeys(dataB);
		txtsearchB.submit();
		
		return ResultadosBing(driver);
	}
	
	public void listaResultados() {
		resB = driver.findElements(By.xpath("//li[@class='b_algo']/h2/a"));
		}
	
	
}//class