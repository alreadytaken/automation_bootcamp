package pageObjects.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailPassword {
	protected WebDriver driver;
	
	public GmailPassword(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("div#password input"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.qhFLie span[class='RveJvd snByac']")
	WebElement nextButton;
	
	@FindBy(css="div#password input")
	WebElement passwordField;
	
	public GmailInbox fillPasswordField(String password) {
		passwordField.sendKeys(password);
		nextButton.click();
		return new GmailInbox(driver);
	}
	
}
