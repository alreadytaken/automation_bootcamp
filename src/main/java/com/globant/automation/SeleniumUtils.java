package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	public static WebElement WaitUntilClickable(WebElement e,WebDriver driver) {
		return (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(e));
	}
	public static WebElement WaitUntilClickable(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(localizador));
	}
}
