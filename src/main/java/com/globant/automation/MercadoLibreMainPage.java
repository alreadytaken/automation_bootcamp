package com.globant.automation;

import java.util.List;

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
		SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='floating-banner']"), driver);
	}

	@FindBy(how = How.CSS, using = ".recommendations img[class='ui-item__image']")
	private List<WebElement> imagenes;

	@FindBy(how = How.CSS, using = "span[class='price-tag ui-item__price']")
	private List<WebElement> precioOfertas;

	@FindBy(how = How.CSS, using = "p[class='ui-item__title']")
	private List<WebElement> nombreOfertas;

	@FindBy(how = How.CSS, using = "span[class='ui-item__discount-text']")
	private List<WebElement> descuentoOfertas;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-item__content']")
	private WebElement oferta;

	public String[] obtenerDatosOferta() {
		String[] ret = new String[3];
		//SeleniumUtils.waitUntilClickable(oferta, driver);
		SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='floating-banner']"), driver);
		// mouseOver.build().perform();
		ret[0] = SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='ui-item__content']/p"), driver).getText();
		ret[1] = oferta.findElement(By.className("ui-item__price")).getText();
		ret[2] = oferta.findElement(By.className("ui-item__discount-text")).getText();

		return ret;
	}

	public String[] obtenerDatosOferta(int a) {
		String[] ret = new String[3];
		// Actions mouseOver = new Actions(driver).moveToElement(nombreOfertas.get(a));
		// mouseOver.build().perform();
		ret[0] = imagenes.get(a).getAttribute("alt");
		String[] temp = precioOfertas.get(a).getText().split("\n");
		ret[1] = temp[0] + temp[1];
		ret[2] = descuentoOfertas.get(a).getText();
		return ret;
	}

	public MercadoLibreItemPage clickOferta(int a) {
		//driver.findElement(By.xpath("//div[@class='ui-item__image-container']")).click();
		imagenes.get(a).click();
		return new MercadoLibreItemPage(driver);
	}

}
