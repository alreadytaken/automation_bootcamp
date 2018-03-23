package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {

	public AmazonMainPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;
	
	@FindBy (id = "twotabsearchtextbox")
	private WebElement searchBar;

	public AmazonSearchPage search(String text) {
		searchBar.sendKeys(text);
		searchBar.submit();
		return new AmazonSearchPage(driver);
	}
	
}
