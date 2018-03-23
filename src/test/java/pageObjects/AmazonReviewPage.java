package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonReviewPage {
	protected WebDriver driver;
	
	public AmazonReviewPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#cm_cr-rvw_summary-viewpoints"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='a-row a-spacing-top-mini'] span.a-size-base")
	List<WebElement> topReviews;
	
	public List<String> getTopReviews(){
		List<String> aux =new ArrayList<>();
		aux.add(topReviews.get(0).getText());
		aux.add(topReviews.get(1).getText());
		return aux;
		
	}

}
