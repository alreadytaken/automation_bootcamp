package mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class gmailPage {

	@FindBy(how = How.ID, using = "identifierId")
	private WebElement emailBox;
	
	private WebDriver driver;
	
	public gmailPage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(emailBox, driver);
	}

	public WelcomePage enterEmail(String emailUser) {
		
		emailBox.sendKeys(emailUser);
		emailBox.submit();	
		return new WelcomePage(driver);
	}
		
}

