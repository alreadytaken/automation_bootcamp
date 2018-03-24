package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonCommentPage {
	private WebDriver driver;
	
	public AmazonCommentPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.className("a-size-base a-link-normal 5star"), driver);
		PageFactory.initElements(driver, this);

	}//a-size-base

	@FindBy(how = How.CLASS_NAME, using = "a-size-base")
	List <WebElement> results;
	
	public void comments() {
		String comment1 = results.get(0).getText();
		String comment2 = results.get(1).getText();
			}
	
	
	
	
}
