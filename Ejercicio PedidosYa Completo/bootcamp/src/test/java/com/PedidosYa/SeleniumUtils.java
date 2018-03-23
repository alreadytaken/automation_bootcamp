package com.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static WebElement waitUntilClickable(WebElement e, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(e));

	}

	public static WebElement waitUntilClickable(By localizador, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(localizador));

	}

	public static WebElement waitUntilPresence(By localizador, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(localizador));

	}

	public static WebElement waitUntilVisibility(WebElement e, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(e));

	}

	public static WebElement waitUntilVisibility(By e, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf((WebElement) e));

	}
}
