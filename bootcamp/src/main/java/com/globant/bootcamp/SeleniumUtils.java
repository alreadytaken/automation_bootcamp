package com.globant.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static WebElement waitUntilClickeable(WebElement e, WebDriver driver) {
		return (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(e));

	}


	public static boolean isPresent(By localizador, WebDriver driver) {
		return (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(localizador)) != null;
	}

	public static boolean isPresentByPresenceOfElement(WebElement e, WebDriver driver) {

		return (new WebDriverWait(driver, 90)).until(ExpectedConditions.visibilityOf(e)) != null;
	}

	public static boolean isPresentUsingPresence(By localizador, WebDriver driver) {

		return (new WebDriverWait(driver, 90)).until(ExpectedConditions.presenceOfElementLocated(localizador)) != null;
	}

	public static WebElement isPresentUsingPresenceWE(By localizador, WebDriver driver) {

		return (new WebDriverWait(driver, 90)).until(ExpectedConditions.presenceOfElementLocated(localizador));
	}
}