package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaAddToOrder {
	
	protected WebDriver driver;
	
	public PedidosYaAddToOrder(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#footerOpen a.button"), driver);
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(css = "#footerOpen a.button")
	WebElement addButton;
	
	@FindBy(css = ".has-picture div.price span")
	WebElement itemPrice;
	
	public String getPrice() {
		return itemPrice.getText();
	}
	
	public PedidosYaOrderOverview navigateToOrderOverview(WebDriver driver) {
		addButton.click();
		return new PedidosYaOrderOverview(driver);
		
	}
}
