package com.globant.automation;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
<<<<<<< HEAD
	public static WebElement WaitUntilClickable(WebElement e,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(e));
	}
	public static WebElement WaitUntilClickable(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(localizador));
	}
	public static WebElement WaitUntilPresence(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(localizador));
	}
	public static WebElement WaitUntilVisibility(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(localizador));
	}
	public static List<WebElement> WaitUntilPresenceList(By localizador,WebDriver driver) {
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(localizador));
	}
	public static List <WebElement> WaitUntilVisibilityList(By localizador,WebDriver driver){
		return (new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
	}
	//lista elementos timeout
	
=======
	public static WebElement waitUntilClickable(WebElement e, WebDriver driver) {
		
		return (new WebDriverWait(driver, 180)).until(ExpectedConditions.elementToBeClickable(e));
	}

	public static WebElement waitUntilClickable(By by, WebDriver driver) {
		
		return (new WebDriverWait(driver, 180)).until(ExpectedConditions.elementToBeClickable(by));
	}

>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
}
