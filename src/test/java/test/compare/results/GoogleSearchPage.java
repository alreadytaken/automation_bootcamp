package test.compare.results;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GoogleSearchPage {

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchText;
	
	@FindBy(name="btnK")
	private WebElement searchButton;
	
	private WebDriver driver;

	public GoogleSearchPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(searchButton, driver);
	}
	public GoogleResultsPage realizeGoogleSearch(String s) {
		
		searchText.sendKeys(s);
		searchText.submit();
		return new GoogleResultsPage(driver);
	}
	
}
