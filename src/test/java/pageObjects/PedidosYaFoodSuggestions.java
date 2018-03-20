package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaFoodSuggestions {
	
	protected WebDriver driver;
	
	public PedidosYaFoodSuggestions(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("span.promo"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span.promo")
	WebElement suggestion;
	
	public PedidosYaAddToOrder navigateToAddToOrder(WebDriver driver) {
		suggestion.click();
		return new PedidosYaAddToOrder(driver);
		
	}
}
