package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpLogIn extends PedidosYaFoodSelectionPage {

	public PedidosYaPopUpLogIn(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	private WebElement cuadroDeDatos = SeleniumUtils.waitUntilVisible(By.className("user-form"), driver);

	public PedidosYaPostLogInPage ingresarDatos(String eMail, String password) {
		List<WebElement> input = cuadroDeDatos.findElements(By.className("row"));
		input.get(0).sendKeys(eMail);
		input.get(1).sendKeys(password);
		WebElement btnConfirmar = cuadroDeDatos.findElement(By.className("button-container"));
		btnConfirmar.click();
		return new PedidosYaPostLogInPage(driver);
	}

}
