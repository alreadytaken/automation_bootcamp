package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {
	public AmazonSearchPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy(css = "div[class='s-item-container']")
	private WebElement item;

	public void clickFirstItem() {
		item.click();
	}
}
