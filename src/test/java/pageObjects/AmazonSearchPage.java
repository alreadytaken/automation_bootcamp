package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonSearchPage {
	protected WebDriver driver;
	
	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("ul#s-results-list-atf"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul#s-results-list-atf")
	WebElement allSearchResults;
	
	public AmazonProductPage getFirstProduct() {
		WebElement aux = allSearchResults.findElement(By.cssSelector("li[class='s-result-item s-result-card-for-container a-declarative celwidget  ']"));
		aux.click();
		return new AmazonProductPage(driver);
	}
	

}
