package pedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmPage {
// id confirm
//https://staging.pedidosya.com
	private WebDriver driver;
	public PedidosYaConfirmPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.id("confirm"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "confirm")
	private WebElement confirmButton;
}
