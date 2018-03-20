package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	
	public static WebElement waitUntilClickable (By by, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static WebElement waitUntilPresent (By by, WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static WebElement waitUntilVisible (By by,WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public static WebElement waitUntilVisible (WebElement we,WebDriver driver) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(we));
	}

}
