package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailHomePage2 {
//password name
	private WebDriver driver;

	public GmailHomePage2(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.name("password"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "password")
	public WebElement passwordTXT;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"passwordNext\"]/content/span")
	public WebElement buttonNext;

	public void enterInfo(String password) {
		SeleniumUtils.waitUntilClickable(By.name("password"), driver);
		passwordTXT.sendKeys(password);
		//passwordTXT.submit();
		buttonNext.click();
	}
}
