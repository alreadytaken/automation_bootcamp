package ExamenBrunoZerpa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TopReviews {

	@FindBy(how = How.XPATH, using ="//div[@class='a-row view-point']//span[@class = 'a-size-base']")
	private List<WebElement> topReviews;
	private WebDriver driver;

	public TopReviews(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPositive() {
		
		return topReviews.get(0).getText();
	}
	
	public String getNegative() {
		
		return topReviews.get(1).getText();
	}
}
