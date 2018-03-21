package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaCheckout {
	protected WebDriver driver;
	
	public PedidosYaCheckout(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilVisible(By.cssSelector(".cart-subtitle a"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart-subtitle a")
	WebElement modificarPedidoLink;
	
	public PedidosYaOrderOverview navigateToOrderOverview(WebDriver driver) {
		modificarPedidoLink.click();
		return new PedidosYaOrderOverview(driver);
	}

}
