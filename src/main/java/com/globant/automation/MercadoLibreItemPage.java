package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreItemPage extends MercadoLibreMainPage{

	public MercadoLibreItemPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}
	
	public String [] obtenerDatos () {
		String[] ret = new String[3];
		ret[0] = SeleniumUtils.waitUntilClickable(By.xpath("//header[@class='item-title']"), driver).getText();
		ret[1] = SeleniumUtils.waitUntilClickable(By.xpath("//span[@class='price-tag']"), driver).getText() + "\n,";
		ret[2] = SeleniumUtils.waitUntilClickable(By.xpath("//div[@class='price-tag discount-arrow arrow-left']"), driver).getText();
		return ret;
	}

}
