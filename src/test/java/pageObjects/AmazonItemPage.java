package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonItemPage {
	public AmazonItemPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy(id = "dp-summary-see-all-reviews")
	private WebElement btnComments;

	public AmazonItemCommentsPage goToComments() {
		btnComments.click();
		return new AmazonItemCommentsPage(driver);
	}

}
