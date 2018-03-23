package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpPageVIEJA {
	private WebDriver driver;

	public PedidosYaPopUpPageVIEJA(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

		SeleniumUtils.isVisible(By.xpath("//div/iframe"), driver);

		WebElement IFRAME = driver.findElement(By.xpath("//div/iframe"));
		driver.switchTo().frame(IFRAME);

	}

	public void typeUser(String user, String pass) {

		SeleniumUtils.waitUntilClickables(By.xpath("//input[@name='email']"), driver);
		WebElement popupEmail = driver.findElement(By.xpath("//input[@name='email']"));
		popupEmail.sendKeys(user);

		WebElement popupPass = driver.findElement(By.xpath("//input[@name='password']"));
		popupPass.sendKeys(pass);
	}

	public PedidosYaCheckoutPage login() {

		WebElement popupButton = driver.findElement(By.xpath("//input[@name='login']"));
		popupButton.click();
		return new PedidosYaCheckoutPage(driver);
	}

}