package TestMail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MailInboxPage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'bog')]/b")
	private WebElement subject;
	
	public MailInboxPage (WebDriver driver) {
	    super(driver);
	}
	
	public List<WebElement> mailsubjects() {
		List<WebElement> mailsubjects = driver.findElements(By.xpath("//span[contains(@class,'bog')]/b"));
		return mailsubjects;	
	}
	

}
