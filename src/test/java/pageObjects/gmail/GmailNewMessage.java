package pageObjects.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailNewMessage {
	protected WebDriver driver;
	
	public GmailNewMessage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("span[class='gbqfi gb_hc']"), driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="div.AD")
	WebElement newMessageDiv;
}
