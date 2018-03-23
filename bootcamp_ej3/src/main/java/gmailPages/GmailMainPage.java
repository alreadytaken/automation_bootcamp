package gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailMainPage {

	public GmailMainPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy(id = "identifierId")
	private WebElement eMail;

	@FindBy(css = "span[class='RveJvd snByac']")
	private WebElement btnContinuar;

	public GmailPasswordPage ingresarEmail(String mail) {
		eMail.sendKeys(mail);
		eMail.submit();
		//btnContinuar.click();
		return new GmailPasswordPage(driver);
	}

}
