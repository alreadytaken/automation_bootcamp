package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaFoodSelectionPage extends PedidosYaRestaurantSelectionPage {

	public PedidosYaFoodSelectionPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
		menuPopUp = SeleniumUtils.waitUntilClickable(By.id("menuModal"), driver);
	}
	
	//@FindBy (how = How.CSS, using = "div[class='tcontent']")
	private WebElement menuPopUp;
	
	public String obtenerPrecio () {
		SeleniumUtils.waitUntilClickable(By.id("footerOpen"), driver);
		return menuPopUp.findElement(By.className("price")).getText();
	}
	

}
