package ExamenBrunoZerpa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ProductReviewPages {

	@FindBy(how = How.XPATH, using = "//div[@class='a-row a-spacing-large']/a")
	private WebElement seeAllReviews;
	
	private WebDriver driver;

	public ProductReviewPages(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public TopReviews goTopRevies() {
		
		seeAllReviews.click();
		return new TopReviews(driver);
	}
}
