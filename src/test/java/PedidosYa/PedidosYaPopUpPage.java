package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpPage {
	private WebDriver driver;

	
	public PedidosYaPopUpPage(WebDriver driver) {
		this.driver = driver;

		
		
		PageFactory.initElements(driver, this);

		// driver.switchTo().frame(iframe);
		

		/*if (!SeleniumUtils.waitUntilHeWants(By.xpath("//div[@class='tinner']"), driver)) {
			throw new IllegalStateException("Page did not load");
		}

		/*
		 * if (!SeleniumUtils.waitUntilHeWants(By.name("name"), driver)) { throw new
		 * IllegalStateException("Page did not load"); } if
		 * (!SeleniumUtils.waitUntilHeWants(By.name("password"), driver)) { throw new
		 * IllegalStateException("Page did not load"); }
		 */
	}

	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement popupEmail;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement popupPass;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement popupButton;

	@FindBy(id = "modalLogin")
	private WebElement clickpls;

	public void typeUser(String user, String pass) {
		//SeleniumUtils.waitUntilHeWants(By.id("modalLogin"), driver);
		this.clickpls.click();
		//SeleniumUtils.waitUntilClickable(popupEmail, driver);
		this.popupEmail.sendKeys(user);
		this.popupPass.sendKeys(pass);
	}

	public PedidosYaCheckoutPage login() {
		//SeleniumUtils.waitUntilHeWants(By.id("modalLogin"), driver);
		this.clickpls.click();
		//SeleniumUtils.waitUntilClickable(popupEmail, driver);
		this.popupButton.click();
		return new PedidosYaCheckoutPage(driver);
	}

}