package TestMail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.SeleniumUtils;

public class GmailLoginPage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//input[@id='identifierId']")
	private WebElement usernametextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement passwordtextbox;
	
	
	
	public GmailLoginPage (WebDriver driver) {
	    super(driver);
	}
	
	public void entermail(String input) {
		WebElement usernametextbox = SeleniumUtils.waitUntilClickable(By.xpath("//input[@id='identifierId']"), driver);
		usernametextbox.sendKeys(input);
		usernametextbox.sendKeys(Keys.ENTER);
	}
	
	public void enterpassword(String input) {
		WebElement passwordtextbox = SeleniumUtils.waitUntilClickable(By.xpath("//input[@name='password']"), driver);
		passwordtextbox.sendKeys(input);
		}
	
	public MailInboxPage enter() {
		
		passwordtextbox.sendKeys(Keys.ENTER);
		return new MailInboxPage(driver);
	}

}
