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
		SeleniumUtils.waitUntilVisible(By.cssSelector(".tinner iframe"), driver);
		WebElement frame = driver.findElement(By.cssSelector(".tinner iframe"));
		driver.switchTo().frame(frame);
		SeleniumUtils.waitUntilClickable(By.cssSelector("#loginDiv #login"), driver);
		PageFactory.initElements(driver, this);
		

	}

//	@FindBy(css = ".tinner")
//	WebElement formContainer;
	
//	@FindBy(css = ".tinner iframe")
//	WebElement loginIFrame;
	
	@FindBy(css = "#loginDiv input#email")
	WebElement emailField;
	
	@FindBy(css = "#loginDiv input#password")
	WebElement passwordField;
	
	@FindBy(css = "#loginDiv #login")
	WebElement loginButton;
	
	@FindBy(css = "#loginDiv")
	WebElement loginDiv;
	
	//WebElement formTitle = formContainer.findElement(By.cssSelector("h1"));
	
//	public Boolean loginFormPresence() {
//		Boolean aux = false;
//		if (formContainer.isDisplayed()) {
//			aux = true;
//		}
//		return aux;
//	}
	
	public void fillLogInForm(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);	
	}
	
	public PedidosYaCheckout navigateToCheckout(WebDriver driver) {
		loginButton.click();
		driver.switchTo().parentFrame();
		return new PedidosYaCheckout(driver);
	}
	
	public Boolean checkFrame() {
		Boolean aux = false;
		aux = loginDiv.isDisplayed();
		return aux;
	}

}
