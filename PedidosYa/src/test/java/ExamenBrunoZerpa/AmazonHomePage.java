package ExamenBrunoZerpa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement searchButton;
	
	private WebDriver driver;

	public AmazonHomePage(WebDriver driver){

		
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchItem(String product) {
		searchButton.sendKeys(product);
		searchButton.submit();
		return new SearchResultPage(driver);
	}
}
