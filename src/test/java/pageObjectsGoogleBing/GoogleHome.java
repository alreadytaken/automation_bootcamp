package pageObjectsGoogleBing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GoogleHome {
	
	protected WebDriver driver;
	
	public GoogleHome(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(By.id("gsri_ok0"), driver);
		}
	
	@FindBy(how = How.NAME, using = "q")
	//@FindBy(name = "q")
	private WebElement searchBar;
	
	@FindBy(how = How.ID, using = "gsri_ok0")
	//@FindBy(id = "gsri_ok0")
	private WebElement micButton;
	

	
	public GoogleResults searchQuery(String search) {
		searchBar.sendKeys(search);
		searchBar.submit();
		return new GoogleResults(driver);
	}
	
	

}
