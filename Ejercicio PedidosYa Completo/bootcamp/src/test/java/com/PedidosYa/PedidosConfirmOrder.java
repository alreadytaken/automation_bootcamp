package com.PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestsPedidosYa.TestPedidosYa;

public class PedidosConfirmOrder {

	protected WebDriver driver;
	public static Logger LOG = LogManager.getLogger(TestPedidosYa.class);

	public PedidosConfirmOrder(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(@id,'footerOpen')]/a")
	WebElement buttonAddOrder;

	@FindBy(xpath = "//div[contains(@class,'peyaCard')]/*/a[contains(@id,'order')]")
	WebElement continueButton;

	@FindBy(xpath = "//div[contains(@class,'price total-price')]")
	WebElement precioConfirm;

	@FindBy(xpath = "//div[contains(@class,'left top-link')]")
	WebElement nombreLogeado;

	String DirConf, PrecConf, nomLogeado;

	public String getDirConf() {
		SeleniumUtils.waitUntilClickable(continueButton, driver);
		DirConf = driver.findElement(By.xpath("//div[contains(@class,'peyaCard')]//div[contains(@class,'data')]/span"))
				.getAttribute("title");
		return DirConf;
	}

	public String getPrecConf() {
		SeleniumUtils.waitUntilClickable(continueButton, driver);
		PrecConf = precioConfirm.getText();
		return PrecConf;
	}

	public void clickAddOrder() {
		SeleniumUtils.waitUntilClickable(buttonAddOrder, driver);
		buttonAddOrder.click();
	}

	public void clickContinueButton() {
		SeleniumUtils.waitUntilClickable(continueButton, driver);

		continueButton.click();
	}

	public String getNomLogeado() {
		SeleniumUtils.waitUntilClickable(continueButton, driver);
		nomLogeado = nombreLogeado.getText();
		return nomLogeado;
	}

}
