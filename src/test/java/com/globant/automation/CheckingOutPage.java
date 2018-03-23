package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckingOutPage {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@class='peyaCard']//div[@class='data']/span")
	WebElement addressShowBox;
	@FindBy(how = How.XPATH, using = "//div[@id='content']//div[@class='price total-price']")
	WebElement precioInputBox;
	@FindBy(how = How.XPATH, using = "//div[@id='content']//a[@id='order']")
	WebElement continueButton;

	public CheckingOutPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div[@class='peyaCard']//div[@class='data']/span"), driver);
		PageFactory.initElements(driver, this);
	}

	public String getDireccion() {
		String dirDespuesAgregado = addressShowBox.getText();
		return dirDespuesAgregado;
	}

	public String getPrecio() {
		String precioDespuesAgregado = precioInputBox.getText();
		return precioDespuesAgregado;
	}

	public LogInPopUp clickContinuar() {
		continueButton.click();
		WebElement iFrameLogin = SeleniumUtils.WaitUntilPresence(By.xpath("//div[@class='tcontent']/iframe"), driver);
		driver.switchTo().frame(iFrameLogin);
		return new LogInPopUp(driver);
	}
}
