package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaMainPage extends PedidosYaCountrySelectionPage {
	public PedidosYaMainPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "address")
	private WebElement txtDireccion;

	@FindBy(how = How.ID, using = "search")
	private WebElement btnBuscar;

	@FindBy(how = How.NAME, using = "optional")
	private WebElement txtOpcional;

	public PedidosYaRestaurantSelectionPage buscarDireccion(String direccion, String opcional) {
		txtDireccion.sendKeys(direccion);
		txtOpcional.sendKeys(opcional);
		btnBuscar.click();
		SeleniumUtils.waitUntilClickable(By.id("confirm"), driver).click();
		return new PedidosYaRestaurantSelectionPage(driver);
	}
}
