package TestPedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.SeleniumUtils;

public class RestaurantePage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//header[@class='has-picture']//div[@class='price']")
	private WebElement PrecioMilanga;
	
	@FindBy(how = How.XPATH, using = "//a[@class='button']")
	private WebElement AgregarPedidoButton;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Nicaragua')]")
	private WebElement Address;
	
	@FindBy(how = How.XPATH, using = "//div[@class='price total-price']")
	private WebElement Price;
	
	@FindBy(how = How.ID, using = "order")
	private WebElement ContinuarButton;
	
	
	
	public RestaurantePage (WebDriver driver) {
	    super(driver);
	}
	
	public WebElement getpreciopopup() {
		WebElement AgregarPedidoButton = SeleniumUtils.waitUntilClickable(By.xpath("//a[@class='button']"), driver);
		return PrecioMilanga;
	}
	
	public WebElement getpreciofinal() {
		WebElement ContinuarButton = SeleniumUtils.waitUntilClickable(By.id("order"), driver);
		return Price;

	}
	
	public WebElement getaddress() {
		WebElement ContinuarButton = SeleniumUtils.waitUntilClickable(By.id("order"), driver);
		return Address;

	}
	
	
	
	public void click() {
		AgregarPedidoButton.click();
	}

}
