package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreMainPage {
	protected WebDriver driver;

	public MercadoLibreMainPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='ui-item__content']")
	private WebElement oferta;

	public String[] obtenerDatosOferta() {
		String[] ret = new String[3];
		 SeleniumUtils.waitUntilClickable(oferta, driver);
		// ret[0] =
		// oferta.findElement(By.xpath("//p[@class='ui-item__title']")).getText();
		// ret[1] =
		// oferta.findElement(By.xpath("//span[@class='price-tag-fraction']")).getText();
		// ret[2] =
		// oferta.findElement(By.xpath("//span[@class='ui-item__discount-text']")).getText();
		Actions mouseOver = new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@class='ui-item__image-container']")));
		SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='floating-banner']"), driver);
		mouseOver.build().perform();
		// ret[0] = oferta.findElement(By.className("ui-item__title")).getText();
		ret[0] = SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='ui-item__content']/p"), driver).getText();
		ret[1] = oferta.findElement(By.className("ui-item__price")).getText();
		ret[2] = oferta.findElement(By.className("ui-item__discount-text")).getText();

		return ret;
	}

	public MercadoLibreItemPage clickOferta() {
		driver.findElement(By.xpath("//div[@class='ui-item__image-container']")).click();
		return new MercadoLibreItemPage(driver);
	}

}
