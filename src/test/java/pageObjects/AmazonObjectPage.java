package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonObjectPage {
	private WebDriver driver;

	//
	public AmazonObjectPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.xpath("//*[@id=\"reviews-medley-footer\"]/div[1]/a"), driver);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"reviews-medley-footer\\\"]/div[1]/a")
	private WebElement seeMore;

	public void moreComments() {
		seeMore.click();
	}
}