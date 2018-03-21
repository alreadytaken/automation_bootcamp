package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingSearchResult {

	@FindBy (how = How.CSS, using = "li[class='b_algo'] h2 a")
	List <WebElement> bingSearchResults;
	
	public BingSearchResult (WebDriver driver){
		SeleniumUtils.WaitUntilPresenceList(By.cssSelector("li[class='b_algo'] h2 a"), driver);
		PageFactory.initElements(driver, this);
	}
	public List<String> getBingResults() {
		List <String> resultadosbingtext;
		resultadosbingtext = new ArrayList<>();    		
		for (int j=0;j<=5;j++) {
			resultadosbingtext.add(bingSearchResults.get(j).getText());
		}
		return resultadosbingtext;
	}
}
