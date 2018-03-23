package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmarPedidoPage {
	@FindBy(how = How.XPATH, using = "//*[@id=\"deliveryAddressList\"]//b")
	WebElement lblName;

	WebDriver driver;

	public ConfirmarPedidoPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		if (!SeleniumUtils.isPresentByPresenceOfElement(lblName, driver)) {
			throw new IllegalStateException("Page did not load.");
		}
	}

	public String tomarNombre() {

		String name = driver.findElement(By.xpath("//*[@id=\"deliveryAddressList\"]//b")).getAttribute("innerText");
		return name;
	}
}
