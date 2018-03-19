package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class BingHome {
	protected WebDriver driver;
	
	public BingHome(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("sb_form_go"), driver);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.ID, using = "sb_form_q")
	private WebElement searchBar;
	
	public BingResults searchQuery(String search) {
		searchBar.sendKeys(search);
		searchBar.submit();
		return new BingResults(driver);
	}
}
