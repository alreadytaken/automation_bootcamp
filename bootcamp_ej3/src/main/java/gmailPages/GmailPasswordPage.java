package gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailPasswordPage {

	public GmailPasswordPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	private WebElement txtPassword;

	public void ingresarPass(String password) {
		txtPassword = SeleniumUtils.waitUntilVisible(By.cssSelector("input[name='password']"), driver);
		txtPassword.sendKeys(password);
		txtPassword.submit();
	}

}
