package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BingSearchResultsPage extends PageObject {
	@FindBy(how = How.XPATH, using = "//*[@class='rc']/h2/a")
	private WebElement results;
	
	public BingSearchResultsPage(WebDriver driver) {
        super(driver);
	}
	public  List<WebElement> BingElements(){
		List<WebElement> BingElements = driver.findElements(By.xpath("//*[@class='b_algo']/h2/a"));
		return BingElements;
	}
	} 


