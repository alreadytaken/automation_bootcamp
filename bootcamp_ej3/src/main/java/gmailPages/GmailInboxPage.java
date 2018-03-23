package gmailPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage {
	public GmailInboxPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy (css = "tr[class='zA yO']")
	private List <WebElement> mailList;

}
