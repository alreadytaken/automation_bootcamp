package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.util.SeleniumUtils;

public class AmazonHomePage {
	private WebDriver driver;
	// twotabsearchtextbox id

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.id("twotabsearchtextbox"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement searchTxt;

	public void enterInfo(String search) {
		searchTxt.sendKeys(search);
		searchTxt.submit();
	}
}
