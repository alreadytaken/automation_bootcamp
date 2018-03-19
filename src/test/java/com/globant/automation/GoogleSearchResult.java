package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult {
	

	@FindBy (how = How.XPATH, using = "//div[@class='rc']/h3/a")
	List <WebElement> searchResults;
	
	public GoogleSearchResult(WebDriver driver) {
		searchResults=SeleniumUtils.WaitUntilVisibilityList(By.xpath("//div[@class='rc']/h3/a"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getResults() {
	List <String> resultadosgoogletext;
	resultadosgoogletext = new ArrayList<String>();
	for (int i=0;i<=5;i++) {
		resultadosgoogletext.add(searchResults.get(i).getText());
	}
	return resultadosgoogletext;
	}
}
