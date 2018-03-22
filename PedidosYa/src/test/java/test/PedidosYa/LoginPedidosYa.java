package test.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class LoginPedidosYa {

	@FindBy(how = How.ID, using = "email")
	private WebElement email;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement password;
	
	@FindBy(how = How.ID, using = "login")
	private WebElement loginButton;
	
	private WebDriver driver;
	
	public LoginPedidosYa(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(email, driver);
	}
	
	public UsuarioLogueadoFinalizarPedido ingresarDatos(String em, String pwd) {
		
		this.email.sendKeys(em);
		this.password.sendKeys(pwd);
		loginButton.click();
		driver.switchTo().defaultContent();
		return new UsuarioLogueadoFinalizarPedido(driver);
	}
}
