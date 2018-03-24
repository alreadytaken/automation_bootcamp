package ExamenBrunoZerpa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage {

	@FindBy(how = How.XPATH, using = "//div[@id = 'resultsCol']//ul//li")
	private List<WebElement> results;
	
	private WebDriver driver;

	public SearchResultPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductReviewPages clickFisrt() {
		results.get(0).click();
		
		return new ProductReviewPages(driver);
	}
}
