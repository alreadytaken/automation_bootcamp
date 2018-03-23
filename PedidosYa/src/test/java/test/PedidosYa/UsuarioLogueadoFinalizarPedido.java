package test.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class UsuarioLogueadoFinalizarPedido {

	@FindBy(how = How.LINK_TEXT, using = "Modificar mi pedido")
	private WebElement modificarPedido;

	private WebDriver driver;

	public UsuarioLogueadoFinalizarPedido(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(modificarPedido, driver);
	}

	public ChequearUserNamePage modificarMiPedido() {

		modificarPedido.click();
		return new ChequearUserNamePage(driver);
	}
}
