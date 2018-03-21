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

	public boolean isLogged(String nombreUsuario) {
		txtConfirmation = SeleniumUtils.waitUntilClickable(By.id("lnkUserName"), driver);
		WebElement temp = txtConfirmation.findElement(By.className("top-link"));
		return temp.getText().equals(nombreUsuario);
		
	}

}
