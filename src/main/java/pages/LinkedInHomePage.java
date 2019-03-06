package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInHomePage extends BasePage {

	public LinkedInHomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = ("//input[@class='login-email reg-field__input']"))
	private WebElement email;

	@FindBy (xpath = ("//input[@class='login-password reg-field__input']"))
	private WebElement password;

	@FindBy (xpath = ("//input[@class='login submit-button']"))
	private WebElement submitButton;


	public LinkedInHomePage insertEmail(String str) {
		email.sendKeys(str);
		return new LinkedInHomePage(driver);

	}
	public LinkedInHomePage insertPassword(String str) {
		password.sendKeys(str);
		return new LinkedInHomePage(driver);
	}

	public LinkedInResPage submit() {		
		submitButton.click();
		return new LinkedInResPage(driver);

	}

}

