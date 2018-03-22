package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaLogInPage {
	private WebDriver driver;
	////*[@id="modalLogin"]
	public PedidosYaLogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how = How.XPATH, using = "//div[@class=\"tcontent\"]/iframe")
	private WebElement iFrame;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement emailTxt;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordTxt;
	
	@FindBy(how = How.ID, using = "login")
	private WebElement login;
	
	public void LogIn (String email, String password) {
		//SeleniumUtils.waitUntilPresent(By.xpath("modalLogin"), driver);
		driver.switchTo().frame(SeleniumUtils.waitUntilClickable(By.xpath("//div[@class=\"tcontent\"]/iframe"), driver));
		SeleniumUtils.waitUntilPresent(By.id("login"), driver);
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		login.click();
		driver.switchTo().defaultContent();
		}
	
	
	
}
