package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonHome {
	protected WebDriver driver;
	
	public AmazonHome(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#twotabsearchtextbox"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#twotabsearchtextbox")
	WebElement searchInput;
	
	@FindBy(css="input[value='Go']")
	WebElement searchButton;
	
	public AmazonSearchPage searchFill(String search) {
		searchInput.sendKeys(search);
		searchButton.click();
		return new AmazonSearchPage(driver);
	}

}
