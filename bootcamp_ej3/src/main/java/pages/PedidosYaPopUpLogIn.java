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

	private WebElement cuadroDeDatos;// = SeleniumUtils.waitUntilVisible(By.id("modalLogin"), driver);

	public PedidosYaPostLogInPage ingresarDatos(String eMail, String password) {
		
		//cuadroDeDatos = SeleniumUtils.waitUntilVisible(By.id("modalLogin"), driver);
		
		SeleniumUtils.waitUntilVisible(By.cssSelector(".tinner iframe"), driver);
//		WebElement frame = driver.findElement(By.cssSelector(".tinner iframe"));
//		driver.switchTo().frame(frame);
		
		driver.switchTo().frame(1);
//		WebElement temp = SeleniumUtils.waitUntilVisible(By.id("divFormContainer"), driver);
//		WebElement temp2 = temp.findElement(By.className("input-container"));
//		//List<WebElement> input = temp2.findElements(By.className("row"));
//		temp2.findElement(By.name("email")).sendKeys(eMail);
//		temp2.findElement(By.name("password")).sendKeys(password);
		SeleniumUtils.waitUntilClickable(By.name("login"), driver);
		WebElement mail = SeleniumUtils.waitUntilClickable(By.name("email"), driver);
		WebElement pass = SeleniumUtils.waitUntilClickable(By.name("password"), driver);
		mail.sendKeys(eMail);
		pass.sendKeys(password);
		
		WebElement btnConfirmar = SeleniumUtils.waitUntilVisible(By.className("button-container"), driver);
				//temp.findElement(By.className("button-container"));
		btnConfirmar.click();
		driver.switchTo().frame(0);
		return new PedidosYaPostLogInPage(driver);
	}

}
