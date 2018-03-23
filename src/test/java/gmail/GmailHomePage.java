package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailHomePage {
	private WebDriver driver;

	public GmailHomePage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("identifierId"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "identifierId")
	public WebElement emailTXT;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"identifierNext\"]/content/span")
	public WebElement buttonNext;

	public void enterInfo(String email) {
		emailTXT.sendKeys(email);
		//emailTXT.submit();
		buttonNext.click();
	}

}
