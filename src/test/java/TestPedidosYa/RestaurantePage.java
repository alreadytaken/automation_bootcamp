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
	
	
	
	public RestaurantePage (WebDriver driver) {
	    super(driver);
	}
	
	public WebElement getprecio(String precio) {
		WebElement AgregarPedidoButton = SeleniumUtils.waitUntilClickable(By.xpath("//a[@class='button']"), driver);
		return PrecioMilanga;
	}
	
	public void click() {
		AgregarPedidoButton.click();
	}

}
