package com.globant.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	public static WebElement WaitUntilClickable(WebElement e,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(e));
	}
	public static WebElement WaitUntilClickable(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(localizador));
	}
	public static WebElement WaitUntilPresence(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(localizador));
	}
	public static List<WebElement> WaitUntilPresenceList(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(localizador));
	}
	public static List <WebElement> WaitUntilVisibilityList(By localizador,WebDriver driver){
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
	}
	//lista elementos timeout
	
}
