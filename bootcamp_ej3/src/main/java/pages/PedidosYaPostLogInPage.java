package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPostLogInPage extends PedidosYaPopUpLogIn {

	public PedidosYaPostLogInPage(WebDriver d) {
		super(d);
	}

	private WebElement txtConfirmation;

	public boolean isLogged() {
		txtConfirmation = SeleniumUtils.waitUntilClickable(By.className("js-title-text"), driver);
		return txtConfirmation.equals("Seleccioná tu dirección de entrega");
	}

}
