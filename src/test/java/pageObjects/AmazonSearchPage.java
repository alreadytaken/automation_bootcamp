package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonSearchPage {
	private WebDriver driver;
	////s-access-image cfMarker
	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.className("s-result-item s-result-card-for-container a-declarative celwidget"),driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "s-result-item s-result-card-for-container a-declarative celwidget")
	List <WebElement> results;
	
	/*public List<WebElement> Resultado() {
		results.get(1);
		return (List<WebElement>) results.get(1);
	}*/
	
	public void enter() {
results.get(1).click();	}

}
