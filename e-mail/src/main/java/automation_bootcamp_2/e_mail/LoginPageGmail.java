package automation_bootcamp_2.e_mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageGmail {

	@FindBy(how = How.NAME, using = "identifier")
	WebElement txtcorreo;

	@FindBy(how = How.XPATH, using = "//span[@class=\"RveJvd snByac\" and contains(text(), \"Siguiente\")]")
	WebElement btnsig;

	public WebDriver driver;

	public LoginPageGmail(WebDriver driver) {
		this.driver = driver;

		/**
		 * if(!SeleniumUtils.isPresent(By.name("identifier"), driver)) { throw new
		 * IllegalStateException("Page did not load."); }
		 */

		PageFactory.initElements(driver, this);
	}

	public void ingresarCorreo() {
		txtcorreo.sendKeys("camilasilvalopez@gmail.com");

	}

	public IngresarContraseñaPage clickearBoton() {
		btnsig.click();

		return new IngresarContraseñaPage(driver);
	}

}// class