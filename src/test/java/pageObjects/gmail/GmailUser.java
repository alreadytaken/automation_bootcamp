package pageObjects.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailUser {
	protected WebDriver driver;
	
	public GmailUser(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#identifierId"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#identifierId")
	WebElement emailField;
	
	@FindBy(css = "div.qhFLie span[class='RveJvd snByac']")
	WebElement nextButton;
	
	public GmailPassword fillEmailField(String email) {
		emailField.sendKeys(email);
		nextButton.click();
		return new GmailPassword(driver);
		
	}
	

}
