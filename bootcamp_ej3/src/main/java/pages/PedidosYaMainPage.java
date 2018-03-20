package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PedidosYaMainPage extends PedidosYaCountrySelectionPage {
	public PedidosYaMainPage(WebDriver d) {
		super(d);
	}

	protected WebDriver driver;

	@FindBy(how = How.NAME, using = "address")
	private WebElement txtDireccion;

	@FindBy(how = How.ID, using = "search")
	private WebElement btnBuscar;
	
	@FindBy(how = How.NAME, using = "optional")
	private WebElement txtOpcional;
	
	public PedidosYaRestaurantSelectionPage buscarDireccion (String direccion, String opcional) {
		txtDireccion.sendKeys(direccion);
		txtOpcional.sendKeys(opcional);
		btnBuscar.click();
		//Esperar para confirmar
		return new PedidosYaRestaurantSelectionPage(driver);
	}
}
