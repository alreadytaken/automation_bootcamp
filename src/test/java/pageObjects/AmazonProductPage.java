package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonProductPage {
	protected WebDriver driver;
	
	public AmazonProductPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#cr-medley-top-reviews-wrapper"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#cr-medley-top-reviews-wrapper")
	WebElement allReviews;
	
	@FindBy(css="#dp-summary-see-all-reviews")
	WebElement seeAllReviewsButton;
	
	public String getTopReview() {
		WebElement aux = allReviews.findElement(By.cssSelector("div[class=\"a-section celwidget\"]"));
		return aux.getText();
	}
	public AmazonReviewPage navigateToReviewsPage() {
		seeAllReviewsButton.click();
		return new AmazonReviewPage(driver);
	}

}
