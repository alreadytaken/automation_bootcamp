package com.PedidosYa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PedidosInitPage {

	protected WebDriver driver;

	public PedidosInitPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(BanderaUruguay, driver);

	}

	@FindBy(id = "linkUy")
	WebElement BanderaUruguay;

	@FindBy(xpath = "//li[contains(@class,'flag')]")
	List<WebElement> listFlags;

	public void clickBanderaUruguay() {
		SeleniumUtils.waitUntilClickable(BanderaUruguay, driver);
		BanderaUruguay.click();
	}

	List<WebElement> Banderas;

	public List<WebElement> getFlags() {

		return listFlags;
	}

}
