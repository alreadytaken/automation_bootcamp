package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaSignInForm {
	protected WebDriver driver;
	
	public PedidosYaSignInForm(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilVisible(By.cssSelector("#login"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#divFormContainer")
	WebElement formContainer;
	
	WebElement formTitle = formContainer.findElement(By.cssSelector("h1"));
	
	public Boolean loginFormPresence() {
		Boolean aux = false;
		if (formTitle.getText().trim()=="Ingresar a mi cuenta") {
			aux = true;
		}
		return aux;
				
	}
}
