package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtils {
	
	public static WebElement waitUntilClickable(WebElement e, WebDriver driver) {
		return new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(e));	
	}
	public static WebElement waitUntilClickable(By by , WebDriver driver) {
		return new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(by));	
	}
	public static boolean isPresent(By by , WebDriver driver) {
		return (new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(by)))!=null;	
	}
	public static boolean isVisible(By by , WebDriver driver) {
		return (new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(by)))!=null;	
	}
	
	

}
