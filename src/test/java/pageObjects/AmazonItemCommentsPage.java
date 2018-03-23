package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonItemCommentsPage {
	public AmazonItemCommentsPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		topComments = featuredComments.findElements(By.cssSelector("span[class='a-size-base']"));
	}

	private WebDriver driver;
	
	@FindBy(id = "cm_cr-rvw_summary-viewpoints")
	private WebElement featuredComments;
	
	private List<WebElement> topComments;
	
	public String getTopPositiveComment() {
		return topComments.get(0).getText();
	}
}
