package test.compare.results;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class BingSearchPage {

	@FindBy(how = How.ID, using = "sb_form_q")
	private WebElement searchText;
	
	@FindBy(how = How.ID, using = "sb_form_go")
	private WebElement searchButton;
	
	private WebDriver driver;

	public BingSearchPage(WebDriver driver){
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(searchButton, driver);
	}
	
	public BingResultsPage realizeBingSearch(String s) {
		
		searchText.sendKeys(s);
		searchText.submit();	
		return new BingResultsPage(driver);
	}
}



