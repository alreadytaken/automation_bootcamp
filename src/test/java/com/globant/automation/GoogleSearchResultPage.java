package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchResultPage extends PageObject {
	@FindBy(how = How.XPATH, using = "//*[@class='rc']/h3/a")
	private WebElement results;
	
	public GoogleSearchResultPage(WebDriver driver) {
        super(driver);
	}
	public  List<WebElement> GoogleElements(){
		List<WebElement> GoogleElements = driver.findElements(By.xpath("//*[@class='rc']/h3/a"));
		return GoogleElements;
	}
	}



