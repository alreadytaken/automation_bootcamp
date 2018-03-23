package mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class WelcomePage {

	@FindBy(how = How.ID, using = "//input[@type='password']")
	private WebElement passwordBox;
	
	@FindBy(how = How.ID, using = "//input[@name='password']")
	private WebElement modal;
	
	private WebDriver driver;
	
	public WelcomePage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(passwordBox, driver);
	}
	
	public LoggedUser enterPassword(String password) {
		passwordBox.sendKeys(password);
		passwordBox.submit();
		return new LoggedUser(driver);
	}
}
