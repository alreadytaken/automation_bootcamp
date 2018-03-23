package automation_bootcamp_2.e_mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IngresarContraseñaPage {

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPass;
	
	@FindBy(how = How.XPATH, using = "//span[@class=\"RveJvd snByac\" and contains(text(), \"Siguiente\")]")
	WebElement btnSig;
	
	public WebDriver driver;

	
	public IngresarContraseñaPage(WebDriver driver) {
		this.driver = driver;
		
		if(!SeleniumUtils.isPresent(By.name("password"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		
		PageFactory.initElements(driver, this);	
	}
	
	
	public PrincipalPage ingresarPass() {
		txtPass.sendKeys("cami5017279423");
		btnSig.click();
		return new PrincipalPage(driver);
	}
	
	
}
